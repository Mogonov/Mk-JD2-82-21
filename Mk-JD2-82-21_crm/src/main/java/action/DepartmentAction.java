package action;

import dao.DAOFactory;
import dao.EntityDAO;
import dao.exception.DAOException;
import model.Department;


import java.util.List;

public class DepartmentAction implements Action<Department>{


    private EntityDAO<Department> departmentDAO = DAOFactory.getDepartmentDAO();
    private boolean isWrong;

    public boolean isWrong() {
        return isWrong;
    }

    public List<Department> getEmpAll() {
        List<Department> departments = null;
        try {
            departments = departmentDAO.getAll();
        } catch (DAOException e) {

        }
        return departments;
    }
    public void delete(Department department) {
        try {
            departmentDAO.delete(department);
        } catch (DAOException e) {

        }
    }
    public void insert(Department department) {
        try {
            isWrong = false;
            departmentDAO.insert(department);
        } catch (DAOException e) {
            isWrong = isExist(e.getMessage());

        }
    }
    public Department get(Integer id) {
        Department department = new Department();
        try {
            department = departmentDAO.get(id);
        } catch (DAOException e) {

        }
        return department;
    }
    public void update(Department department) {
        try {
            isWrong = false;
            departmentDAO.update(department);
        } catch (DAOException e) {
            isWrong = isExist(e.getMessage());

        }
    }

    private boolean isExist(String msg){
        boolean isExist = false;
        String msgDep = msg.substring(80, 106);
        if (msgDep.equals("departments_department_key")){
            isExist = true;
        }
        return isExist;
    }
}
