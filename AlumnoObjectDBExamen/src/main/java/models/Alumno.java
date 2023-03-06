package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

/**
 *
 * @author Antonio
 */
@Entity
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Integer id;
    private String nombre;
    private String telefono;
    private String email;
    private Double notaAD;
    private Double notaDI;

    
    public Alumno() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getNotaAD() {
        return notaAD;
    }

    public void setNotaAD(Double notaAD) {
        this.notaAD = notaAD;
    }

    public Double getNotaDI() {
        return notaDI;
    }

    public void setNotaDI(Double notaDI) {
        this.notaDI = notaDI;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", notaAD=" + notaAD + ", notaDI=" + notaDI + '}';
    }
    
}

