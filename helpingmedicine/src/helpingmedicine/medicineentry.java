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
public class medicineentry extends javax.swing.JInternalFrame {
 Vector brandlist;
    /**
     * Creates new form updatesupplier
     */Connection con;
    public medicineentry(Connection con) {
        initComponents();
    this.con=con;
        fillTable();
        fillbrand();
       setTitle("Medicine Entry");
    }

     void getConnection() {
        try {
            String x = "jdbc:oracle:thin:@localhost:1521:";

//Initialize database driver
            Class.forName("oracle.jdbc.OracleDriver");

//Establish connection 
            con = DriverManager.getConnection(x, "medicine", "123456");
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
     
     
  void fillbrand()
{
    brandlist =new Vector();
    
    try
    {
      String sql = "select * from brand";
    PreparedStatement p = con.prepareStatement(sql);
      ResultSet rs=  p.executeQuery();
    while(rs.next())
    {
        String data[]=new String[2];
        data[0]=rs.getString("bcode");
        data[1]=rs.getString("bname");
        brandlist.add(data);
        //String code=rs.getString("cname")+"-"+rs.getString("code");
        
        c1.addItem(data[1]);
    }
      
      
    }
    catch(Exception ex)
    {
        
    }
}
        
     
     
     
     
       void fillTable()
    {
         try
        {
        Vector heading=new Vector();
        heading.add("Medicine Code");
        heading.add("Medicine Name");
        heading.add("Brand Name");
        heading.add("Opening Stock");
        heading.add("Minimum Stock");
        heading.add("Batch no");
        heading.add("Expiry Date");

    
      
        
      
        
        String query="select * from medicine";
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        Vector data=new Vector();
        while(rs.next())
        {
            Vector row=new Vector();
            row.add(rs.getString("mcode"));
            row.add(rs.getString("mname"));
            row.add(rs.getString("bcode"));
            row.add(rs.getString("openingstock"));
            row.add(rs.getString("minimumstock"));
            row.add(rs.getString("batch"));
            row.add(rs.getString("expdate"));

           
            
            
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
        exp = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnmodify = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        c1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtopenstock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtmin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtbatch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtexp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Medicine Customer Entry");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 110, 380, 30);

        exp.setForeground(new java.awt.Color(255, 255, 255));
        exp.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("medicine CODE *");

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("medicine Name *");

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
        jLabel7.setText("brand name*");

        c1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        c1.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Opening stock");

        txtopenstock.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("minimum stock limit");

        txtmin.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("batch number");

        txtbatch.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("expiry date");

        txtexp.setOpaque(false);

        javax.swing.GroupLayout expLayout = new javax.swing.GroupLayout(exp);
        exp.setLayout(expLayout);
        expLayout.setHorizontalGroup(
            expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expLayout.createSequentialGroup()
                        .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtopenstock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbatch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtexp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(expLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnmodify, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        expLayout.setVerticalGroup(
            expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcode))
                .addGap(27, 27, 27)
                .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expLayout.createSequentialGroup()
                        .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expLayout.createSequentialGroup()
                        .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)))
                .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtopenstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtexp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(expLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnmodify)
                    .addComponent(btndelete))
                .addGap(159, 159, 159))
        );

        getContentPane().add(exp);
        exp.setBounds(180, 180, 410, 450);

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

        jPanel2.setOpaque(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/Screenshot (36).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(150, 40, 470, 580);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/tree-trunk-bokeh-1.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 10, 1560, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
         String mname = txtname.getText();
         
         
         String batchno = txtbatch.getText();
         if(batchno==null)
             batchno="";
         
         mname=mname.trim();
        int bname=c1.getSelectedIndex();
      String x[]=(String[])brandlist.get(bname);
           String code=x[0];  
       
        String openstock=txtopenstock.getText();
                String minimumstock=txtmin.getText();

               String expdate=txtexp.getText();



        if(mname.length()==0){
            JOptionPane.showMessageDialog(this,"Please enter supplier name");
            return;
        }
         if( Validations.isName(mname)==false){
           JOptionPane.showMessageDialog(this,"Invalid name");
       }
       
        
      
        try
        {
          
            String sql = "insert into medicine (mname,bcode,openingstock,minimumstock,batch,expdate) values(?,?,?,?,?,?)";

            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1, mname);
            p.setString(2, code);
            p.setString(3, openstock);
            p.setString(4, minimumstock);
            p.setString(5, batchno);
            p.setString(6, expdate);




            p.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Saved");
            fillTable();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Enter all details ");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnmodifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifyActionPerformed
        String mname = txtname.getText();
        String openstock = txtopenstock.getText();
        String minimumstock = txtmin.getText();
        String expdate = txtexp.getText();

        String batchno = txtbatch.getText();
        if (batchno == null) {
            batchno = "";
        }
        mname = mname.trim();
        int bname = c1.getSelectedIndex();
        String x[] = (String[]) brandlist.get(bname);
        String code = x[0];

        if (mname.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter medicine name");
            return;
        }
        if (Validations.isName(mname) == false) {
            JOptionPane.showMessageDialog(this, "Invalid name");
       }
        
        
        

        try
        {
            String mcode=txtcode.getText();
            
            String sql = "update medicine set mname=?, bcode=?,openingstock=? ,minimumstock=?,batch=?,expdate=? where mcode=?";

            PreparedStatement p = con.prepareStatement(sql);

          
            p.setString(1,mname);
            p.setString(2,code);
            p.setString(3,openstock);
                        p.setString(4,minimumstock);
             p.setString(5,batchno);
                        p.setString(6,expdate);

         
           
           p.setString(7,mcode);
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
 String mname = txtname.getText();
        mname=mname.trim();
       
        if(mname.length()==0){
            JOptionPane.showMessageDialog(this,"Please select item to be deleted");
            return;
        }
        if( Validations.isName(mname)==false){
           JOptionPane.showMessageDialog(this,"Invalid name");
       }
      
        try
        {
            String mcode=txtcode.getText();

            String sql = "delete from medicine where mcode=?";

            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1,mcode);
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

        String mcode=(String)tm.getValueAt(rowindex, 0);
        String mname=(String)tm.getValueAt(rowindex, 1);
        String bname=(String)tm.getValueAt(rowindex, 2);
        String openingstock=(String)tm.getValueAt(rowindex, 3);
        String minimumstock=(String)tm.getValueAt(rowindex, 4);
        String batchno=(String)tm.getValueAt(rowindex, 5);
        String expdate=(String)tm.getValueAt(rowindex, 6);

        
        for(int i=0;i<brandlist.size();i++)
        {
            String x[]=(String [])brandlist.get(i);
            if(x[0].equals(bname))
            {
            c1.setSelectedIndex(i);
            break;
            }
        }
        
        
       
      
       
        txtcode.setText(mcode);
        txtname.setText(mname);
                txtopenstock.setText(openingstock);
        txtmin.setText(minimumstock);
        txtbatch.setText(batchno);
                txtexp.setText(expdate);

      
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnmodify;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox c1;
    private javax.swing.JPanel exp;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtbatch;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtexp;
    private javax.swing.JTextField txtmin;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtopenstock;
    // End of variables declaration//GEN-END:variables
}
