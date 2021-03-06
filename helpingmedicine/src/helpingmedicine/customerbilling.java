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
import java.time.Clock;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DP
 */
public class customerbilling extends javax.swing.JInternalFrame {

    /**
     * Creates new form updatesupplier
     */
    Connection con;
    int rowindex, flag,chk,flag1,BILL=0,FINAL;
    Vector customerlist, medicinelist, batchlist, data;

    public customerbilling(Connection con) {
        initComponents();
       this.con=con;
        //fillTable();
        fillcustomer();
        fillmedicine();
        chk=1;
        flag=0;
        setTitle("customer biling Entry");
        data = new Vector();
        rowindex = -1;
       
    }

  

    void fillTable() {
        try {
            int scode = m1.getSelectedIndex();
            String y[] = (String[]) medicinelist.get(scode);
            String ccode = y[0];

            Vector heading = new Vector();
            heading.add("Medicine");
            heading.add("Medicine ID");
            heading.add("Batch code");
            heading.add("Type");
            heading.add("Quantity of boxes");
            heading.add("Quantity of items per box");
             heading.add("Total items");

            heading.add("Rate per item");
            heading.add("Date of Manufacturing");
            heading.add("Date of Expiry");
            heading.add("Total");

            //Vector data=new Vector();
            Vector row = new Vector();

            row.add(m1.getSelectedItem().toString());
            row.add(ccode);
            row.add(b1.getSelectedItem().toString());
            if (r1.isSelected() == true) {
                row.add(r1.getText());
            }
            if (r2.isSelected() == true) {
                row.add(r2.getText());
            }
            if (r3.isSelected() == true) {
                row.add(r3.getText());
            }
            if (r4.isSelected() == true) {
                row.add(r4.getText());
            }
            if (r5.isSelected() == true) {
                row.add(r5.getText());
            }
            if (r6.isSelected() == true) {
                row.add(r6.getText());
            }

            row.add(txtbox.getText());

            row.add(txtstrip.getText());
            
   int quantity=Integer.parseInt(txtbox.getText()); 
   int strip=Integer.parseInt(txtstrip.getText()); 

            String total = String.valueOf(quantity * strip);
            
            row.add(total);
            row.add(txtrate.getText());
           row.add(txtmandate.getText());
           row.add(txtexpdate.getText());
            row.add(txttotal.getText());

            data.add(row);

            DefaultTableModel df = new DefaultTableModel(data, heading);
            jTable1.setModel(df);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occured fill table" + ex.getMessage());
            ex.printStackTrace();
        }

    }

    void fillcustomer() {
        customerlist = new Vector();

        try {
            String sql = "select * from customer";
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String data[] = new String[2];
                data[0] = rs.getString("ccode");
                data[1] = rs.getString("cname");
                customerlist.add(data);
        //String code=rs.getString("cname")+"-"+rs.getString("code");

                c1.addItem(data[1]);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occured fillcustomer table" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    void fillmedicine() {
        medicinelist = new Vector();

        try {
            String sql = "select * from medicine";
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                String data[] = new String[2];
                data[0] = rs.getString("mcode");
                data[1] = rs.getString("mname");
                medicinelist.add(data);
        //String code=rs.getString("cname")+"-"+rs.getString("code");

                m1.addItem(data[1]);
            }
          
chk=1;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occured fillmedicine table" + ex.getMessage());
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
          
       flag=1;
            String sql = "select (batchnumber) from boughtitems where productid=?";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, ccode);
            ResultSet rs = p.executeQuery();
           
            while (rs.next()) {
                String data[] = new String[1];
                data[0] = rs.getString("batchnumber");            
                batchlist.add(data);
                b1.addItem(data[0]);
              //  filldate();
                
            }
             
           

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occured fillbatch table" + ex.getMessage());
            ex.printStackTrace();
        }
    }
