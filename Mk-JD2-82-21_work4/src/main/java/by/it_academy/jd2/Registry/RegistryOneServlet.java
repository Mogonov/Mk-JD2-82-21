package by.it_academy.jd2.Registry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/rego")
public class RegistryOneServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");


        if(first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() ||
                password.isEmpty() || birthday.isEmpty() )
        {
            RequestDispatcher req = request.getRequestDispatcher("registry.jsp");
            req.include(request, response);
        }
        else
        {
            RequestDispatcher req = request.getRequestDispatcher("registry_1.jsp");
            req.forward(request, response);
        }
    }

}


