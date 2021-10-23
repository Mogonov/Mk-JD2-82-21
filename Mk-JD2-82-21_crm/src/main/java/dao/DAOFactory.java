package dao;

import dao.impl.DepartmentDAOImpl;
import dao.impl.EmployeeDAOImpl;
import model.Department;
import model.Employee;

public class DAOFactory {

    private DAOFactory() {
    }

    public static EntityDAO<Department> getDepartmentDAO() {
        return new DepartmentDAOImpl();
    }

    public static EntityDAO<Employee> getEmployeeDAO() {
        return new EmployeeDAOImpl();
    }
}
