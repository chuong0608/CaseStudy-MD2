package interfaces;

public interface InterfaceAccount<T> {
    int login(String nameAccount, String password);

    void checkAcount(String nameAccount);

    T findByNameAccount(String accountName);

}
