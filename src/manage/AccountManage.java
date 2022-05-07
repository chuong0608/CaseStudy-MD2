package manage;

import file.FileAccountCSV;
import interfaces.InterfaceAccount;
import interfaces.InterfaceGenara;
import model.Account;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AccountManage implements InterfaceGenara<Account>, InterfaceAccount<Account> {
    List<Account> accountList = new ArrayList<>();

    public AccountManage() throws FileNotFoundException {
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public void add(Account account) {
        accountList.add(account);

    }

    @Override
    public void edit(String name, Account account) {

    }

    @Override
    public void delete(String name) {


    }

    @Override
    public int findByName(String name) {
       return 0;
    }

    @Override
    public void printAll() {
        for (Account a: accountList
             ) {
            System.out.println(a);
        }

    }

    @Override
    public void login(String nameAccount, String password) {

    }

    @Override
    public void checkAcount(String nameAccount) {

    }

    @Override
    public Account findByNameAccount(String accountName) {
        for (int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).getNameAccount().equals(accountName)){
                return accountList.get(i);
            }
        }
        return null;
    }
}
