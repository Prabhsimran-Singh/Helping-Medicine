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
import javax.swing.table.TableModel;

/**
 *
 * @author DP
 */
public class customerdetails extends javax.swing.JInternalFrame {
 
    /**
     * Creates new form updatesupplier
     */Connection con;
     Vector data,data1;
    public customerdetails(Connection con) {
        initComponents();
    this.con=con;
     data = new Vector();
     data1 = new Vector();    
      fillTable();
      // fillTable1();
     
       setTitle("Customer Details");
    }

    
     
   void fillTable() {
        try {
          String a,b,c,d,e,f,g,h;
          String s[]=new String[1000000];
          int i=0;
//            int scode = m1.getSelectedIndex();
//            String y[] = (String[]) medicinelist.get(scode);
//            String ccode = y[0];

            Vector heading = new Vector();
            heading.add("Bill id");
            heading.add("Customerid");
            heading.add("Date of purchase");
            heading.add("SGST");
            heading.add("IGST");
            heading.add("CGST");
            heading.add("Discount");
            heading.add("Grand Total");
            
            String supplierdata = "select * from customerdata";

            PreparedStatement m = con.prepareStatement(supplierdata);

            ResultSet rm = m.executeQuery();

 
            while (rm.next()) {
                a=rm.getString("billid");
                b=rm.getString("customerid");
                c=rm.getString("dateofpurchase");
                d=rm.getString("sgst");
                g=rm.getString("igst");
                 h=rm.getString("cgst");
                e=rm.getString("discount");
                f=rm.getString("grandtotal");
                
                String supplier = "select cname from customer where ccode =?";

                PreparedStatement s1 = con.prepareStatement(supplier);
                s1.setString(1,b);
                ResultSet sd = s1.executeQuery();
                if(sd.next()){
                    s[i]=sd.getString("cname");
                }
                  Vector row = new Vector();
            row.add(a);
            row.add(s[i]);
            row.add(c);
            row.add(d);
            row.add(g);
            row.add(h);
            row.add(e);
            row.add(f);
           data.add(row);
                i++;
              
                
                 DefaultTableModel df = new DefaultTableModel(data, heading);
                jTable1.setModel(df);
            }
                
            
       }  
   
   
       catch (Exception ex) {
           // JOptionPane.showMessageDialog(this, "Error occured fill table" + ex.getMessage());
            ex.printStackTrace();
        }

    }     
 
  void fillTable1() {
        try {
          String a,b,c,d,e,f,g,h,i,j,k,l;
          String s[]=new String[1000000];
          int ii=0;
//            int scode = m1.getSelectedIndex();
//            String y[] = (String[]) medicinelist.get(scode);
//            String ccode = y[0];

            Vector heading1 = new Vector();
            heading1.add("Bill detail");
            heading1.add("Bill id");
            heading1.add("product id");
            heading1.add("batch number");
            heading1.add("type");
            heading1.add("qbox");
            heading1.add("qitem");
            heading1.add("rate");
            heading1.add("total");
            heading1.add("mfgdate");
            heading1.add("expdate");
            heading1.add(" qTotal");
            
        int rowindex= jTable1.getSelectedRow();
        TableModel tm=jTable1.getModel();

        String bcode=(String)tm.getValueAt(rowindex, 0);
            
            String bitem = "select * from solditems where billid =?";

            PreparedStatement m = con.prepareStatement(bitem);
            m.setString(1,bcode);

            ResultSet rm = m.executeQuery();

            
            
            
 
            while (rm.next()) {
                a=rm.getString("billdetail");
                b=rm.getString("billid");
                c=rm.getString("productid");
                d=rm.getString("batchnumber");
                e=rm.getString("type");
                f=rm.getString("quantityofbox");
                g=rm.getString("quantityofitem");
                h=rm.getString("rate");
                i=rm.getString("total");
                j=rm.getString("manufacturingdate");
                k=rm.getString("expirydate");
                l=rm.getString("qtotal");
               
                String supplier = "select mname from medicine where mcode =?";

                PreparedStatement s1 = con.prepareStatement(supplier);
                s1.setString(1,c);
                ResultSet sd = s1.executeQuery();
                if(sd.next()){
                    s[ii]=sd.getString("mname");
                }
                  Vector row1 = new Vector();
            row1.add(a);
            row1.add(b);
            row1.add(s[ii]);
            row1.add(d);
            row1.add(e);
            row1.add(f);
            row1.add(g);
            row1.add(h);  
            row1.add(i);
            row1.add(j);
            row1.add(k);
            row1.add(l);
           data1.add(row1);
                ii++;
              
                
                 DefaultTableModel df = new DefaultTableModel(data1, heading1);
                jTable2.setModel(df);
             
            }
                jTable2.clearSelection();
               
       }  
   
   
       catch (Exception ex) {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("customer details");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(550, 30, 280, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 450, 402);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setRowHeight(28);
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(470, 170, 870, 402);

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("customer DETAILS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 120, 160, 20);

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BOUGHT ITEMS");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(510, 120, 170, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/tree-trunk-bokeh-1.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 20, 1560, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     
       jTable2.removeAll();
        fillTable1();
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
