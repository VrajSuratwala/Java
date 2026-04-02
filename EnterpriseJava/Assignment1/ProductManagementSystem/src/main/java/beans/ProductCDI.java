/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.RestClient;
import ejb.CategoryBeanLocal;
import ejb.ProductBeanLocal;
import entity.Category;
import entity.Product;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;

/**
 *
 * @author riya vesuwala
 */
@Named(value = "productCDI")
@RequestScoped
public class ProductCDI {

    @EJB 
    ProductBeanLocal pb;
    @EJB
    CategoryBeanLocal cb;
    
    RestClient rl=new RestClient();
    Response rs;
    
    Integer id;
    String productName;
    Integer price;
    Integer categoryId;
    
    Collection<Category> categories;
    Collection<Product> products;
    
    Product product;
    
    public ProductCDI() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    public void createProduct()
    {
        if(id==null)
        {
            rl.createProduct(productName, String.valueOf(price), String.valueOf(categoryId));
        }
        else{
            rl.updateProduct(String.valueOf(id), productName, String.valueOf(price), String.valueOf(categoryId));
        }
    }
    
    public Collection<Category> getCategories() {
        rs=rl.getAllCategory(Response.class);
        categories=rs.readEntity(new GenericType<Collection<Category>>(){});
        return categories;
    }

    public Collection<Product> getProducts() {
        rs=rl.getAllProduct(Response.class);
        products=rs.readEntity(new GenericType<Collection<Product>>(){});
        return products;
    }
    
    public void deleteProduct(Integer Id){
        rl.deleteProduct(String.valueOf(Id));
    }

    public void fillProduct() {
        product=rl.getProduct(Product.class, String.valueOf(id));
        productName=product.getProductName();
        price=product.getPrice();
        categoryId=product.getCategoryId().getId();
    }
    
    public void searchProductByCategory()
    {
        products=pb.getProductByCategory(categoryId);
    }
    
    
    
}
