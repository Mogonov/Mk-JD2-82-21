package by.it_academy.jd2.Mk_JD2_82_21.Person.controller;

import by.it_academy.jd2.Mk_JD2_82_21.Person.dto.PersonDTO;
import by.it_academy.jd2.Mk_JD2_82_21.Person.storage.CookieStorage;
import by.it_academy.jd2.Mk_JD2_82_21.Person.storage.SessionStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    private static final String NAME_PARAMETER = "name";
    private static final String LASTNAME_PARAMETER = "last_name";
    private static final String AGE_PARAMETER = "age";
    private static final String STORAGE_HEADER = "by/it_academy/jd2/Mk_JD2_82_21/Person/storage";

    private static final SessionStorage<PersonDTO> SESSION_STORAGE = new SessionStorage<>("person");
    private static final CookieStorage<PersonDTO> COOKIES_STORAGE = new CookieStorage<>("person");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        PersonDTO person = new PersonDTO(req.getParameter(NAME_PARAMETER), req.getParameter(LASTNAME_PARAMETER), Integer.parseInt(req.getParameter(AGE_PARAMETER)));
        String storageHeader = req.getHeader(STORAGE_HEADER);
        switch (storageHeader) {
            case "cookies":
                COOKIES_STORAGE.save(resp, person);
                break;
            case "session":
                SESSION_STORAGE.save(req, person);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "unknown by.it_academy.jd2.Mk_JD2_82_21.Person.storage");
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String storageHeader = req.getHeader(STORAGE_HEADER);
        PersonDTO person = null;
        switch (storageHeader) {
            case "cookies":
                person = COOKIES_STORAGE.get(req);
                break;
            case "session":
                person = SESSION_STORAGE.get(req);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "unknown by.it_academy.jd2.Mk_JD2_82_21.Person.storage");
        }

        if (person == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        resp.getOutputStream().println(person.toString());
    }
}
