package Modelo;
// Generated 23/10/2018 12:07:25 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Inscripcion generated by hbm2java
 */
public class Inscripcion  implements java.io.Serializable {


     private Integer idinscripcion;
     private Curso curso;
     private Participante participante;
     private Date fecha;
     private String estado;

    public Inscripcion() {
    }

	
    public Inscripcion(Curso curso, Participante participante) {
        this.curso = curso;
        this.participante = participante;
    }
    public Inscripcion(Curso curso, Participante participante, Date fecha, String estado) {
       this.curso = curso;
       this.participante = participante;
       this.fecha = fecha;
       this.estado = estado;
    }
   
    public Integer getIdinscripcion() {
        return this.idinscripcion;
    }
    
    public void setIdinscripcion(Integer idinscripcion) {
        this.idinscripcion = idinscripcion;
    }
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Participante getParticipante() {
        return this.participante;
    }
    
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void Incribir(Object ParticipanteN, Object cursoN){

    }


}

