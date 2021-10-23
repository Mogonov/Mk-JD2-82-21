package action;

import dao.DAOFactory;
import dao.EntityDAO;
import dao.exception.DAOException;
import model.Employee;


import java.util.ArrayList;
import java.util.List;


public class EmployeeAction implements Action<Employee> {


    private EntityDAO<Employee> employeeDAO = DAOFactory.getEmployeeDAO();
    private boolean isWrong;

    public boolean isWrong() {
        return isWrong;
    }

    @Override
    public List<Employee> getEmpAll() {
        List<Employee> employees = null;
        try {
            employees = employeeDAO.getAll();
        } catch (DAOException e) {

        }
        return employees;
    }

    public List<Employee> getEmpDep(int id) {
        List<Employee> employees = new ArrayList<Employee>();
        List<Employee> allEmployees = getEmpAll();
        for (Employee employee : allEmployees) {
            if (employee.getDepartmentId() == id) {
                employees.add(employee);
            }
        }
        return employees;
    }
    @Override
    public void insert(Employee employee) {
        isWrong = false;
        try {
            employeeDAO.insert(employee);
        } catch (DAOException e) {
            isWrong = isExist(e.getMessage());

        }
    }
    @Override
    public void update(Employee employee) {
        isWrong = false;
        try {
            employeeDAO.update(employee);
        } catch (DAOException e) {
            isWrong = isExist(e.getMessage());

        }
    }
    @Override
    public void delete(Employee employee) {
        try {
            employeeDAO.delete(employee);
        } catch (DAOException ignored) {

        }
    }

    @Override
    public Employee get(Integer id) {
        Employee employee = new Employee();
        try {
            employee = employeeDAO.get(id);
        } catch (DAOException e) {

        }
        return employee;
    }

    private boolean isExist(String msg){
        boolean isExist = false;
        String msgEmail = msg.substring(78, 96);
        if (msgEmail.equals("employee_email_key")){
            isExist = true;
        }
        return isExist;
    }
}
