package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User passports : users.keySet()) {
            if (passports.getPassport().equals(passport)) {
                rsl = passports;
            }
            break;
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account rsl = null;
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcBalance = findByRequisite(srcPassport, srcRequisite);
        Account destBalance = findByRequisite(destPassport, destRequisite);
        if (srcBalance != null && destBalance != null) {
            if (srcBalance.getBalance() >= amount) {
                srcBalance.setBalance(srcBalance.getBalance() - amount);
                destBalance.setBalance(destBalance.getBalance() + amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
