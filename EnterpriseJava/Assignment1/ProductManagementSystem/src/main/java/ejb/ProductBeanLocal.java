/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Product;
import jakarta.ejb.Local;
import java.util.Collection;

/**
 *
 * @author riya vesuwala
 */
@Local
public interface ProductBeanLocal {
    public void createProduct(String productName,Integer price,Integer categoryId);
    public void updateProduct(Integer id,String productName,Integer price,Integer categoryId);
    public void deleteProduct(Integer id);
    public Product getProduct(Integer id);
    public Collection<Product> getAllProduct();
    public Collection<Product> getProductByCategory(Integer categoryId);
}
