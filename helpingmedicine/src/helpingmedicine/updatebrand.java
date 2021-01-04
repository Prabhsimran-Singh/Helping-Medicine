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
public class updatebrand extends javax.swing.JInternalFrame {

    /**
     * Creates new form updatebrand
     */Connection con;
    public updatebrand(Connection con) {
        initComponents();
    this.con=con;
        
        fillTable();
        setTitle("Brand Entry");
      
    }

//    void getConnection() {
//        try {
//            String x = "jdbc:oracle:thin:@localhost:1521:";
//
////Initialize database driver
//            Class.forName("oracle.jdbc.OracleDriver");
//
////Establish connection 
//            con = DriverManager.getConnection(x, "medicine", "123456");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//    }
     
       void fillTable()
    {
         try
        {
        Vector heading=new Vector();
        heading.add("Brand Code");
        heading.add("Brand Name");
      
        
        String query="select * from brand";
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        Vector data=new Vector();
        while(rs.next())
        {
            Vector row=new Vector();
            row.add(rs.getString("bcode"));
            row.add(rs.getString("bname"));
            
            
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnmodify = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setText("Medicine BRAND Entry");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(760, 90, 380, 30);

        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setText("Brand Code");

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setText("brand Name");

        txtcode.setEnabled(false);
        txtcode.setOpaque(false);

        txtname.setOpaque(false);

        btnsave.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btnsave.setText("Save");
        btnsave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnsave.setContentAreaFilled(false);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnmodify.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btnmodify.setText("Modify");
        btnmodify.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnmodify.setContentAreaFilled(false);
        btnmodify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifyActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btndelete.setText("Delete");
        btndelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btndelete.setContentAreaFilled(false);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnmodify, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnmodify)
                    .addComponent(btndelete))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(750, 160, 350, 210);

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
        jScrollPane1.setBounds(770, 390, 324, 271);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/tree-trunk-bokeh-1.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1560, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
         String bname = txtname.getText();
         bname= bname.trim();

        if(bname.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter brand name");
            return;
        }
          if( Validations.isName(bname)==false){
           JOptionPane.showMessageDialog(this,"Invalid Name");
           return;
       }
        try
        {
          
            String sql = "insert into brand (bname) values(?)";

            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1, bname);

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
 String bname = txtname.getText();
 bname= bname.trim();

        if(bname.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter brand name");
            return;
        }
        if( Validations.isName(bname)==false){
           JOptionPane.showMessageDialog(this,"Invalid Name");
           return;
       }
        try
        {
            String bcode=txtcode.getText();
            
            String sql = "update brand set bname=? where bcode=?";

            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1, bname);
            p.setString(2, bcode);
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
 
         String bname = txtname.getText();
 bname= bname.trim();

        if(bname.length()==0){
            JOptionPane.showMessageDialog(this,"Please select item to be deleted");
            return;
        }
        if( Validations.isName(bname)==false){
           JOptionPane.showMessageDialog(this,"Invalid Name");
           return;
       }
        try
        {
            String bcode=txtcode.getText();

            String sql = "delete from brand where bcode=?";

            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, bcode);
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

        String bcode=(String)tm.getValueAt(rowindex, 0);
        String bname=(String)tm.getValueAt(rowindex, 1);

        txtcode.setText(bcode);
        txtname.setText(bname);
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnmodify;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
