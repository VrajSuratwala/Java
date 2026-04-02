/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.RestClient;
import ejb.CategoryBeanLocal;
import entity.Category;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;

/**
 *
 * @author riya vesuwala
 */
@Named(value = "categoryCDI")
@RequestScoped
public class CategoryCDI {

    @EJB
    CategoryBeanLocal cb;
    
    RestClient rl=new RestClient();
    Response rs;
    
    Integer id;
    String name;
    
    Collection<Category> Categories;
    Category category;
    
    public CategoryCDI() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void createCategory()
    {
        if(id==null)
        {
            rl.createCategory(name);
        }
        else{
            rl.updateCategory(String.valueOf(id), name);
        }
    }
   
    public String deleteCategory(Integer Id) {
        rl.deleteCategory(String.valueOf(Id));
        return "CategoryPage";
    }
    
    public void fillCategory()
    {
        category=rl.getCategory(Category.class,String.valueOf(id));
        name=category.getName();
    }
    
    public Collection<Category> getCategories() {
        rs=rl.getAllCategory(Response.class);
        Categories=rs.readEntity(new GenericType<Collection<Category>>(){});
        return Categories;
    }
}
