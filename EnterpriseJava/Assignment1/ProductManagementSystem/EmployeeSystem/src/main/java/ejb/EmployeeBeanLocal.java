/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import com.entity.Department;
import com.entity.Employee;
import jakarta.ejb.Local;
import java.util.Collection;

/**
 *
 * @author root
 */
@Local
public interface EmployeeBeanLocal {
    public void createEmployee(String employeeName,String password,String gender,String hobby,Integer deptId);
    public void updateEmployee(Integer employeeId,String employeeName,String password,String gender,String hobby,Integer deptId);
    public void deleteEmployee(Integer employeeId);
    public Employee getEmployee(Integer employeeId);
    public Collection<Employee> getAllEmployee();
    public Collection<Department> getAllDepartment();
}
