package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы
 * @author Andrey Baranov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним счетами
     * в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему,
     * если такого пользователя там нет
     * @param user пользователь, которого нужно добавить в банковскую систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы по папорту
     * @param passport паспорт пользователя, которого нужно удалить из системы
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счет пользователю.
     * Сначала ещется пользователь по паспорту, которому нужно добавить счет
     * Если пользователь найден, проверяется что такого счета у пользователя нет
     * Если такого счета у пользователя нет - счет добавляется к списку счетов пользователя
     * @param passport паспорт пользователя, которому нужно добавить счет
     * @param account смчет, который нужно добавить пользователю
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
     * Метод ищет пользователя по паспорту
     * Метод перебирает всех пользователей банка
     * и ищет пользователя с подходящим паспортом
     * @param passport паспорт пользователя, которого нужно найти
     * @return возвращет найденного пользователя
     * или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет пользователя по реквизитам
     * Сначала производится поиск пользователя по паспорту
     * Если пользователь найдет - производится поиск нужного счета в списке счетов пользователя
     * @param passport паспорт пользователя, у которого необходимо найти счет
     * @param requisite реквезиты счета, который нужно найти у пользователя
     * @return возвращает true если счет у пользователя найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> accounts = users.get(user);
        return accounts.stream()
                .filter(account -> requisite.equals(account.getRequisite()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * Производится поиск счета, откуда будут списаны деньги
     * Производится поиск куда будут зачислены деньги
     * Если счет списания и счет зачисления найдены, и на счете списания достаточно средств,
     * производится перевод денежных средств со счета списания на счет зачисления
     * @param srcPassport паспорт пользователя, у которого будут списаны деньги
     * @param srcRequisite счет списания
     * @param destPassport паспорт пользователя, которому будут зачислены деньги
     * @param destRequisite счет зачисления
     * @param amount сумма перевода
     * @return возвращет true если перевод денежных средств был произведен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список всех счетов пользователя
     * @param user пользователь, у которого необходимо получить список счетов
     * @return возвращает список всех счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