void  filldate(){
     String hi; 
    try{
     if(flag==1){
        hi=(String)b1.getSelectedItem();
              String s11 = "select mandate,expdate from medicine where batch=?";
            PreparedStatement p1 = con.prepareStatement(s11);
            p1.setString(1,hi);
            ResultSet r1 = p1.executeQuery();
           
           
            while (r1.next()) {
               if(r1.getString("expdate")!=null && r1.getString("mandate")!=null){
                   txtmandate.setText( r1.getString("mandate")) ;
                   txtexpdate.setText( r1.getString("expdate")) ;
            
               }  
               }
            

           String s1 = "select manufacturingdate,expirydate from boughtitems where batchnumber=?";
            PreparedStatement p2 = con.prepareStatement(s1);
            p2.setString(1,hi);
            ResultSet r2 = p2.executeQuery();
           
           
            while (r2.next()) {
               if(r2.getString("expirydate")!=null && r2.getString("manufacturingdate")!=null){
                   txtmandate.setText( r2.getString("manufacturingdate")) ;
                   txtexpdate.setText( r2.getString("expirydate")) ;
            
               }  
}
    
     
     
     
     } 
    }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occured fillbatch table" + ex.getMessage());
            ex.printStackTrace();
        
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        txtrate = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbox = new javax.swing.JLabel();
        txtbox = new javax.swing.JTextField();
        c1 = new javax.swing.JComboBox();
        m1 = new javax.swing.JComboBox();
        r1 = new javax.swing.JRadioButton();
        r4 = new javax.swing.JRadioButton();
        ltab = new javax.swing.JLabel();
        lstrips = new javax.swing.JLabel();
        txtstrip = new javax.swing.JTextField();
        lbox1 = new javax.swing.JLabel();
        txttab = new javax.swing.JTextField();
        ltab1 = new javax.swing.JLabel();
        r2 = new javax.swing.JRadioButton();
        r3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        r5 = new javax.swing.JRadioButton();
        r6 = new javax.swing.JRadioButton();
        b1 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtdelivery = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtmandate = new javax.swing.JTextField();
        txtexpdate = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtmed = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txttotal1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdisc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtsgst = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtgtotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtigst = new javax.swing.JTextField();
        txtcgst = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setText("Customer billing record");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(500, 30, 380, 30);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setText("customer*");

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setText("medicine *");

        add.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        add.setText("Add");
        add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        add.setContentAreaFilled(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
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

        txtrate.setOpaque(false);
        txtrate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtrateFocusLost(evt);
            }
        });
        txtrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrateActionPerformed(evt);
            }
        });

        txttotal.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel5.setText("Total");

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel6.setText("rate (per strip) *");

        lbox.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        lbox.setText("quantity of boxes *");

        txtbox.setOpaque(false);

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
        m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r1);
        r1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r1.setText("Injections");
        r1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r4);
        r4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r4.setText("Tablets/Capsules");
        r4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r4ActionPerformed(evt);
            }
        });

        ltab.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        ltab.setText("quantity oF tablets/capsules*");

        lstrips.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        lstrips.setText("quantity of strips *");

        txtstrip.setOpaque(false);

        lbox1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        lbox1.setText("(per box)");

        txttab.setOpaque(false);

        ltab1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        ltab1.setText("(per strip)");

        buttonGroup1.add(r2);
        r2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r2.setText("Syrups");
        r2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r3);
        r3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r3.setText("Powder");
        r3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel4.setText(" batch number*");

        buttonGroup1.add(r5);
        r5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r5.setText("Spray");
        r5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(r6);
        r6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        r6.setText("Cream");
        r6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r6ActionPerformed(evt);
            }
        });

        b1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                b1ItemStateChanged(evt);
            }
        });
        b1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                b1FocusLost(evt);
            }
            public void focusGained(java.awt.event.FocusEvent evt) {
                b1FocusGained(evt);
            }
        });
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
        });
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        jButton4.setText("Check stock");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton3.setText("10%");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton4.setText("20%");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel16.setText("scheme");

        buttonGroup3.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton5.setText("none");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r6)
                            .addComponent(r1))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r2)
                            .addComponent(r3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(r4)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(r5)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(m1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lstrips)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbox1))
                            .addComponent(ltab)
                            .addComponent(lbox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstrip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ltab1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton5)
                        .addGap(16, 16, 16)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtrate, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r1)
                    .addComponent(r2)
                    .addComponent(r5))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r6)
                    .addComponent(r3)
                    .addComponent(r4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lstrips))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbox1)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ltab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ltab1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete)
                    .addComponent(add))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(90, 80, 480, 600);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
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
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(600, 260, 720, 250);

        txtdelivery.setOpaque(false);
        txtdelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdeliveryActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel12.setText("Date of billing");

        jLabel13.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel13.setText("expiry date");

        jLabel14.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel14.setText("manufacturing date");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1.setText("Current Date");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2.setText("Custom Date");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("DD/MM/YYYY");

        txtmandate.setOpaque(false);
        txtmandate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmandateActionPerformed(evt);
            }
        });

        txtexpdate.setOpaque(false);
        txtexpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtexpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jRadioButton1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(txtdelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmandate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtexpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtmandate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtexpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(590, 80, 390, 180);

        jLabel15.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel15.setText("Available stock of");

        txtmed.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N

        l1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmed, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(txtmed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(980, 70, 330, 160);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton1");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("SGST (in %)");

        txtdisc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdiscFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("discount (in %)");

        txtsgst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsgstFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsgstFocusLost(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("TOTAL");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("GRAND TOTAL");

        jButton3.setText("Get Total");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("CGST (in %)");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("IGST (in %)");

        txtigst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtigstFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtigstFocusLost(evt);
            }
        });
        txtigst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtigstActionPerformed(evt);
            }
        });

        txtcgst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcgstFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcgstFocusLost(evt);
            }
        });
        txtcgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcgstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(txtdisc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txttotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtgtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(57, 57, 57))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(txtcgst, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(187, 187, 187)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtigst, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)))
                                .addContainerGap())))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtsgst, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txttotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtigst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(120, 120, 120)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(610, 520, 700, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void checklist(){
        
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
       
        int f=a+c-e;
       
        if(f<=0){
            l1.setText("NO STOCK AVAILABLE");
                  
            return;
        }
        else if(f<10){
            l1.setText("Minimum Stock limit Reached"+"= "+f);
            FINAL=f;
              BILL=1;     
            return;
        }
        
        l1.setText(String.valueOf(f));
           
        
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occured fillbatch table" + ex.getMessage());
            ex.printStackTrace();
        
    }
    }
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        int total = 0, b = 0,quant;
        String a, bb, c, d, e, f;

        a = b1.getSelectedItem().toString();
        bb = txtbox.getText();
        c = txtstrip.getText();
        d=txtmandate.getText();
        e=txtexpdate.getText();  
        f = txtrate.getText();

        a = a.trim();
        bb = bb.trim();
        c = c.trim();
        d = d.trim();
        e = e.trim();
        f = f.trim();

        int p = 0,n=1;
        int box=Integer.parseInt(bb);
        if(box==0){
            box=1;
        }
        int strip=Integer.parseInt(c);
        quant=box*strip;
        try {
            
           if(BILL==1){
                 n=JOptionPane.showConfirmDialog(this, " Selected Medicine below minimum Stock Limit.\nDo you want to continue");
                
            }
            if(n==JOptionPane.YES_OPTION){   
                
            if(FINAL<=0){
                JOptionPane.showMessageDialog(this, "NO STOCK AVAILABLE");
                return;
            }
          
            if(FINAL>box){
                JOptionPane.showMessageDialog(this, "NOT Enough Medicine Available \n Enter LESS amount ");
                return;
            } 
            if (a.length() == 0) {
                JOptionPane.showMessageDialog(this, "Enter Batch Number");
                return;
            }
            if (r1.isSelected() == true) {
                p = 1;
            }
            if (r2.isSelected() == true) {
                p = 1;
            }
            if (r3.isSelected() == true) {
                p = 1;
            }
            if (r4.isSelected() == true) {
                p = 1;
            }
            if (r5.isSelected() == true) {
                p = 1;
            }
            if (r6.isSelected() == true) {
                p = 1;
            }
            if (p == 0) {

                JOptionPane.showMessageDialog(this, "Please Select type");
                return;
            }

            if (bb.length() == 0) {
                JOptionPane.showMessageDialog(this, "Enter Quantity of boxes");
                return;
            }
            if (c.length() == 0) {
                JOptionPane.showMessageDialog(this, "Enter Number of Strips");
                return;
            }
            if (d.length() == 0) {
                JOptionPane.showMessageDialog(this, "Enter Manufacturing Date");
                return;

            }
            if (e.length() == 0) {
                JOptionPane.showMessageDialog(this, "Enter Expiry Date");
                return;
            }

            if (f.length() == 0) {
                JOptionPane.showMessageDialog(this, "Enter Rate of item");
                return;
            }
            }
            fillTable();
            TableModel tm = jTable1.getModel();

            for (int ii = 0; ii < data.size(); ii++) {
                b = Integer.parseInt(tm.getValueAt(ii, 10).toString());
                total = total + b;
            }

            txttotal1.setText(String.valueOf(total));

            JOptionPane.showMessageDialog(this, "Data Saved");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occured " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
//        JOptionPane.showMessageDialog(this, " Do you want to delete row number"+rowindex+" Please Confirm");//==JOptionPane.YES_OPTION)
//        jTable1.remove(0);
//            
//        
        int rowindex = jTable1.getSelectedRow();
        jTable1.remove(rowindex);
        int a, b;
        b = Integer.parseInt(txtgtotal.getText());

        a = Integer.parseInt(txttotal.getText());
        b = b + a;

        txtgtotal.setText(String.valueOf(b));


    }//GEN-LAST:event_btndeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked


    }//GEN-LAST:event_jTable1MouseClicked

    private void txtrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrateActionPerformed

    private void txtrateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrateFocusLost
        int rate = Integer.parseInt(txtrate.getText());
        int quantity = Integer.parseInt(txtbox.getText());
        int strip = Integer.parseInt(txtstrip.getText());

        String total = String.valueOf(rate * quantity * strip);
        txttotal.setText(total);


    }//GEN-LAST:event_txtrateFocusLost

    private void txtdeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdeliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeliveryActionPerformed

    private void r4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r4ActionPerformed
        lstrips.setText("QUANTITY OF STRIPS*");
        txttab.setVisible(true);
        ltab1.setVisible(true);
        ltab.setVisible(true);
    }//GEN-LAST:event_r4ActionPerformed

    private void r1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r1ActionPerformed
        lstrips.setText("QUANTITY OF INJECTION*");
        txttab.setVisible(false);
        ltab1.setVisible(false);
        ltab.setVisible(false);
    }//GEN-LAST:event_r1ActionPerformed

    private void r2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r2ActionPerformed
        lstrips.setText("QUANTITY OF BOTTLES*");
        txttab.setVisible(false);
        ltab1.setVisible(false);
        ltab.setVisible(false);
    }//GEN-LAST:event_r2ActionPerformed

    private void r3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r3ActionPerformed
        lstrips.setText("QUANTITY OF SACHET*");
        txttab.setVisible(false);
        ltab1.setVisible(false);
        ltab.setVisible(false);
    }//GEN-LAST:event_r3ActionPerformed

    private void m1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_m1FocusLost

    }//GEN-LAST:event_m1FocusLost

    private void r5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r5ActionPerformed
        lstrips.setText("QUANTITY OF BOTTLES*");
        txttab.setVisible(false);
        ltab1.setVisible(false);
        ltab.setVisible(false);
    }//GEN-LAST:event_r5ActionPerformed

    private void r6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r6ActionPerformed
        lstrips.setText("QUANTITY OF BOTTLES*");
        txttab.setVisible(false);
        ltab1.setVisible(false);
        ltab.setVisible(false);
    }//GEN-LAST:event_r6ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String a, bb, c, d, e;

        a = txtdelivery.getText();
        bb = txtsgst.getText();
        c = txtdisc.getText();
        d = txttotal1.getText();
        e = txtgtotal.getText();

        a = a.trim();
        bb = bb.trim();
        c = c.trim();
        d = d.trim();
        e = e.trim();

        if (a.length() == 0) {
            JOptionPane.showMessageDialog(this, "Enter Date Of Billing");
            return;
        }

        if (bb.length() == 0) {
            JOptionPane.showMessageDialog(this, "Enter Total Tax");
            return;
        }

       

        if (d.length() == 0) {
            JOptionPane.showMessageDialog(this, "Enter Total");
            return;
        }

        if (e.length() == 0) {
            JOptionPane.showMessageDialog(this, "Enter Grand Total");
            return;
        }

        int sname = c1.getSelectedIndex();
        String x[] = (String[]) customerlist.get(sname);
        String code = x[0];
        int scode = m1.getSelectedIndex();
        String y[] = (String[]) medicinelist.get(scode);
        String ccode = y[0];

        String billid, medicineid, batch, type, qbox, qitem,qtotal, rate, ggtotal, mfdate, expdate;
        String sgst = txtsgst.getText();
        String igst = txtigst.getText();
        String cgst = txtcgst.getText();
        String discount = txtdisc.getText();
        String delivery = txtdelivery.getText();
        String quantity = txtbox.getText();
        String gtotal = txtgtotal.getText();

         if (c.length() == 0) {
            if (JOptionPane.showConfirmDialog(this, "Do you want to add discount") == JOptionPane.YES_OPTION) {
                return;
           }
            else
                discount="-";
        }
        try {

            String sql = "insert into customerdata (customerid,dateofpurchase,sgst,discount,grandtotal,igst,cgst) values(?,?,?,?,?,?,?)";

            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1, code);
            p.setString(2, delivery);
            p.setString(3, sgst);
            p.setString(4, discount);
            p.setString(5, gtotal);
             p.setString(6, igst);
              p.setString(7, cgst);

            p.executeUpdate();

            String sq2 = "select billid from customerdata order by billid desc";
            PreparedStatement ps = con.prepareStatement(sq2);
            ResultSet rs = ps.executeQuery();
            billid = "";
            if (rs.next()) {
                billid = rs.getString("billid");
            }

