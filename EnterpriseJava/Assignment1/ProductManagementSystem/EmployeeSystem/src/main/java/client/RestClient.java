/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:JakartaEE10Resource
 * [jakartaee10]<br>
 * USAGE:
 * <pre>
 *        RestClient client = new RestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author root
 */
public class RestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080//resources";

    public RestClient() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("jakartaee10");
    }

    public void updateEmployee(String employeeId, String employeeName, String password, String gender, String hobby, String deptId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateEmployee/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{employeeId, employeeName, password, gender, hobby, deptId})).request().post(null);
    }

    public <T> T getEmployee(Class<T> responseType, String employeeId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getEmployee/{0}", new Object[]{employeeId}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void createEmployee(String employeeName, String password, String gender, String hobby, String deptId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createEmployee/{0}/{1}/{2}/{3}/{4}", new Object[]{employeeName, password, gender, hobby, deptId})).request().post(null);
    }

    public <T> T getAllEmployee(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllEmployee");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteEmployee(String employeeId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteEmployee/{0}", new Object[]{employeeId})).request().delete();
    }

    public <T> T getAllDepartment(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllDepartment");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
