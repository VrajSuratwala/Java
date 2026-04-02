package com.mycompany.productmanagementsystem.resources;

import ejb.CategoryBeanLocal;
import ejb.ProductBeanLocal;
import entity.Category;
import entity.Product;
import jakarta.ejb.EJB;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import java.util.Collection;

/**
 *
 * @author 
 */
@Path("jakartaee10")
public class JakartaEE10Resource {
    @EJB
    CategoryBeanLocal cb;
    @EJB
    ProductBeanLocal pb;
    
    @POST
    @Path("createCategory/{name}")
    public void createCategory(@PathParam("name") String name){
        cb.createCategory(name);
    }
    
    @POST
    @Path("updateCategory/{id}/{name}")
    public void updateCategory(@PathParam("id") Integer id,@PathParam("name") String name){
        cb.updateCategory(id, name);
    }
    
    @DELETE
    @Path("deleteCategory/{id}")
    public void deleteCategory(@PathParam("id") Integer id){
        cb.deleteCategory(id);
    }
    
    @GET
    @Path("getCategory/{id}")
    @Produces("application/json")
    public Category getCategory(@PathParam("id") Integer id){
        return cb.getCategory(id);
    }
    
    @GET
    @Path("getAllCategory")
    @Produces("application/json")
    public Collection<Category> getAllCategory(){
        return cb.getAllCategory();
    }
    
    @POST
    @Path("createProduct/{productName}/{price}/{categoryId}")
    public void createProduct(@PathParam("productName") String productName,@PathParam("price") Integer price,@PathParam("categoryId") Integer categoryId){
        pb.createProduct(productName, categoryId, categoryId);
    }
    @POST
    @Path("updateProduct/{id}/{productName}/{price}/{categoryId}")
    public void updateProduct(@PathParam("id") Integer id,@PathParam("productName") String productName,@PathParam("price") Integer price,@PathParam("categoryId") Integer categoryId){
        pb.updateProduct(id, productName, price, categoryId);
    }
    
    @DELETE
    @Path("deleteProduct/{id}")
    public void deleteProduct(@PathParam("id") Integer id){
        pb.deleteProduct(id);
    }
    
    @GET
    @Path("getProduct/{id}")
    @Produces("application/json")
    public Product getProduct(@PathParam("id") Integer id){
        return pb.getProduct(id);
    }
    
    @GET
    @Path("getAllProduct")
    @Produces("application/json")
    public Collection<Product> getAllProduct(){
        return pb.getAllProduct();
    }
    
    @GET
    @Path("getProductByCategory")
    @Produces("application/json")
    public Collection<Product> getProductByCategory(Integer categoryId){
        return pb.getProductByCategory(categoryId);
    }
}
