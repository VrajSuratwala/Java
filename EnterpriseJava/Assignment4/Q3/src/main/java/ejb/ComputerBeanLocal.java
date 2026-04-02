/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Computer;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author riya vesuwala
 */
@Local
public interface ComputerBeanLocal {
    public List<Computer> getAllComputers();
    public Computer findComputer(int id);
}
