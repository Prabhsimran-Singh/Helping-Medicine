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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DP
 */
public class boughtitems extends javax.swing.JInternalFrame {
 
    /**
     * Creates new form updatesupplier
     */Connection con;
     Vector data;
    public boughtitems() {
        initComponents();
     getConnection(); 
     
     data = new Vector();
        
      fillTable();
     
       setTitle("bought items");
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
     
   void fillTable() {
        try {
             String s[]=new String[10000000];
         
           
            Vector heading = new Vector();
            heading.add("orderdetailid");
            heading.add("orderid");
            heading.add("productid");
            heading.add("Batch No");
            heading.add("type");
            heading.add("qbox");
            heading.add("qitem");
            heading.add("rate");
            heading.add("total");
            heading.add("mfdate");
            heading.add("expdate");

            heading.add("qtotal");
           
            
 
           String sql1 = "select * from boughtitems";
           String a,b,c,d,e,f,g,h,i,j,k,l;
               PreparedStatement pp = con.prepareStatement(sql1);
      
                ResultSet rs1 = pp.executeQuery();
                while(rs1.next()) {
                 
                    a = rs1.getString("orderdetail");
                    b = rs1.getString("orderid");
                    c = rs1.getString("productid");
                    d = rs1.getString("batchnumber");
                    e = rs1.getString("type");
                    f = rs1.getString("quantityofbox");
                    g = rs1.getString("quantityofitem");
                    h = rs1.getString("rate");
                    i = rs1.getString("total");
                    j = rs1.getString("manufacturingdate");
                    k = rs1.getString("expirydate");
                    l = rs1.getString("qtotal");
                    
                    
                    
                    Vector row = new Vector();
                row.add(a);
                row.add(b);
                row.add(c);
                row.add(d);
                row.add(e);
                row.add(f);
                row.add(g);
                row.add(h);
                row.add(i);
                row.add(j);
                row.add(e);
                row.add(e);
                row.add(e);
                 data.add(row);
                }
        } catch (Exception ex) {
           // JOptionPane.showMessageDialog(this, "Error occured fill table" + ex.getMessage());
            ex.printStackTrace();
        }

    }     
 
  
     
      
     
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("out of stock medicines");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 50, 360, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(390, 140, 480, 402);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/tree-trunk-bokeh-1.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 10, 1560, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