//  medicineid=ccode;
//  batch=txtbatch.getText();
//  type="";
//   if(r1.isSelected()==true)
//              type=r1.getText();
//          if(r2.isSelected()==true)
//               type=r2.getText();
//          if(r3.isSelected()==true) 
//              type=r3.getText();
//          if(r4.isSelected()==true)
//               type=r4.getText();
//           if(r5.isSelected()==true)
//               type=r5.getText();
//          if(r6.isSelected()==true)
//               type=r6.getText();
//  qbox=txtbox.getText();
//  qitem=txtstrip.getText();
//  rate=txtrate.getText();
//  ggtotal=txtgtotal.getText();
//  mfdate=txtmandate.getText();
//  expdate=txtexpdate.getText();
            TableModel tm = jTable1.getModel();

            for (int i = 0; i < data.size(); i++) {
                medicineid = (String) tm.getValueAt(i, 1);
                batch = (String) tm.getValueAt(i, 2);
                type = (String) tm.getValueAt(i, 3);
                qbox = (String) tm.getValueAt(i, 4);
                qitem = (String) tm.getValueAt(i, 5);
                qtotal = (String) tm.getValueAt(i, 6);

                rate = (String) tm.getValueAt(i, 7);
                mfdate = (String) tm.getValueAt(i, 8);
                expdate = (String) tm.getValueAt(i, 9);
                ggtotal = (String) tm.getValueAt(i, 10);

                String sl = "insert into solditems (billid,productid,batchnumber,type,quantityofbox,quantityofitem,rate,total,manufacturingdate,expirydate,qtotal) values(?,?,?,?,?,?,?,?,?,?,?)";

                PreparedStatement pp = con.prepareStatement(sl);

                pp.setString(1, billid);
                pp.setString(2, medicineid);
                pp.setString(3, batch);
                pp.setString(4, type);
                pp.setString(5, qbox);
                pp.setString(6, qitem);
                pp.setString(7, rate);
                pp.setString(8, ggtotal);
                pp.setString(9, mfdate);
                pp.setString(10, expdate);
                pp.setString(11, qtotal);

                pp.executeUpdate();

            }
            //fillTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error occured " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        txtdelivery.setText(sd.format(d));
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void txtsgstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsgstFocusLost

    }//GEN-LAST:event_txtsgstFocusLost

    private void txtdiscFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiscFocusLost


    }//GEN-LAST:event_txtdiscFocusLost

    private void b1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_b1FocusLost
   
    }//GEN-LAST:event_b1FocusLost

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        float sgst = 0,igst=0,cgst=0, b = 0,tax=0;
        float discount = 0;
        String disc = txtdisc.getText();
        float total = Integer.parseInt(txttotal1.getText());
        disc = disc.trim();
        if (disc.length() != 0) {

            discount = Integer.parseInt(disc);
            b = (total * discount) / 100;
            total = total - b;
        }
        sgst = Integer.parseInt(txtsgst.getText());
        cgst = Integer.parseInt(txtcgst.getText());
        igst = Integer.parseInt(txtigst.getText());
        b=sgst+cgst+igst;
        tax=(total*b)/100;
        total=total+tax;
        
        txtgtotal.setText(String.valueOf(total));


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        txtdelivery.setText("");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void m1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_m1ItemStateChanged
if(chk==1){
        txtmed.setText(m1.getSelectedItem().toString());   
          
        fillbatchlist();// TODO add your handling code here:

}
    }//GEN-LAST:event_m1ItemStateChanged

    private void txtsgstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsgstFocusGained
        
    }//GEN-LAST:event_txtsgstFocusGained

    private void m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m1ActionPerformed

    private void txtmandateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmandateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmandateActionPerformed

    private void txtexpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtexpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtexpdateActionPerformed

    private void b1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_b1ItemStateChanged
    if(flag==1){
        
            filldate();
            flag1=1;
    }

    }//GEN-LAST:event_b1ItemStateChanged

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
     
    }//GEN-LAST:event_b1MouseClicked

    private void b1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_b1FocusGained
           
    }//GEN-LAST:event_b1FocusGained

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
           if(flag1==1){
        checklist();
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtigstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtigstFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtigstFocusLost

    private void txtigstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtigstFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtigstFocusGained

    private void txtcgstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcgstFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcgstFocusLost

    private void txtcgstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcgstFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcgstFocusGained

    private void txtcgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcgstActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
          int a=Integer.parseInt(txtstrip.getText());
        int b=Integer.parseInt(txtbox.getText());
        int c=Integer.parseInt(txtrate.getText());
        
        int d=b*(a)*c;
        txttotal.setText(String.valueOf(d));
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
      int a=Integer.parseInt(txtstrip.getText());
        int b=Integer.parseInt(txtbox.getText());
        int c=Integer.parseInt(txtrate.getText());
        
        int d=b*(a-1)*c;
        txttotal.setText(String.valueOf(d));
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        int a=Integer.parseInt(txtstrip.getText());
        int b=Integer.parseInt(txtbox.getText());
        int c=Integer.parseInt(txtrate.getText());
        
        int d=b*(a-2)*c;
        txttotal.setText(String.valueOf(d));
        
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void txtigstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtigstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtigstActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox b1;
    private javax.swing.JButton btndelete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox c1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel lbox;
    private javax.swing.JLabel lbox1;
    private javax.swing.JLabel lstrips;
    private javax.swing.JLabel ltab;
    private javax.swing.JLabel ltab1;
    private javax.swing.JComboBox m1;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JRadioButton r3;
    private javax.swing.JRadioButton r4;
    private javax.swing.JRadioButton r5;
    private javax.swing.JRadioButton r6;
    private javax.swing.JTextField txtbox;
    private javax.swing.JTextField txtcgst;
    private javax.swing.JTextField txtdelivery;
    private javax.swing.JTextField txtdisc;
    private javax.swing.JTextField txtexpdate;
    private javax.swing.JTextField txtgtotal;
    private javax.swing.JTextField txtigst;
    private javax.swing.JTextField txtmandate;
    private javax.swing.JLabel txtmed;
    private javax.swing.JTextField txtrate;
    private javax.swing.JTextField txtsgst;
    private javax.swing.JTextField txtstrip;
    private javax.swing.JTextField txttab;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttotal1;
    // End of variables declaration//GEN-END:variables
}
