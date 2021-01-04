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
public class checkavailability extends javax.swing.JInternalFrame {
 
    /**
     * Creates new form updatesupplier
     */Connection con;
     Vector data;
    public checkavailability(Connection con) {
        initComponents();
    
     this.con=con;
     data = new Vector();
        
      fillTable();
     
       setTitle("Avalability");
    }

  
     
   void fillTable() {
        try {
             String s[]=new String[10000000],name="";
          int a=0,b=0,c=0,d,e=0,f,aa=0;
//            int scode = m1.getSelectedIndex();
//            String y[] = (String[]) medicinelist.get(scode);
//            String ccode = y[0];

            Vector heading = new Vector();
            heading.add("Medicine");
           
            heading.add("Minimum stock limit");
           heading.add("Stock available");

         
            
           
              String med = "select mcode from medicine";

            PreparedStatement m = con.prepareStatement(med);
          
            ResultSet rm=  m.executeQuery();
          
           int i=0;
            while(rm.next()){
               
              s[i]=rm.getString("mcode");
               System.out.println(s[i]);
              i++; 
               
            }
       
          i=0;  
           ResultSet rm1=  m.executeQuery();
       while(rm1.next())
       {
        System.out.println(" "+s[i]+".......");
            String sql1 = "select openingstock from medicine where mcode=?";

            PreparedStatement pp = con.prepareStatement(sql1);

            pp.setString(1,s[i]);  
            // pp.executeUpdate();
            
             ResultSet rs1=  pp.executeQuery();
           if(rs1.next()){
                 a=rs1.getInt("openingstock");
                // System.out.print(" a " +a);
            }
           
          String sq2 = "select sum(qtotal) as t from boughtitems where productid=?";

            PreparedStatement ppp = con.prepareStatement(sq2);
            ppp.setString(1,s[i]);
             ResultSet rs11=  ppp.executeQuery();
           while(rs11.next()){
                 b=rs11.getInt("t");
                 c+=b;
                 //System.out.print(" c " +c);
            }
            
          String sq3 = "select sum(qtotal) as q from solditems where productid=?";

            PreparedStatement pppp = con.prepareStatement(sq3);
            pppp.setString(1,s[i]);
             ResultSet rs2=  pppp.executeQuery();
           while(rs2.next()){
                 d=rs2.getInt("q");
                 e+=d;
               // System.out.print(" e " +e);
           }
       
         f=a+c-e;
            String sql = "select * from medicine where mcode=?";

            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1,s[i]);  
             
            
             ResultSet rs=  p.executeQuery();
           while(rs.next()){
               name=rs.getString("mname");
               aa=rs.getInt("minimumstock");
           }
           System.out.print("f " +f+" name "+ name);
           if(f<=0 || f<=aa)
               {
                Vector row = new Vector();
                row.add(name);
                row.add(aa);
                row.add(f);
                 data.add(row);
                  System.out.print(" f" + f + "   " + aa + "  " + name + " ");
               }
           
             
              
               DefaultTableModel df = new DefaultTableModel(data, heading);
               jTable1.setModel(df);
            name="";
               
         i++;
       c=0;
       e=0;
       
       a=0;
        
         
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
