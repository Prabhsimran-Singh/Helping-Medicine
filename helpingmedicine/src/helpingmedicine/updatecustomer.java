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
public class updatecustomer extends javax.swing.JInternalFrame {

    /**
     * Creates new form updatesupplier
     */Connection con;
    public updatecustomer(Connection con) {
        initComponents();
 this.con=con;
        fillTable();
      setTitle("Customer biling Entry");
    }


     
       void fillTable()
    {
         try
        {
        Vector heading=new Vector();
        heading.add("Customer Code");
        heading.add("Customer Name");
        heading.add("Address");
       heading.add("Phone Number");

      
        
      
        
        String query="select * from customer";
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        Vector data=new Vector();
        while(rs.next())
        {
            Vector row=new Vector();
            row.add(rs.getString("ccode"));
            row.add(rs.getString("cname"));
            row.add(rs.getString("address"));
             row.add(rs.getString("phone"));

           
            
            
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnmodify = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CUSTOMER CODE *");

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("cUSTOMER Name *");

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

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("address *");

        txtaddress.setOpaque(false);

        txtphone.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("phone number*");

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
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtphone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnmodify, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnmodify)
                    .addComponent(btndelete))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(180, 180, 350, 450);

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

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("customer registry ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 100, 350, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/tree-trunk-bokeh-1.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 10, 1560, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
         String cname = txtname.getText();
        cname=cname.trim();
        String address=txtaddress.getText();
        address=address.trim();
        String phone=txtphone.getText();
        phone=phone.trim();
      
        


        if(cname.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter supplier name");
            return;
        }
         if( Validations.isName(cname)==false){
           JOptionPane.showMessageDialog(this,"Invalid name");
       }
        if(address.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter address");
            return;
        }
        if(phone.length()==0){
             JOptionPane.showMessageDialog(this,"Please enter phone number");
           return;
        }
        if(Validations.isNumericString(phone)==false){
       JOptionPane.showMessageDialog(this,"Please enter phone number");

        }
        
      
        try
        {
          
            String sql = "insert into customer (cname,address,phone) values(?,?,?)";

            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1,cname);
            p.setString(2,address);
            p.setString(3,phone);

            
           


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
 String cname = txtname.getText();
        cname=cname.trim();
        String address=txtaddress.getText();       
        String phone=txtphone.getText();      
        address=address.trim();     
        phone=phone.trim();
      

        


        if(cname.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter supplier name");
            return;
        }
        if( Validations.isName(cname)==false){
           JOptionPane.showMessageDialog(this,"Invalid name");
           return;
       }
        if(address.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter address");
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
            String ccode=txtcode.getText();
            
            String sql = "update supplier set cname=?, address=? ,phone=? where ccode=?";

            PreparedStatement p = con.prepareStatement(sql);

          
            p.setString(1,cname);
            p.setString(2,address);
           
            p.setString(3,phone);
           
           p.setString(4,ccode);
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
 String cname = txtname.getText();
        cname=cname.trim();
       
        if(cname.length()==0){
            JOptionPane.showMessageDialog(this,"Please select item to be deleted");
            return;
        }
        if( Validations.isName(cname)==false){
           JOptionPane.showMessageDialog(this,"Invalid name");
       }
      
        try
        {
            String ccode=txtcode.getText();

            String sql = "delete from supplier where ccode=?";

            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1,ccode);
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

        String ccode=(String)tm.getValueAt(rowindex, 0);
        String cname=(String)tm.getValueAt(rowindex, 1);
        String address=(String)tm.getValueAt(rowindex, 2);
        
        String phone=(String)tm.getValueAt(rowindex, 3);
       
        txtcode.setText(ccode);
        txtname.setText(cname);
        txtaddress.setText(address);
       
        txtphone.setText(phone);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnmodify;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
