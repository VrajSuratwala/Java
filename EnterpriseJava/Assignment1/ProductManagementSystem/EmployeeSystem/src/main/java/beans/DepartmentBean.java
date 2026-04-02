/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import com.entity.Department;
import ejb.EmployeeBeanLocal;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.util.Collection;

/**
 *
 * @author root
 */
@Named(value = "departmentBean")
@RequestScoped
public class DepartmentBean {

    @EJB
    EmployeeBeanLocal eb;
    
    Integer employeeId;
    String employeeName;
    String password;
    String gender;
    String[] hobby;
    Integer deptid;
    Collection<Department> depts;
    
    public DepartmentBean() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    
    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Collection<Department> getDepts() {
        depts=eb.getAllDepartment();
        return depts;
    }
    
    public void add()
    {
        String hobbyStr=String.join(",", hobby);
        eb.createEmployee(employeeName, password, gender, hobbyStr, deptid);
    }
    
}
