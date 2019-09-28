/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author UNI
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {

        try {
            this.setIconImage(new ImageIcon(getClass().getResource("/Images/dr-icon.png")).getImage());
        } catch (NullPointerException ex) {
        }

        initComponents();
        //    this.setResizable(false);

        Especialidad.setVisible(false);
        Medico.setVisible(false);
        Paciente.setVisible(false);
        Cita.setVisible(false);
        Consulta.setVisible(false);
        Servicio.setVisible(false);
        Pago.setVisible(false);
        Usuario.setVisible(false);
        Reporte.setVisible(false);

    }

    static int ID_Usuario;

    static void setID_Usuario(int ID_Usuario) {
        Principal.ID_Usuario = ID_Usuario;
    }

    public void Iniciar(String Rol) {

        if ("Caja".equals(Rol)) {

            Pago.setVisible(true);

        }

        if ("Medico".equals(Rol)) {
            Consulta.setVisible(true);
            Paciente.setVisible(true);
            AgregarPaciente.setVisible(false);
            VerConsulta.setVisible(false);
        }

        if ("Secretaria".equals(Rol)) {
            Paciente.setVisible(true);
            Cita.setVisible(true);
            Reporte.setVisible(true);
        }

        if ("Admin".equals(Rol)) {
            Especialidad.setVisible(true);
            Medico.setVisible(true);
            Paciente.setVisible(true);
            Cita.setVisible(true);
            Consulta.setVisible(true);
            Servicio.setVisible(true);
            Pago.setVisible(true);
            Usuario.setVisible(true);
            Reporte.setVisible(true);
        }

//        this.setVisible(true);
//        this.toFront();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Especialidad = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        Medico = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        VerMedico = new javax.swing.JMenuItem();
        Paciente = new javax.swing.JMenu();
        AgregarPaciente = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        Cita = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        Consulta = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        VerConsulta = new javax.swing.JMenuItem();
        Servicio = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        Pago = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        Usuario = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        Reporte = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Principal");
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        DesktopPane = new PanelFondo();
        getContentPane().add(DesktopPane, java.awt.BorderLayout.CENTER);

        Especialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435341819_cross_1.png"))); // NOI18N
        Especialidad.setText("Especialidad");
        Especialidad.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        jMenuItem2.setText("Agregar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Especialidad.add(jMenuItem2);

        jMenuItem11.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355706_computer.png"))); // NOI18N
        jMenuItem11.setText("Ver");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        Especialidad.add(jMenuItem11);

        jMenuBar1.add(Especialidad);

        Medico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435341736_doctor.png"))); // NOI18N
        Medico.setText("Medico");
        Medico.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        jMenuItem1.setText("Agregar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Medico.add(jMenuItem1);

        VerMedico.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        VerMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355706_computer.png"))); // NOI18N
        VerMedico.setText("Ver");
        VerMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerMedicoActionPerformed(evt);
            }
        });
        Medico.add(VerMedico);

        jMenuBar1.add(Medico);

        Paciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435341967_nurse.png"))); // NOI18N
        Paciente.setText("Paciente");
        Paciente.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        AgregarPaciente.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        AgregarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        AgregarPaciente.setText("Agregar");
        AgregarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPacienteActionPerformed(evt);
            }
        });
        Paciente.add(AgregarPaciente);

        jMenuItem13.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355706_computer.png"))); // NOI18N
        jMenuItem13.setText("Ver");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        Paciente.add(jMenuItem13);

        jMenuBar1.add(Paciente);

        Cita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435342034_calendar-date-month-planner.png"))); // NOI18N
        Cita.setText("Citas");
        Cita.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        jMenuItem4.setText("Agregar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        Cita.add(jMenuItem4);

        jMenuItem16.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355706_computer.png"))); // NOI18N
        jMenuItem16.setText("Ver");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        Cita.add(jMenuItem16);

        jMenuBar1.add(Cita);

        Consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435360652_Doctor.png"))); // NOI18N
        Consulta.setText("Consultas");
        Consulta.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        jMenuItem5.setText("Agregar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Consulta.add(jMenuItem5);

        VerConsulta.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        VerConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355706_computer.png"))); // NOI18N
        VerConsulta.setText("Ver");
        VerConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerConsultaActionPerformed(evt);
            }
        });
        Consulta.add(VerConsulta);

        jMenuBar1.add(Consulta);

        Servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435341838_pharmacy.png"))); // NOI18N
        Servicio.setText("Servicios");
        Servicio.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        jMenuItem6.setText("Agregar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        Servicio.add(jMenuItem6);

        jMenuItem15.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355706_computer.png"))); // NOI18N
        jMenuItem15.setText("Ver");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        Servicio.add(jMenuItem15);

        jMenuBar1.add(Servicio);

        Pago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435342077_money_cash_pay.png"))); // NOI18N
        Pago.setText("Pagos");
        Pago.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        jMenuItem7.setText("Agregar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        Pago.add(jMenuItem7);

        jMenuItem18.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355706_computer.png"))); // NOI18N
        jMenuItem18.setText("Ver");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        Pago.add(jMenuItem18);

        jMenuBar1.add(Pago);

        Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1436261437_user-group.png"))); // NOI18N
        Usuario.setText("Usuario");
        Usuario.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        jMenuItem10.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        jMenuItem10.setText("Agregar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        Usuario.add(jMenuItem10);

        jMenuItem14.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355706_computer.png"))); // NOI18N
        jMenuItem14.setText("Ver");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        Usuario.add(jMenuItem14);

        jMenuBar1.add(Usuario);

        Reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435357560_pdf.png"))); // NOI18N
        Reporte.setText("Horario");
        Reporte.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        jMenuItem8.setText("Por Medico");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        Reporte.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1435355822_sign-add.png"))); // NOI18N
        jMenuItem9.setText("General");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        Reporte.add(jMenuItem9);

        jMenuBar1.add(Reporte);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AgregarMedico AM = new AgregarMedico();
        this.DesktopPane.add(AM);
        centerJIF(AM);

// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AgregarEspecialidad AE = new AgregarEspecialidad();
        this.DesktopPane.add(AE);
        centerJIF(AE);   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void AgregarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPacienteActionPerformed
        AgregarPaciente AP = new AgregarPaciente();
        this.DesktopPane.add(AP);
        centerJIF(AP);   // TODO add your handling code here:
    }//GEN-LAST:event_AgregarPacienteActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        AgregarCita AC = new AgregarCita();
        this.DesktopPane.add(AC);
        centerJIF(AC);   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        AgregarConsulta ACC = new AgregarConsulta();
        this.DesktopPane.add(ACC);
        centerJIF(ACC);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        AgregarServicio AS = new AgregarServicio();
        this.DesktopPane.add(AS);
        centerJIF(AS); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        AgregarFactura AF = new AgregarFactura();
        this.DesktopPane.add(AF);
        centerJIF(AF);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        SeleccionarMedico SM = new SeleccionarMedico(null, false);
        SM.setOpcion(1);
        SM.setVisible(true);
        SM.toFront();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        ModoReporte MR = new ModoReporte(null, false);
        MR.setOpcion(0);
        MR.setVisible(true);
        MR.toFront();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        AgregarUsuario AU = new AgregarUsuario(this, true);
        AU.setVisible(true);
        AU.toFront();// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        VerEspecialidad VE = new VerEspecialidad();
        this.DesktopPane.add(VE);
        centerJIF(VE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void VerMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerMedicoActionPerformed
        VerMedico VM = new VerMedico();
        this.DesktopPane.add(VM);
        centerJIF(VM);     // TODO add your handling code here:
    }//GEN-LAST:event_VerMedicoActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        VerPaciente VP = new VerPaciente();
        this.DesktopPane.add(VP);
        centerJIF(VP);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        VerUsuario VU = new VerUsuario();
        this.DesktopPane.add(VU);
        centerJIF(VU);   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        VerServicio VS = new VerServicio();
        this.DesktopPane.add(VS);
        centerJIF(VS);    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        VerCita VC = new VerCita();
        this.DesktopPane.add(VC);
        centerJIF(VC);   // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void VerConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerConsultaActionPerformed
        VerConsulta VCC = new VerConsulta();
        this.DesktopPane.add(VCC);
        centerJIF(VCC);  // TODO add your handling code here:
    }//GEN-LAST:event_VerConsultaActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        VerPago PG = new VerPago();
        this.DesktopPane.add(PG);
        centerJIF(PG); // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro que desea cerrar sesion?", "Cerrar sesion", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            InicioSesion IS = new InicioSesion(null, false);
            IS.setVisible(true);
            this.dispose();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    public void centerJIF(JInternalFrame jif) {
        Dimension desktopSize = DesktopPane.getSize();
        Dimension jInternalFrameSize = jif.getSize();
        int width = (desktopSize.width - jInternalFrameSize.width) / 2;
        int height = (desktopSize.height - jInternalFrameSize.height) / 2;
        jif.setLocation(width, height);
        jif.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgregarPaciente;
    private javax.swing.JMenu Cita;
    private javax.swing.JMenu Consulta;
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenu Especialidad;
    private javax.swing.JMenu Medico;
    private javax.swing.JMenu Paciente;
    private javax.swing.JMenu Pago;
    private javax.swing.JMenu Reporte;
    private javax.swing.JMenu Servicio;
    private javax.swing.JMenu Usuario;
    private javax.swing.JMenuItem VerConsulta;
    private javax.swing.JMenuItem VerMedico;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
