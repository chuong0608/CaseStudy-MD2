package interfaces;

public interface InterfaceGenara<T> {
    void add(T t);
    void edit(int id,T t);
    void delete(int id);
    int findById(int id);
    void printAll();
}
