package servlets;

import action.EmployeeAction;
import form.EmployeeForm;
import model.Employee;
import validator.EmployeeValidator;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "EmployeeServletCU",
        urlPatterns = {"/employee_create", "/employee_update"})
public class EmployeeServletCU extends BaseEmployeeServlet {
    private static final Logger log = Logger.getLogger(EmployeeServletCU.class);
    private final EmployeeAction employeeAction = new EmployeeAction();

    protected void process(HttpServletRequest request, HttpServletResponse response){
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf('/');
        String action = uri.substring(lastIndex + 1);
        EmployeeForm employeeForm = createEmployeeForm(request);
        List<String> errors = new EmployeeValidator().validate(employeeForm);
        if (errors.isEmpty()){
            Employee employee = createEmployee(employeeForm);
            doing(employee, action);
            if (employeeAction.isWrong()){
                errors.add("Email : " + employee.getEmail() + " is exist");
                if (action.equals("employee_create")){
                    employeeForm.setId(null);
                }
                redirectForm(request, response, errors, employeeForm);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/employee_read");
                try {
                    rd.forward(request, response);
                } catch (ServletException e) {
                   
                } catch (IOException e) {
                    
                }
            }
        } else {
            redirectForm(request, response, errors, employeeForm);
        }
    }
    private void doing(Employee employee, String action){
        if ("employee_create".equals(action)){
            employeeAction.insert(employee);
        } else if ("employee_update".equals(action)){
            employeeAction.update(employee);
        }
    }
}
