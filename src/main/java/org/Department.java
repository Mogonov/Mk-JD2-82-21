package org;
import javax.persistence.*;


@Entity
public class Department {
    int deptId;
    String deptName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Column
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}









