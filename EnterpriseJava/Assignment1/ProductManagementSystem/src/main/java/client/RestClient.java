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
 * @author riya vesuwala
 */
public class RestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ProductManagementSystem/resources";

    public RestClient() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("jakartaee10");
    }

    public <T> T getProduct(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProduct/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getProductByCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getProductByCategory");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateProduct(String id, String productName, String price, String categoryId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateProduct/{0}/{1}/{2}/{3}", new Object[]{id, productName, price, categoryId})).request().post(null);
    }

    public void updateCategory(String id, String name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCategory/{0}/{1}", new Object[]{id, name})).request().post(null);
    }

    public void createProduct(String productName, String price, String categoryId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createProduct/{0}/{1}/{2}", new Object[]{productName, price, categoryId})).request().post(null);
    }

    public <T> T getCategory(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategory/{0}", new Object[]{id}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void createCategory(String name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createCategory/{0}", new Object[]{name})).request().post(null);
    }

    public <T> T getAllCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCategory");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllProduct(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllProduct");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCategory(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCategory/{0}", new Object[]{id})).request().delete();
    }

    public void deleteProduct(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteProduct/{0}", new Object[]{id})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
