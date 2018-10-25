/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.acciones;
import Modelo.Inscripcion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oficina
 */
public class Listado extends javax.swing.JFrame {

    Inscripcion listaIns;
    acciones ac;
    DefaultTableModel dtm;
    
    public Listado() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Listado de Inscriptos");

        dtm = (DefaultTableModel) tablal.getModel();
        tablal.setModel(dtm);
        ac = new acciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablal = new javax.swing.JTable();
        bld = new javax.swing.JButton();
        blc = new javax.swing.JButton();
        bt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ci = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tablal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Participante", "Curso", "Fecha Inscripcion", "Estado"
            }
        ));
        tablal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablal);
        if (tablal.getColumnModel().getColumnCount() > 0) {
            tablal.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablal.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        bld.setText("Listado definitivo");
        bld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bldActionPerformed(evt);
            }
        });

        blc.setText("Listado Condicional");
        blc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blcActionPerformed(evt);
            }
        });

        bt.setText("Todos");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ci.setText("Cancelar Inscripcion");
        ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciActionPerformed(evt);
            }
        });

        jButton2.setText("Permitir Acceso al Curso");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bld)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bld)
                    .addComponent(blc)
                    .addComponent(bt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(ci)
                    .addComponent(jButton2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inscripcion fi=new inscripcion();
        fi.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void limpiartabla(DefaultTableModel lt) {
        while (lt.getRowCount() > 0) {
            lt.removeRow(0);
        }
    }

    public void cargartabla(String cadena) {
        limpiartabla(dtm);
        List<Inscripcion> lista = ac.llenarTabla(cadena);
        Object[] fila = new Object[5];
        for (Inscripcion c : lista) {
            fila[0] = c.getIdinscripcion();
            fila[1] = c.getParticipante().getNombre() + ", " + c.getParticipante().getApellido();
            fila[2] = c.getCurso().getNombre();
            fila[3] = c.getFecha();
            fila[4] = c.getEstado();

            dtm.addRow(fila);
        }
        tablal.setModel(dtm);
    }


    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        cargartabla("From Inscripcion");
    }//GEN-LAST:event_btActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        cargartabla("From Inscripcion");
    }//GEN-LAST:event_formWindowActivated

    private void bldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bldActionPerformed
        cargartabla("From Inscripcion where estado='Inscripto'");
    }//GEN-LAST:event_bldActionPerformed

    private void blcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blcActionPerformed
        cargartabla("From Inscripcion where estado='Condicional'");
    }//GEN-LAST:event_blcActionPerformed

    private void ciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciActionPerformed
        if (tablal.getSelectedRow() != -1) {
            if (JOptionPane.showConfirmDialog(null,
                    "Decea eliminar la inscripcion de ese participante.\n "
                    + "Una vez eliminada puedce que no vuelva aconseguir lugar en este curso",
                    "Eliminar",
                    JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                System.out.println("eliminar");
                ac.eliminarInscripcion(listaIns, listaIns.getCurso());

            } else {

                JOptionPane.showMessageDialog(this, "OK");
            }

        } else {

            JOptionPane.showMessageDialog(this, "Ups! Debe selecionar una Inscripcion para continuar.");

        }
    }//GEN-LAST:event_ciActionPerformed

    private void tablalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalMouseClicked
        int fila = tablal.getSelectedRow();
        String buscarReg = dtm.getValueAt(fila, 0).toString();
        listaIns = ac.buscarIDinscripcion(buscarReg);
        System.out.println(listaIns.getIdinscripcion());
    }//GEN-LAST:event_tablalMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tablal.getSelectedRow() != -1) {
            if (JOptionPane.showConfirmDialog(this,
                    "Decea Actualizar la inscripcion de ese participante.\n ",
                     "Actualizar",
                    JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                int mensaje = ac.PermitirInscripcion(listaIns, listaIns.getCurso());

                switch (mensaje) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "Ya esta inscrpto");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(this, "No hay mas cupo");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(this, "Se actualizo correctamente la Base de Datos");
                        break;
                }
            } else {

                JOptionPane.showMessageDialog(this, "OK");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ups! Debe selecionar una Inscripcion para continuar.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blc;
    private javax.swing.JButton bld;
    private javax.swing.JButton bt;
    private javax.swing.JButton ci;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablal;
    // End of variables declaration//GEN-END:variables
}
