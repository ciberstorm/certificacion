package Controlador;

import Modelo.Curso;
import Modelo.Inscripcion;
import Modelo.Participante;
import java.sql.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Oficina
 */
public class acciones {

    Session se;

    public acciones() {
        se = HibernateUtil.getSessionFactory().openSession();
    }

    public List llenarTabla(String cadena) {
        List<Object> lista = se.createQuery(cadena).list();

        return lista;
    }

    public Participante buscar(String cadena) {
        Participante p = (Participante) se.createQuery(cadena).uniqueResult();

        return p;
    }

    public Curso buscarCurso(String cadena) {
        Curso c = (Curso) se.createQuery(cadena).uniqueResult();

        return c;
    }

    public Inscripcion buscarIDinscripcion(String id) {
        int pk = Integer.parseInt(id);
        Inscripcion in = (Inscripcion) se.get(Inscripcion.class, pk);

        return in;
    }

    public String controlCursos(int idparticipante) {
        Participante pp = (Participante) se.get(Participante.class, idparticipante);
        Object max = se.createQuery("Select count(idparticipante) From Inscripcion where idparticipante = "
                + pp.getIdparticipante()).uniqueResult();

        return max.toString();
    }

    public int mismoCurso(int idparticipante, int idcurso) {

        List<Inscripcion> rep = se.createQuery("From Inscripcion").list();
        int m = 0;
        for (Inscripcion l : rep) {

            int parins = l.getParticipante().getIdparticipante();
            int curins = l.getCurso().getIdcurso();

            if (idparticipante == parins) {
                if (idcurso == curins) {
                    m++;
                }
            }
        }
        return m;
    }

    public String estado(int numInscripcion) {
        Inscripcion in = (Inscripcion) se.get(Inscripcion.class, numInscripcion);
        String e = in.getEstado();
        return e;
    }

    public int inscribir(int idparticipante, int idcurso) {
        Participante pp = (Participante) se.get(Participante.class, idparticipante);
        Curso cc = (Curso) se.get(Curso.class, idcurso);

        Inscripcion ii = new Inscripcion();
        int puede = mismoCurso(idparticipante, idcurso);

        int cupoint = Integer.parseInt(cc.getCupo());

        if (cupoint > 0) {
            if (puede < 1) {
                se.beginTransaction();
                ii.setParticipante(pp);
                ii.setCurso(cc);
                ii.setFecha(this.fecha());
                ii.setEstado("Inscripto");
                int cupo = Integer.parseInt(cc.getCupo());
                cupo = cupo - 1;
                String descuento = String.valueOf(cupo);
                cc.setCupo(descuento);
                se.save(ii);
                se.getTransaction().commit();
                System.out.println("inscripto correctamente");
            } else {
                return 0;
            }
        } else {
            if (puede < 1) {
                se.beginTransaction();
                ii.setParticipante(pp);
                ii.setCurso(cc);

                ii.setFecha(this.fecha());

                ii.setEstado("Condicional");

                se.save(ii);
                se.getTransaction().commit();
                System.out.println("inscripto correctamente");
            } else {
                return 0;
            }
        }

        return ii.getIdinscripcion();
    }

    public int repetido(int idparticipante) {

        List<Inscripcion> rep = se.createQuery("From Inscripcion").list();
        int c = 0;
        for (Inscripcion l : rep) {
            int parins = l.getParticipante().getIdparticipante();
            if (idparticipante == parins) {
                c++;
            }
        }
        return c;
    }

    public Date fecha() {
        java.util.Date dates = new java.util.Date();
        long fechaSis = dates.getTime();
        java.sql.Date d = new java.sql.Date(fechaSis);
        return d;
    }

    public void guardarParticipante(Participante p) {

        se.beginTransaction();
        se.save(p);
        se.getTransaction().commit();

        System.out.println("se guardo correctamente");
    }

    public void eliminarInscripcion(Inscripcion i, Curso c) {

        if ("Inscripto".equals(i.getEstado())) {

            int cupo = Integer.parseInt(c.getCupo());
            cupo = cupo + 1;
            String incremento = String.valueOf(cupo);
            c.setCupo(incremento);

            se.beginTransaction();
            se.saveOrUpdate(c);
            se.delete(i);
            se.getTransaction().commit();

            System.out.println("se elimino correctamente");
        } else {

            se.beginTransaction();
            se.delete(i);
            se.getTransaction().commit();

            System.out.println("se elimino correctamente");
        }

    }

    public int PermitirInscripcion(Inscripcion i, Curso c) {

        if ("Condicional".equals(i.getEstado())) {

            int cupo = Integer.parseInt(c.getCupo());

            if (cupo > 0) {

                cupo = cupo - 1;
                String descuento = String.valueOf(cupo);

                c.setCupo(descuento);
                i.setEstado("Inscripto");

                se.beginTransaction();
                se.saveOrUpdate(i);
                se.saveOrUpdate(c);
                se.getTransaction().commit();

                System.out.println("se Actualizo correctamente");
                return 3;
            }
            return 2;
        }
        return 1;
    }

}
