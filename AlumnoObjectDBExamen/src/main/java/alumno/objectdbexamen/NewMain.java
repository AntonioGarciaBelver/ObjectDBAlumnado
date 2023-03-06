
package alumno.objectdbexamen;

import dao.AlumnoDAO;
import models.Alumno;

/**
 *
 * @author Antonio
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        AlumnoDAO gestorAlumnos = new AlumnoDAO();
        
        Alumno alumno = new Alumno();
        alumno.setNombre("Antonio");
        alumno.setEmail("antonio@gmail.com");
        alumno.setTelefono("952232323");
        alumno.setNotaAD(7.5);
        alumno.setNotaDI(7.5);
        
        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Loren");
        alumno2.setEmail("loren@gmail.com");
        alumno2.setTelefono("952232323");
        alumno2.setNotaAD(3.5);
        alumno2.setNotaDI(2.5);
        
        Alumno alumno3 = new Alumno();
        alumno3.setNombre("Adolfo");
        alumno3.setEmail("adolfo@gmail.com");
        alumno3.setTelefono("952232323");
        alumno3.setNotaAD(5.5);
        alumno3.setNotaDI(3.5);
        
        Alumno alumno4 = new Alumno();
        alumno4.setNombre("Jose");
        alumno4.setEmail("jose@gmail.com");
        alumno4.setTelefono("952232323");
        alumno4.setNotaAD(1.5);
        alumno4.setNotaDI(8.5);
        
        Alumno alumno5 = new Alumno();
        alumno5.setNombre("Alejandro");
        alumno5.setEmail("alejandro@gmail.com");
        alumno5.setTelefono("6565656");
        alumno5.setNotaAD(6.0);
        alumno5.setNotaDI(8.5);
        
//        gestorAlumnos.insertarAlumno(alumno);
//        gestorAlumnos.insertarAlumno(alumno2);
//        gestorAlumnos.insertarAlumno(alumno3);
//        gestorAlumnos.insertarAlumno(alumno4);
//        gestorAlumnos.insertarAlumno(alumno5);

        System.out.println("Listado de alumnos");
        for(Alumno x: gestorAlumnos.listarTodo()){
            System.out.println(x);
        }
        
        System.out.println("\nListado de suspensos");
        for(Alumno x: gestorAlumnos.listarSuspensos()){
            System.out.println(x);
        }
        
        System.out.println("Nota media de los alumnos");
        System.out.println(gestorAlumnos.estadisticas());
        
    }
}
