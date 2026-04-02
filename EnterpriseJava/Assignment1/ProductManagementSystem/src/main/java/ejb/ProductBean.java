/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Category;
import entity.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;

/**
 *
 * @author riya vesuwala
 */
@Stateless
public class ProductBean implements ProductBeanLocal {
    
    @PersistenceContext(unitName="jpu")
    EntityManager em;
    
    @Override
    public void createProduct(String productName, Integer price, Integer categoryId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Product product=new Product();
        product.setProductName(productName);
        product.setPrice(price);
        
        Category category=em.find(Category.class, categoryId);
        product.setCategoryId(category);
        
        Collection<Product> products=category.getProductCollection();
        products.add(product);
        category.setProductCollection(products);
        
        em.persist(product);
        
    }

    @Override
    public void updateProduct(Integer id, String productName, Integer price, Integer categoryId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Category category=em.find(Category.class, categoryId);
        Collection<Product> products=category.getProductCollection();
        
        Product product=em.find(Product.class, id);
        
        if(products.contains(product))
        {
            products.remove(product);
        }
        
        product.setProductName(productName);
        product.setPrice(price);
        product.setCategoryId(category);
        
        
        products.add(product);
        category.setProductCollection(products);
        
        em.merge(product);
        em.merge(category);
    }

    @Override
    public void deleteProduct(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Product product=em.find(Product.class, id);
        em.remove(product);
    }

    @Override
    public Product getProduct(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.find(Product.class, id);
    }

    @Override
    public Collection<Product> getAllProduct() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<Product> getProductByCategory(Integer categoryId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Category category=em.find(Category.class, categoryId);
        return category.getProductCollection();
    }
}
