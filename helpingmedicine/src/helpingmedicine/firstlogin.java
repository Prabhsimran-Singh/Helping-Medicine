package helpingmedicine;

import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DP
 */
public class firstlogin extends javax.swing.JFrame {

    /**
     * Creates new form firstlogin
     */
    public firstlogin() {
        initComponents();
            setSize(1400,770);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton1.setText("Login as ADMIN");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 270, 240, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/login_icon.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 10, 240, 260);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/Screenshot (31).png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 320, 370);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(290, 190, 320, 370);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jButton2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Login as Employee");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(40, 260, 250, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/people-icon.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 10, 200, 240);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/Screenshot (30).png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 320, 370);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(780, 190, 320, 370);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/1.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 1446, 769);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        exp us1=new exp();
       us1.setSize(1400,770);
       us1.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        emplogin u11=new emplogin();
       u11.setSize(1400,770);
       u11.setVisible(true);
       dispose();
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
            java.util.logging.Logger.getLogger(firstlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(firstlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(firstlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(firstlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new firstlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}