/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpingmedicine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DP
 */
public class updatesupplier extends javax.swing.JInternalFrame {

    /**
     * Creates new form updatesupplier
     */Connection con;
    public updatesupplier(Connection con) {
        initComponents();
     this.con=con;
        fillTable();
      
    }


     
       void fillTable()
    {
         try
        {
        Vector heading=new Vector();
        heading.add("Supplier Code");
        heading.add("Supplier Name");
        heading.add("Address");
        heading.add("City");
        heading.add("State");
        heading.add("Phone Number");
        heading.add("Email Id");

        
      
        
        String query="select * from supplier";
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        Vector data=new Vector();
        while(rs.next())
        {
            Vector row=new Vector();
            row.add(rs.getString("spcode"));
            row.add(rs.getString("spname"));
            row.add(rs.getString("address"));
            row.add(rs.getString("city"));
            row.add(rs.getString("state"));
             row.add(rs.getString("phone"));
            row.add(rs.getString("email"));

            
            
            data.add(row);
         }
            DefaultTableModel df=new DefaultTableModel(data,heading);
            jTable1.setModel(df);
        
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error occured fill table"+ex.getMessage());
            ex.printStackTrace();
        }
        
    }
     
     
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnmodify = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        txtcity = new javax.swing.JTextField();
        txtstate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(700, 140, 560, 470);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("supplier Code *");

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("supplier Name *");

        txtcode.setEnabled(false);
        txtcode.setOpaque(false);
        txtcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeActionPerformed(evt);
            }
        });

        txtname.setOpaque(false);

        btnsave.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("Save");
        btnsave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnsave.setContentAreaFilled(false);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnmodify.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btnmodify.setForeground(new java.awt.Color(255, 255, 255));
        btnmodify.setText("Modify");
        btnmodify.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnmodify.setContentAreaFilled(false);
        btnmodify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifyActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btndelete.setContentAreaFilled(false);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        txtcity.setOpaque(false);
        txtcity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcityActionPerformed(evt);
            }
        });

        txtstate.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("state *");

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("city *");

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("address *");

        txtaddress.setOpaque(false);

        txtphone.setOpaque(false);

        txtemail.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("phone number*");

        jLabel9.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnmodify, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtphone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcode))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnmodify)
                    .addComponent(btndelete))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(180, 180, 350, 450);

        jPanel2.setOpaque(false);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/Screenshot (33).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Medicine supplier Entry");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(120, 80, 480, 580);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/tree-trunk-bokeh-1.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1560, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
         String spname = txtname.getText();
        spname=spname.trim();
        String address=txtaddress.getText();
        String city=txtcity.getText();
        String state=txtstate.getText();
       String phone=txtphone.getText();
        String email=txtemail.getText();
        address=address.trim();
        city=city.trim();
        state=state.trim();
        
        email=email.trim();

        


        if(spname.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter supplier name");
            return;
        }
         if( Validations.isName(spname)==false){
           JOptionPane.showMessageDialog(this,"Invalid name");
       }
        if(address.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter address");
            return;
        }
        
        if(city.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter city");
            return;
        }
        
        if(state.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter state");
            return;
        }
        
        if(phone.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter phone number");
            return;
      }
        if(email.length()==0){
          email=null;
        }
       if( Validations.isNumericString(phone)==false){
           JOptionPane.showMessageDialog(this,"Invalid phone number");
           return;
       }
        try
        {
          
            String sql = "insert into supplier (spname,address,city,state,phone,email) values(?,?,?,?,?,?)";

            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1,spname);
            p.setString(2,address);
            p.setString(3,city);
            p.setString(4,state);
            p.setString(5,phone);
            p.setString(6,email);
           


            p.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Saved");
            fillTable();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error occured "+ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnmodifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifyActionPerformed
 String spname = txtname.getText();
        spname=spname.trim();
        String address=txtaddress.getText();
        String city=txtcity.getText();
        String state=txtstate.getText();
        String phone=txtphone.getText();
        String email=txtemail.getText();
        address=address.trim();
        city=city.trim();
        state=state.trim();
        phone=phone.trim();
        email=email.trim();

        


        if(spname.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter supplier name");
            return;
        }
        if( Validations.isName(spname)==false){
           JOptionPane.showMessageDialog(this,"Invalid name");
       }
        if(address.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter address");
            return;
        }
        
        if(city.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter city");
            return;
        }
        
        if(state.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter state");
            return;
        }
        
        if(phone.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter phone number");
            return;
        }
        if( Validations.isNumericString(phone)==false){
           JOptionPane.showMessageDialog(this,"Invalid phone number");
           return;
       }

        try
        {
            String spcode=txtcode.getText();
            
            String sql = "update supplier set spname=?, address=? ,city=? ,state=?,phone=? ,email=? where spcode=?";

            PreparedStatement p = con.prepareStatement(sql);

          
            p.setString(1,spname);
            p.setString(2,address);
            p.setString(3,city);
            p.setString(4,state);
            p.setString(5,phone);
            p.setString(6,email);
           p.setString(7,spcode);
            p.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Updated");
            fillTable();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error occured "+ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnmodifyActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
 String spname = txtname.getText();
        spname=spname.trim();
   if(spname.length()==0){
            JOptionPane.showMessageDialog(this,"Please select item to be deleted");
            return;
        }
         if( Validations.isName(spname)==false){
           JOptionPane.showMessageDialog(this,"Invalid Name");
       }      
      
        try
        {
            String spcode=txtcode.getText();

            String sql = "delete from supplier where spcode=?";

            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1,spcode);
            p.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Deleted");
            fillTable();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error occured "+ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int rowindex= jTable1.getSelectedRow();
        TableModel tm=jTable1.getModel();

        String spcode=(String)tm.getValueAt(rowindex, 0);
        String spname=(String)tm.getValueAt(rowindex, 1);
        String address=(String)tm.getValueAt(rowindex, 2);
        String city=(String)tm.getValueAt(rowindex, 3);
        String state=(String)tm.getValueAt(rowindex, 4);
        String phone=(String)tm.getValueAt(rowindex, 5);
        String email=(String)tm.getValueAt(rowindex, 6);
        txtcode.setText(spcode);
        txtname.setText(spname);
        txtaddress.setText(address);
        txtcity.setText(city);
        txtstate.setText(state);
        txtphone.setText(phone);
        txtemail.setText(email);

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtcityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcityActionPerformed

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnmodify;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtstate;
    // End of variables declaration//GEN-END:variables
}
