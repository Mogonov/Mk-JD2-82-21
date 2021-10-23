package action;

import java.util.List;

public interface Action<T> {

    List<T> getEmpAll();

    void insert(T emp);

    void update(T emp);

    void delete(T emp);

    T get(Integer id);
}
