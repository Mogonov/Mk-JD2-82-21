package org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class OneToOneMapping {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Employee emp = new Employee();
        Department deptObj = new Department();


        emp.setEmpId(2);
        emp.setEmpName("Emp1");
        deptObj.setDeptId(2);
        deptObj.setDeptName("Dept1");

        session.beginTransaction();
        session.save(emp);
        session.save(deptObj);
        session.getTransaction().commit();
        session.close();
    }


}
