package dao;

import dao.ObjectDBUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import models.Alumno;

/**
 *
 * @author Antonio
 */
public class AlumnoDAO {

    public void insertarAlumno(Alumno alumno) {
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
    }

    public ArrayList<Alumno> listarTodo() {
        ArrayList<Alumno> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("select a from Alumno a", Alumno.class);
        salida = (ArrayList<Alumno>) q.getResultList();
        em.close();
        return salida;
    }

    public ArrayList<Alumno> listarSuspensos(){
        ArrayList<Alumno> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Alumno> q = em.createQuery("select a from Alumno a where a.notaDI <5 or notaAD <5", Alumno.class);
        salida = (ArrayList<Alumno>) q.getResultList();
        em.close();
        return salida;
    }
    
    public List<Double> estadisticas(){
        List<Double> salida = new ArrayList<>();
        Double salida1;
        Double salida2;
        Double salida3;
        Double cantidadAlumnos;
        Double ratioAprobados;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Double> q = em.createQuery("Select SUM(a.notaAD)/5 as ad From Alumno a", Double.class);
        salida1 = q.getSingleResult();
        salida.add(salida1);
        TypedQuery<Double> q1 = em.createQuery("Select SUM(a.notaDI)/5 as di From Alumno a", Double.class);
        salida2 = q1.getSingleResult();
        salida.add(salida2);
        
        TypedQuery<Long> q2 = em.createQuery("Select COUNT(a) From Alumno a where a.notaAD >5 AND a.notaDI>5", Long.class);
        salida3 = q2.getSingleResult().doubleValue();
        
        TypedQuery<Long> q3 = em.createQuery("Select COUNT(a) From Alumno a", Long.class);
        cantidadAlumnos = q3.getSingleResult().doubleValue();
        ratioAprobados = salida3/cantidadAlumnos;
        
        salida.add(ratioAprobados);
        
        em.close();
        
        return salida;
    }
    
    
    public void delete(Alumno alumno) {
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Alumno user = em.find(Alumno.class, alumno.getId());
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }
    

}
