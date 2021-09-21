package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту. Если не находит,
     * возвращает null.
     * @param passport паспорт пользователя для поиска в карте
     * @return возвращает пользователя с указанным паспортом, либо null
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User passports : users.keySet()) {
            if (passports.getPassport().equals(passport)) {
                rsl = passports;
                break;
            }
        }
        return rsl;
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
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account rsl = null;
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
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
        Account srcBalance = findByRequisite(srcPassport, srcRequisite);
        Account destBalance = findByRequisite(destPassport, destRequisite);
        if (srcBalance != null && destBalance != null && srcBalance.getBalance() >= amount) {
                srcBalance.setBalance(srcBalance.getBalance() - amount);
                destBalance.setBalance(destBalance.getBalance() + amount);
                rsl = true;
            }
        return rsl;
    }
}
