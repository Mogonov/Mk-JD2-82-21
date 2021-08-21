package by.it_academy.jd2.Mk_JD2_82_21.Person.storage;

import javax.servlet.http.HttpServletRequest;

public class SessionStorage<T>{
    private final String itemKey;

    public SessionStorage(String itemKey) {
        this.itemKey = itemKey;
    }

    public void save(HttpServletRequest request, T item) {
        request.getSession().setAttribute(itemKey, item);
    }

    public T get(HttpServletRequest req) {
        return (T) req.getSession().getAttribute(itemKey);
    }
}
