package Modelo;
// Generated 23/10/2018 12:07:25 by Hibernate Tools 4.3.1



/**
 * Tematica generated by hbm2java
 */
public class Tematica  implements java.io.Serializable {


     private Integer idtematica;
     private String nombre;

    public Tematica() {
    }

    public Tematica(String nombre) {
       this.nombre = nombre;
    }
   
    public Integer getIdtematica() {
        return this.idtematica;
    }
    
    public void setIdtematica(Integer idtematica) {
        this.idtematica = idtematica;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}

