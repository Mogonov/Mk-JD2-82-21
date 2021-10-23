package servlets;

import form.DepartmentForm;
import model.Department;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public abstract class BaseDepartmentServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(BaseDepartmentServlet.class);
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  {
            process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
            process(request, response);
    }

    protected abstract void process(HttpServletRequest request, HttpServletResponse response);

    void redirect(HttpServletRequest request, HttpServletResponse response,
                            List<String> errors, DepartmentForm departmentForm){
        request.setAttribute("errors", errors);
        request.setAttribute("departmentForm", departmentForm);
        RequestDispatcher rd = request.getRequestDispatcher("/view/department/DepartmentForm.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            
        } catch (IOException e) {
           
        }
    }

    DepartmentForm createDepartmentForm(HttpServletRequest request){
        DepartmentForm departmentForm = new DepartmentForm();
        departmentForm.setId(request.getParameter("id"));
        departmentForm.setName(request.getParameter("name"));
        return departmentForm;
    }
    Department createDepartment(DepartmentForm departmentForm){
        Department department = new Department();
        if (!departmentForm.getId().isEmpty()) department.setId(Integer.parseInt(departmentForm.getId()));
        department.setName(departmentForm.getName());
        return department;
    }
    DepartmentForm createDepartmentForm(Department department){
        DepartmentForm departmentForm = new DepartmentForm();
        departmentForm.setId(String.valueOf(department.getId()));
        departmentForm.setName(department.getName());
        return departmentForm;
    }

}
