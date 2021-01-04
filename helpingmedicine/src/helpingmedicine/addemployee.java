package helpingmedicine;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DP
 */
public class addemployee extends javax.swing.JInternalFrame {

    /**
     * Creates new form changepassword
     */Connection con;
    public addemployee(Connection con) {
            initComponents();
            this.con=con;
            p1.setOpaque(false);
            p2.setOpaque(false);
    
    }
    
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p2 = new javax.swing.JPanel();
        p1 = new javax.swing.JPanel();
        t3 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Change Password");
        getContentPane().setLayout(null);

        p2.setBackground(new java.awt.Color(253, 234, 147));
        p2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(247, 190, 103), new java.awt.Color(248, 207, 112), null, null));

        p1.setBackground(new java.awt.Color(251, 253, 147));
        p1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 87), new java.awt.Color(249, 199, 98), null, null));

        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel1.setText(" new username");

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel3.setText("new password");

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel4.setText("confirm password");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(p2);
        p2.setBounds(290, 100, 250, 340);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/login_icon.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 90, 230, 360);

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel6.setText("ADD Employee");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(310, 40, 250, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/people-icon.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(580, 150, 230, 270);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/gold_texture_by_paulinemoss-d54e150.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-10, 0, 830, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String password,username;
        password=t2.getText();
        username=t1.getText();
        try{
          
                        if(t2.getText().equals(t3.getText())){

                            password=t2.getText();

                            String sql1="insert into emplogin (password,username) values (?,?)";
                            PreparedStatement p1=con.prepareStatement(sql1);

                            p1.setString(1,password);
                            p1.setString(2,username);

                            p1.executeUpdate();

                            JOptionPane.showMessageDialog(this, "Employee Created");

                        }
                        else{
                            JOptionPane.showMessageDialog(this,"new password doent mach with confirm password" );
                        }

                    }
  

        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Please fill all Details" );
            e.printStackTrace();
            return;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    // End of variables declaration//GEN-END:variables
}
