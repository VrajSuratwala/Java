/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Category;
import jakarta.ejb.Local;
import java.util.Collection;

/**
 *
 * @author riya vesuwala
 */
@Local
public interface CategoryBeanLocal {
    public void createCategory(String name);
    public void updateCategory(Integer id,String name);
    public void deleteCategory(Integer id);
    public Category getCategory(Integer id);
    public Collection<Category> getAllCategory();
}
