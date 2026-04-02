/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import com.mycompany.q4.Student;
import com.mycompany.q4.Subject;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Collection;

/**
 *
 * @author riya vesuwala
 */
@Stateless
@LocalBean
public class CollegeBean {

    @PersistenceContext(unitName="jpu")
    EntityManager em;
    
    public void addStudent(String name)
    {
        Student s=new Student();
        
        s.setName(name);
        em.persist(s);
        
    }
    public void addSubject(String name)
    {
        Subject s=new Subject();
        
        s.setName(name);
        em.persist(s);
        
    }
    public void assignSubject(int studentId,int subjectId)
    { 
        Student s=em.find(Student.class, subjectId);
        Subject sub=em.find(Subject.class, subjectId);
        
        s.getSubjectCollection().add(sub);
        sub.getStudentCollection().add(s);
    }
    
    public Collection<Student> getStudents()
    {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }
    
    public Collection<Subject> getSubjects()
    {
        return em.createNamedQuery("Subject.findAll", Subject.class).getResultList();
    }
}
