/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package seminario1;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carlota
 */
public class Vista extends javax.swing.JFrame {
    private Controlador controlador;
    private Consultas consultas;

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
       
    }
    
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonDarDeAlta = new javax.swing.JButton();
        botonMostrar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonCrear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));

        botonDarDeAlta.setBackground(new java.awt.Color(218, 236, 255));
        botonDarDeAlta.setFont(new java.awt.Font("Farah", 1, 16)); // NOI18N
        botonDarDeAlta.setText("DAR DE ALTA NUEVO PEDIDO");
        botonDarDeAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDarDeAltaActionPerformed(evt);
            }
        });

        botonMostrar.setBackground(new java.awt.Color(218, 236, 255));
        botonMostrar.setFont(new java.awt.Font("Farah", 0, 16)); // NOI18N
        botonMostrar.setText("MOSTRAR CONTENIDO DE LAS TABLAS");
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarActionPerformed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(218, 236, 255));
        botonSalir.setFont(new java.awt.Font("Farah", 1, 16)); // NOI18N
        botonSalir.setText("SALIR");
        botonSalir.setAlignmentX(0.5F);
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonCrear.setBackground(new java.awt.Color(218, 236, 255));
        botonCrear.setFont(new java.awt.Font("Farah", 0, 16)); // NOI18N
        botonCrear.setText("CREAR NUEVA TABLA");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Phosphate", 0, 24)); // NOI18N
        jLabel1.setText("MENÚ PRINCIPAL DE LA BASE DE DATOS");

        botonBorrar.setBackground(new java.awt.Color(218, 236, 255));
        botonBorrar.setFont(new java.awt.Font("Farah", 0, 16)); // NOI18N
        botonBorrar.setText("Borrar Tablas");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonSalir)
                        .addGap(245, 245, 245))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonDarDeAlta)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonMostrar)
                        .addGap(120, 120, 120))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonBorrar)
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonCrear)
                        .addGap(189, 189, 189))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(botonCrear)
                .addGap(18, 18, 18)
                .addComponent(botonDarDeAlta)
                .addGap(18, 18, 18)
                .addComponent(botonMostrar)
                .addGap(18, 18, 18)
                .addComponent(botonBorrar)
                .addGap(32, 32, 32)
                .addComponent(botonSalir)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonDarDeAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDarDeAltaActionPerformed
        this.controlador.Insertar();
    }//GEN-LAST:event_botonDarDeAltaActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.controlador.Desconectar();
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarActionPerformed
        // TODO add your handling code here:
        this.controlador.mostrarTablas();
    }//GEN-LAST:event_botonMostrarActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        try {
            this.controlador.CrearTabla();
            JOptionPane.showMessageDialog(null, "Tablas Creadas");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Las tablas ya estaban creadas");     
            //System.exit(0);
        }
    }//GEN-LAST:event_botonCrearActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // TODO add your handling code here:
        try {
            this.controlador.borrarTablas();
            JOptionPane.showMessageDialog(null, "Tablas Borradas");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Las tablas ya estaban borradas");     
            //System.exit(0);
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonDarDeAlta;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
