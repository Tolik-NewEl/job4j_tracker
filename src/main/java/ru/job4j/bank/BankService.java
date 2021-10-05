package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает модель банковской системы, в которой можно
 * добавлять пользователя и его счета, искать пользователя
 * по реквизитам, переводить деньги между счетами
 * @author Anatoliy Tsepushtanov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение списка пользователей с их счетами осуществляется
     * к карте типа Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход нового пользователя для создания.
     * Проверяет наличие пользователя в списке, и при отсутствии
     * создает его с пустым списком счетов.
     * @param user пользователь для создания
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     * Метод создает счет пользователя. На вход принимает параметры
     * паспорт и счет. По паспорту ищет наличие пользователя в системе
     * и создает ему счет, если такового у него нет.
     * @param passport паспорт пользователя для проверки
     * @param account счет пользователя для проверки/создания
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            if (!users.get(user.get()).contains(account)) {
                users.get(user.get()).add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту. Если не находит,
     * возвращает null.
     * @param passport паспорт пользователя для поиска в карте
     * @return возвращает пользователя с указанным паспортом, либо null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счета пользователя по реквизитам.
     * По паспорту находит список счетов пользователя
     * В списке счетов ищет и возвращает необходимый счет,
     * если не находит, возвращает null
     * @param passport паспорт пользователя для поиска
     * @param requisite реквизиты счета для поиска
     * @return возвращает искомый счет или null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
        return users.get(user.get())
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst();
        }
        return Optional.empty();
    }

    /**
     * Метод переводит деньги с одного счета пользователя на другой его счет
     * Производится проверка для возможности перевода:
     * существование счетов, доступная сумма перевода.
     * @param srcPassport паспорт исходного счета
     * @param srcRequisite реквизиты исходного счета
     * @param destPassport паспорт счета для перевода
     * @param destRequisite реквизиты счета для перевода
     * @param amount сумма перевода
     * @return выполнен ли перевод (true или false)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcBalance = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destBalance = findByRequisite(destPassport, destRequisite);
        if (srcBalance.isPresent() && destBalance.isPresent()
                && srcBalance.get().getBalance() >= amount) {
                srcBalance.get().setBalance(srcBalance.get().getBalance() - amount);
                destBalance.get().setBalance(destBalance.get().getBalance() + amount);
                rsl = true;
            }
        return rsl;
    }
}
