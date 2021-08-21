package by.it_academy.jd2.Mk_JD2_82_21.Person.storage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;

public class CookieStorage<T> {

    private final String cookieName;

    public CookieStorage(String cookieName) {
        this.cookieName = cookieName;
    }

    public void save(HttpServletResponse response, T item) {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream so;
        try {
            so = new ObjectOutputStream(bo);
            so.writeObject(item);
            so.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String serializedObject = bo.toString();
        response.addCookie(new Cookie(cookieName, serializedObject));
    }

    public T get(HttpServletRequest req) {
        byte[] bytes = Arrays.stream(req.getCookies())
                .filter(c -> cookieName.equals(c.getName()))
                .map(Cookie::getValue)
                .map(String::getBytes)
                .findAny()
                .orElse(null);
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream si = new ObjectInputStream(bi);
            return (T) si.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
