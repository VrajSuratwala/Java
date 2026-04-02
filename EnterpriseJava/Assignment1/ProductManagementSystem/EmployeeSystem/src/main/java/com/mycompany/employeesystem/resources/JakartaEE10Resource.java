package com.mycompany.employeesystem.resources;

import com.entity.Department;
import com.entity.Employee;
import ejb.EmployeeBeanLocal;
import jakarta.ejb.EJB;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.util.Collection;

/**
 *
 * @author 
 */
@Path("jakartaee10")
public class JakartaEE10Resource {
    
    @EJB
    EmployeeBeanLocal eb;
    
    @POST
    @Path("createEmployee/{employeeName}/{password}/{gender}/{hobby}/{deptId}")
    public void createEmployee(@PathParam("employeeName") String employeeName,@PathParam("password") String password,@PathParam("gender") String gender,@PathParam("hobby") String hobby,@PathParam("deptId") Integer deptId)
    {
        eb.createEmployee(employeeName, password, gender, hobby, deptId);
    }
    
    @POST
    @Path("updateEmployee/{employeeId}/{employeeName}/{password}/{gender}/{hobby}/{deptId}")
    public void updateEmployee(@PathParam("employeeId") Integer employeeId,@PathParam("employeeName") String employeeName,@PathParam("password") String password,@PathParam("gender") String gender,@PathParam("hobby") String hobby,@PathParam("deptId") Integer deptId)
    {
        eb.updateEmployee(employeeId, employeeName, password, gender, hobby, deptId);
    }
    
    @DELETE
    @Path("deleteEmployee/{employeeId}")
    public void deleteEmployee(@PathParam("employeeId") Integer employeeId)
    {
        eb.deleteEmployee(employeeId);
    }
    
    @GET
    @Path("getEmployee/{employeeId}")
    @Produces("application/json")
    public Employee getEmployee(@PathParam("employeeId") Integer employeeId)
    {
        return eb.getEmployee(employeeId);
    }
    
    @GET
    @Path("getAllEmployee")
    @Produces("application/json")
    public Collection<Employee> getAllEmployee(){
        return eb.getAllEmployee();
    }
    
    @GET
    @Path("getAllDepartment")
    @Produces("application/json")
    public Collection<Department> getAllDepartment(){
        return eb.getAllDepartment();
    }
}
