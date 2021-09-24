package by.it_academy.jd2.Registry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/rego")
public class RegistryOneServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String separator = File.separator;
        String path = separator+"src"+separator+"main"+separator+"java";
        File myFile = new File(path);

        try {
                PrintWriter writer = new PrintWriter(myFile, String.valueOf(true));
            writer.println("text.txt");
            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }



        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");


        if (first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() ||
                password.isEmpty() || birthday.isEmpty()) {
            RequestDispatcher req = request.getRequestDispatcher("/views/registry.jsp");
            req.include(request, response);
        } else {
            RequestDispatcher req = request.getRequestDispatcher("/views/registry_2.jsp");
            req.forward(request, response);
        }
    }

}


