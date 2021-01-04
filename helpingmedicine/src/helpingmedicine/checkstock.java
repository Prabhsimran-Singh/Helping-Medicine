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
public class checkstock extends javax.swing.JInternalFrame {
 Vector medicinelist,batchlist;
    /**
     * Creates new form updatesupplier
     */Connection con;
    public checkstock(Connection con) {
        initComponents();
     this.con=con;
        
        fillmedicine();
        l1.setVisible(false);
       setTitle("Medicine Entry");
    }

     
     
  void fillmedicine()
{
    medicinelist =new Vector();
    
    try
    {
      String sql = "select * from medicine";
    PreparedStatement p = con.prepareStatement(sql);
      ResultSet rs=  p.executeQuery();
    while(rs.next())
    {
        String data[]=new String[2];
        data[0]=rs.getString("mcode");
        data[1]=rs.getString("mname");
        medicinelist.add(data);
        //String code=rs.getString("cname")+"-"+rs.getString("code");
        
        m1.addItem(data[1]);
    }
      
      
    }
    catch(Exception ex)
    {
        
    }
}
        
     
     void fillbatchlist() {

        int scode = m1.getSelectedIndex();
        String y[] = (String[]) medicinelist.get(scode);
        String ccode = y[0];

        batchlist = new Vector();
        try {
             b1.removeAllItems();
             String sq11 = "select (batch) from medicine where mcode=?";
            PreparedStatement pp = con.prepareStatement(sq11);
            pp.setString(1, ccode);
            ResultSet rs1 = pp.executeQuery();
           
           
            while (rs1.next()) {
               if(rs1.getString("batch")!=null){
                   
               
                String data1[] = new String[1];
                data1[0] = rs1.getString("batch");            
                batchlist.add(data1);
                b1.addItem(data1[0]);
               
                
               }  
               }
            
            String sql = "select (batchnumber) from boughtitems where productid=?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, ccode);
            ResultSet rs = p.executeQuery();
           
           
            while (rs.next()) {
                String data[] = new String[1];
                data[0] = rs.getString("batchnumber");
               

                batchlist.add(data);
                //String code=rs.getString("cname")+"-"+rs.getString("code");

                b1.addItem(data[0]);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occured fillbatch table" + ex.getMessage());
            ex.printStackTrace();
        }
    }  
     
     
      
     
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        m1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        lstock = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        b1 = new javax.swing.JComboBox();
        l1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("medicine Name *");

        btnsave.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 255, 255));
        btnsave.setText("check");
        btnsave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        btnsave.setContentAreaFilled(false);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        m1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                m1ItemStateChanged(evt);
            }
        });
        m1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                m1FocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("   Stock Available are");

        lstock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lstock.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Batch number *");

        l1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 153, 153));
        l1.setText("less stock remaining");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lstock, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l1)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(l1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lstock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnsave)
                .addGap(91, 91, 91))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(180, 180, 410, 450);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("        Check stock");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 110, 360, 30);

        jPanel2.setOpaque(false);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/helpingmedicine/Screenshot (36).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(843, 843, 843))
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
        
       
       
        int scode = m1.getSelectedIndex();
        String y[] = (String[]) medicinelist.get(scode);
        String ccode = y[0];
        String batch=b1.getSelectedItem().toString();
       int a=0,b,c=0,d,e=0;

        try
        {

            String sql = "select openingstock from medicine where batch=?";

            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1,batch);  
             p.executeUpdate();
            
             ResultSet rs=  p.executeQuery();
           if(rs.next()){
                 a=rs.getInt("openingstock");
                 
            }
           
          String sq2 = "select sum(qtotal) as t from boughtitems where batchnumber=?";

            PreparedStatement pp = con.prepareStatement(sq2);
            pp.setString(1,batch);
             ResultSet rs1=  pp.executeQuery();
           while(rs1.next()){
                 b=rs1.getInt("t");
                 c+=b;
            }
            
          String sq3 = "select sum(qtotal) as q from solditems where batchnumber=?";

            PreparedStatement ppp = con.prepareStatement(sq3);
            ppp.setString(1,batch);
             ResultSet rs2=  ppp.executeQuery();
           while(rs2.next()){
                 d=rs2.getInt("q");
                 e+=d;
            }
        l1.setVisible(false);
        int f=a+c-e;
        if(f>0 && f<=9){
          l1.setText("less stock remaining");
            l1.setVisible(true);
                    
        }  
        if(f==0){
            l1.setText("NO STOCK AVAILABLE");
            lstock.setText("0");       
             l1.setVisible(true);      
            return;
        }
        
        lstock.setText(String.valueOf(f));
           
        
        }
        
        
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error occured "+ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void m1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_m1FocusLost
       fillbatchlist();
    }//GEN-LAST:event_m1FocusLost

    private void m1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_m1ItemStateChanged
           fillbatchlist();
    }//GEN-LAST:event_m1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox b1;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel lstock;
    private javax.swing.JComboBox m1;
    // End of variables declaration//GEN-END:variables
}
