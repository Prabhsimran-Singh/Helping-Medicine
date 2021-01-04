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
public class expirydate extends javax.swing.JInternalFrame {
 
    /**
     * Creates new form updatesupplier
     */Connection con;
     Vector data;
    public expirydate(Connection con) {
        initComponents();
    this.con=con;
     
     data = new Vector();
        
      fillTable();
     
       setTitle("expiry date");
    }

 
     
   void fillTable() {
        try {
             String s[]=new String[10000000];
          String a,e;
           a=null;e=null;
           boolean c; boolean b;
           c=false;b=false;
//            int scode = m1.getSelectedIndex();
//            String y[] = (String[]) medicinelist.get(scode);
//            String ccode = y[0];

            Vector heading = new Vector();
            heading.add("Batch No");
           
            heading.add("Expiry Date");
            
 
            String med = "select batch from medicine";

            PreparedStatement m = con.prepareStatement(med);

            ResultSet rm = m.executeQuery();

            int i = 0,ch=0;
            while (rm.next()) {
ch=0;
                s[i] = rm.getString("batch");
                System.out.println(s[i]);

            
                
                String sql1 = "select * from medicine where batch=?";

                PreparedStatement pp = con.prepareStatement(sql1);

                pp.setString(1, s[i]);
            pp.executeUpdate();

                ResultSet rs1 = pp.executeQuery();
                if (rs1.next()) {
                 
                    a = rs1.getString("expdate");
                  
                      if(rs1.getString("expdate")!=null && rs1.getString("batch")!=null)
                          ch=1;
                }
                if(a!=null){
                String ddx[] = a.split("/");
                Calendar cx = Calendar.getInstance();
                int j = Integer.parseInt(ddx[1]);
                j = j - 1;

              //  cx.set(Calendar.MILLISECOND, 0);
                cx.set(Calendar.DATE,Integer.parseInt(ddx[0]));
                cx.set(Calendar.MONTH, j);
                cx.set(Calendar.YEAR, Integer.parseInt(ddx[2]));

                Date d = cx.getTime();

                Calendar cx1 = Calendar.getInstance();

                cx1.set(Calendar.MILLISECOND, 0);
                Date d11 = cx1.getTime();
                


              b=d.before(d11);
               
                
                }  
                           
                 if(b==true && ch==1)
               {
                Vector row = new Vector();
                row.add(s[i]);
                row.add(a);
              
                 data.add(row);
                 
               }
           DefaultTableModel df = new DefaultTableModel(data, heading);
                jTable1.setModel(df);
            
                
         i++;  
            }  
                 
                 
              
            
 
            String med3 = "select batchnumber from boughtitems";

            PreparedStatement m3 = con.prepareStatement(med3);

            ResultSet rt = m3.executeQuery();

            i = 0;  
                 
               while(rt.next()){  
                     s[i] = rt.getString("batchnumber");
                      
                String med1 = "select expirydate from boughtitems where batchnumber=?";

                 PreparedStatement pp1 = con.prepareStatement(med1);

                pp1.setString(1, s[i]);
            // pp.executeUpdate();

                ResultSet rs11 = pp1.executeQuery();
                if (rs11.next()) {
                 //e=null;
                    e = rs11.getString("expirydate");
                   
                }
                    if(e!=null){
                                  

                        String dd[] = e.split("/");
                Calendar cx2 = Calendar.getInstance();
                int j1 = Integer.parseInt(dd[1]);
                j1 = j1 - 1;

                cx2.set(Calendar.MILLISECOND, 0);
                cx2.set(Calendar.DATE, Integer.parseInt(dd[0]));
                cx2.set(Calendar.MONTH, (j1));
                cx2.set(Calendar.YEAR, Integer.parseInt(dd[2]));

                Date d2 = cx2.getTime();

                Calendar cx3 = Calendar.getInstance();

                cx3.set(Calendar.MILLISECOND, 0);
                Date d4 = cx3.getTime();
               
               
                
                  c=d2.before(d4);
       
                    }
                
                
                 if(c==true)
               {
                Vector row = new Vector();
                row.add(s[i]);
                row.add(e);
                 data.add(row);
                
               }
                
                
                DefaultTableModel df = new DefaultTableModel(data, heading);
                jTable1.setModel(df);
            
                
         i++;
       
        
         
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
