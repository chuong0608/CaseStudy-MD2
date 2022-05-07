package menu;

import file.FileAccountCSV;
import manage.AccountManage;
import model.Account;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AccountManage accountManage = new AccountManage();
        accountManage.printAll();
        accountManage.add(new Account("Hoang Chuong","123abc",
                "0348005557","abc@gmail.com",
                "Hoàng Chương",22,"Admin"));
        accountManage.add(new Account("yen","123abc",
                "9090596053","xyz@gmail.com",
                "Hải Yến",22,"User"));
        accountManage.add(new Account("yen","123abc",
                "9090596053","xyz@gmail.com",
                "Hải Yến",22,"User"));
        accountManage.printAll();
        FileAccountCSV.writeToFile(accountManage.getAccountList());
        System.out.println(FileAccountCSV.readFormFile());
    }
}
