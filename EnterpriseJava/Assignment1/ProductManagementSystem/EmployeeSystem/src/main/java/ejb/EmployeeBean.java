/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import com.entity.Department;
import com.entity.Employee;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;

/**
 *
 * @author root
 */
@Stateless
public class EmployeeBean implements EmployeeBeanLocal {

    @PersistenceContext(unitName="jpu")
    EntityManager em;
    @Override
    public void createEmployee(String employeeName, String password, String gender, String hobby, Integer deptId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Employee emp=new Employee();
        emp.setEmployeeName(employeeName);
        emp.setPassword(password);
        emp.setGender(gender);
        emp.setHobby(hobby);
        
        Department dept=em.find(Department.class, deptId);
        emp.setDeptid(dept);
        
        Collection<Employee> emp1=dept.getEmployeeCollection();
        emp1.add(emp);
        dept.setEmployeeCollection(emp1);
        
        em.persist(emp);
    }

    @Override
    public void updateEmployee(Integer employeeId, String employeeName, String password, String gender, String hobby, Integer deptId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Department dept=new Department();
        Collection<Employee> emp1=dept.getEmployeeCollection();
        Employee emp=em.find(Employee.class, employeeId);
        if(emp1.contains(emp))
        {
            emp1.remove(emp);
        } 
        
        emp.setEmployeeName(employeeName);
        emp.setPassword(password);
        emp.setGender(gender);
        emp.setHobby(hobby);
        
        emp1.add(emp);
        dept.setEmployeeCollection(emp1);
        
        em.merge(emp);
        em.merge(dept);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Employee emp=(Employee)em.find(Employee.class, employeeId);
        em.remove(em);
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Employee emp=em.find(Employee.class, employeeId);
        return emp;
    }

    @Override
    public Collection<Employee> getAllEmployee() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Employee.findAll",Employee.class).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<Department> getAllDepartment() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Department.findAll",Department.class).getResultList();
    }
}
