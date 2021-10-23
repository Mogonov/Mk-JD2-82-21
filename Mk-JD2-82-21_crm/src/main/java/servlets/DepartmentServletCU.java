package servlets;

import action.DepartmentAction;
import form.DepartmentForm;
import model.Department;
import validator.DepartmentValidator;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartmentServletCU",
        urlPatterns = {"/department_create", "/department_update"})
public class DepartmentServletCU extends BaseDepartmentServlet {

    private final DepartmentAction departmentAction = new DepartmentAction();

     protected void process(HttpServletRequest request, HttpServletResponse response) {
        DepartmentValidator departmentValidator = new DepartmentValidator();
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf('/');
        String action = uri.substring(lastIndex + 1);
        DepartmentForm departmentForm = createDepartmentForm(request);
        List<String> errors = departmentValidator.validate(departmentForm);
        if (errors.isEmpty()){
            Department department = createDepartment(departmentForm);
            doing(department, action);
            if (departmentAction.isWrong()){
                errors.add(department.getName() + " is exist");
                if (action.equals("department_create")){
                   departmentForm.setId(null);
                }
                redirect(request, response, errors, departmentForm);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/department_read");
                try {
                    rd.forward(request, response);
                } catch (ServletException e) {
                  
                } catch (IOException e) {
                   
                }
            }
        } else {
            redirect(request, response, errors, departmentForm);
        }
    }
    private void doing(Department department, String action){
         if ("department_create".equals(action)){
             departmentAction.insert(department);
         } else if ("department_update".equals(action)){
             departmentAction.update(department);
         }
    }
}

