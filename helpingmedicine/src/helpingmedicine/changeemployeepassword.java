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
public class changeemployeepassword extends javax.swing.JInternalFrame {

    /**
     * Creates new form changepassword
     */Connection con;
    public changeemployeepassword(Connection con) {
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
        t4 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Change Password");
        getContentPane().setLayout(null);

        p2.setBackground(new java.awt.Color(253, 234, 147));
        p2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(247, 190, 103), new java.awt.Color(248, 207, 112), null, null));

        p1.setBackground(new java.awt.Color(251, 253, 147));
        p1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 204, 87), new java.awt.Color(249, 199, 98), null, null));

        t3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t3ActionPerformed(evt);
            }
        });

        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel1.setText("username");

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel2.setText("password");

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel3.setText("new password");

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel4.setText("confirm password");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("save");
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
                            .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(p2);
        p2.setBounds(20, 90, 250, 340);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/people-icon.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(290, 10, 190, 170);

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel6.setText("Change Employee Password");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 30, 250, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/gold_texture_by_paulinemoss-d54e150.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-10, 0, 510, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String password,username;
        password=t2.getText();
        username=t1.getText();
        try{
            String sql = "select * from emplogin ";

        PreparedStatement p=con.prepareStatement(sql);
            ResultSet r=p.executeQuery();
            while(r.next() ){
                if( r.getString("username").equals(username))   {

                    if(r.getString("password").equals(password)){
                        if(t3.getText().equals(t4.getText())){

                            password=t3.getText();

                            String sql1="update emplogin set password=? where username=?";
                            PreparedStatement p1=con.prepareStatement(sql1);

                            p1.setString(1,password);
                            p1.setString(2,username);

                            p1.executeUpdate();

                            JOptionPane.showMessageDialog(this, "password Updated");

                        }
                        else{
                            JOptionPane.showMessageDialog(this,"new password doent mach with confirm password" );
                        }

                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Incorect Password" );
                    }

                }  else{
                    JOptionPane.showMessageDialog(this,"Incorect Username" );
                }
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

    private void t3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    // End of variables declaration//GEN-END:variables
}
