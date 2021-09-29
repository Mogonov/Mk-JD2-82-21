package org;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
public class Employee {
    private int empId;
    private String empName;
    private Department dept;



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {

        this.empId = empId;
    }

    @OneToOne
    @JoinColumn(name = "deptId")
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Column
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String emp_Name) {
        this.empName = empName;
    }


}







