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
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DP
 */
public class supplierBilling extends javax.swing.JInternalFrame {

    /**
     * Creates new form updatesupplier
     */Connection con;
      int rowindex,flag;
     Vector supplierlist,medicinelist,data;
    public supplierBilling(Connection con) {
        initComponents();
    this.con=con;
        //fillTable();
        fillsupplier();
        fillmedicine();
         setTitle("Supplier biling Entry");
      data=new Vector();
      rowindex=-1;
    }

     
       void fillTable()
    {
         try
        {
               int scode=m1.getSelectedIndex();
                 String y[]=(String[])medicinelist.get(scode);
                  String ccode=y[0];  
            
            
        Vector heading=new Vector();
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
          Vector row=new Vector();
          
        
          row.add(m1.getSelectedItem().toString());
           row.add(ccode);
           row.add(txtbatch.getText());
           if(r1.isSelected()==true)
              row.add(r1.getText());
          if(r2.isSelected()==true)
              row.add(r2.getText());
          if(r3.isSelected()==true)
              row.add(r3.getText());
          if(r4.isSelected()==true)
              row.add(r4.getText());
           if(r5.isSelected()==true)
              row.add(r5.getText());
          if(r6.isSelected()==true)
              row.add(r6.getText());
         
          
           row.add(txtbox.getText());
            
            row.add(txtstrip.getText());
   
   int quantity=Integer.parseInt(txtbox.getText()); 
   int strip=Integer.parseInt(txtstrip.getText()); 

   String total=String.valueOf(quantity*strip);
   Date i = new Date();
            i=txtmandate.getDate();
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

            String h = sd.format(i);
       
            row.add(total);

            row.add(txtrate.getText());
            row.add(h);
            i = txtexpdate.getDate();
            String g = sd.format(i);

            row.add(g);

            row.add(txttotal.getText());


            
            
            data.add(row);
         
            DefaultTableModel df=new DefaultTableModel(data,heading);
            jTable1.setModel(df);
        
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error occured fill table"+ex.getMessage());
            ex.printStackTrace();
        }
        
    }
     
     void fillsupplier()
{
   supplierlist=new Vector();
    
    try
    {
      String sql = "select * from supplier";
    PreparedStatement p = con.prepareStatement(sql);
      ResultSet rs=  p.executeQuery();
    while(rs.next())
    {
        String data[]=new String[2];
        data[0]=rs.getString("spcode");
        data[1]=rs.getString("spname");
        supplierlist.add(data);
        //String code=rs.getString("cname")+"-"+rs.getString("code");
        
        s1.addItem(data[1]);
    }
      
      
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
}
       void fillmedicine()
{
   medicinelist=new Vector();
    
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
        ex.printStackTrace();
    }
}  
  
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
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
        s1 = new javax.swing.JComboBox();
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
        txtbatch = new javax.swing.JTextField();
        r5 = new javax.swing.JRadioButton();
        r6 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
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
        txtmandate = new org.jdesktop.swingx.JXDatePicker();
        txtexpdate = new org.jdesktop.swingx.JXDatePicker();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txttotal1 = new javax.swing.JTextField();
        txtdisc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtgtotal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtsgst = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtcgst = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtigst = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setText("supplier billing record");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(530, 30, 380, 30);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel2.setText("supplier*");

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

        m1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                m1FocusLost(evt);
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

        txtbatch.setOpaque(false);

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

        jLabel16.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel16.setText("scheme");

        jRadioButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton5.setText("none");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton3.setText("10%");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton4.setText("20%");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(s1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(m1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbatch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lstrips)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbox1))
                            .addComponent(ltab)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r6)
                                    .addComponent(lbox)
                                    .addComponent(r1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r2)
                                    .addComponent(r3))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstrip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r5)
                                    .addComponent(r4))
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ltab1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton5)
                                .addGap(16, 16, 16)
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtrate, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
                    .addComponent(add)
                    .addComponent(btndelete))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(90, 90, 480, 590);

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
        jScrollPane1.setBounds(600, 260, 710, 270);

        txtdelivery.setOpaque(false);
        txtdelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdeliveryActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel12.setText("Date of delivery");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 24, Short.MAX_VALUE)
                                        .addComponent(jRadioButton1)
                                        .addGap(98, 98, 98))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(txtdelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtexpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtmandate, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))))))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmandate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtexpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(30, 30, 30))))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(680, 70, 500, 180);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton1");

        txtdisc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdiscFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("discount (in %)");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("SGST (in %)");

        txtsgst.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsgstFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsgstFocusLost(evt);
            }
        });
        txtsgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsgstActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("CGST (in %)");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel8))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtsgst, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel17))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(txtcgst, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtigst, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtdisc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10)
                                                .addGap(17, 17, 17))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(txttotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(txtgtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(292, 292, 292)))))))
                .addGap(57, 57, 57))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(9, 9, 9)
                        .addComponent(txtgtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txttotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtdisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtigst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcgst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(620, 540, 700, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        String a,bb,c,d,e,f;
      
        a=txtbatch.getText();
        bb=txtbox.getText();
        c=txtstrip.getText();
      Date i = new Date();
        i = txtmandate.getDate();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

        String h = sd.format(i);
        d = h;
        i = txtexpdate.getDate();
        String g = sd.format(i);
        e = g;
        f=txtrate.getText();
        
        a=a.trim();
        bb=bb.trim();
        c=c.trim();
        d=d.trim();
        e=e.trim();
        f=f.trim();
         int total=0,b=0;
        int p=0;

        try
        {
            if(a.length()==0){
              JOptionPane.showMessageDialog(this,"Enter Batch Number");
              return ;
          }
          if(r1.isSelected()==true){
           p=1;   
          }
           if(r2.isSelected()==true){
                  p=1;
                  }
           if(r3.isSelected()==true){
                      p=1;
                      }
            if(r4.isSelected()==true){
                p=1;
            }
            if(r5.isSelected()==true){
             p=1;   
            }
            if(r6.isSelected()==true){
             p=1;   
            }
         if(p==0){
             
         
           JOptionPane.showMessageDialog(this,"Please Select type");
           return ;
         }                              
                          
              
          
          if(bb.length()==0){
              JOptionPane.showMessageDialog(this,"Enter Quantity of boxes");
              return ;
          }
          if(c.length()==0){
              JOptionPane.showMessageDialog(this,"Enter Number of Strips");
              return ;
          }
           if(d.length()==0){
              JOptionPane.showMessageDialog(this,"Enter Manufacturing Date");
              return; 
                      
          }
         if(e.length()==0){
              JOptionPane.showMessageDialog(this,"Enter Expiry Date");
              return ;
          }
        
         if(f.length()==0){
              JOptionPane.showMessageDialog(this,"Enter Rate of item");
              return ;
          }
          fillTable();
          TableModel tm =jTable1.getModel();
          
        for(int ii=0;ii<data.size();ii++){
             b=Integer.parseInt(tm.getValueAt(ii, 10).toString());
            total=total+b;
        }
           
        txttotal1.setText(String.valueOf(total));



            JOptionPane.showMessageDialog(this, "Data Saved");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error occured "+ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
//        JOptionPane.showMessageDialog(this, " Do you want to delete row number"+rowindex+" Please Confirm");//==JOptionPane.YES_OPTION)
//        jTable1.remove(0);
//            
//        
              int rowindex= jTable1.getSelectedRow();
              jTable1.remove(rowindex);
            int a,b;
            b=Integer.parseInt(txtgtotal.getText());
          
            a=Integer.parseInt(txttotal.getText());
          b=b+a;
          
           txtgtotal.setText(String.valueOf(b));

     
    }//GEN-LAST:event_btndeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    
 
      
        

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrateActionPerformed

    private void txtrateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrateFocusLost
   int rate=Integer.parseInt(txtrate.getText());
   int quantity=Integer.parseInt(txtbox.getText()); 
   int strip=Integer.parseInt(txtstrip.getText()); 

   String total=String.valueOf(rate*quantity*strip);
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
 
        String a,bb,c,d,e,bb1;
      
        a=txtdelivery.getText();
        bb = txtsgst.getText();
        bb1 = txtcgst.getText();
        c=txtdisc.getText();
        d=txttotal1.getText(); 
        e=txtgtotal.getText();
        
        a=a.trim();
        bb=bb.trim();
        bb1=bb1.trim();
        c=c.trim();
        d=d.trim();
        e=e.trim();
       

       
        
            if(a.length()==0){
              JOptionPane.showMessageDialog(this,"Enter Date Of Delevery");
              return ;
            } 
        
            if(bb.length()==0){
              JOptionPane.showMessageDialog(this,"Enter SGST");
              return ;
            } 
              if(bb1.length()==0){
              JOptionPane.showMessageDialog(this,"Enter CGST");
              return ;
            } 
            
            if(c.length()==0){
              if(JOptionPane.showConfirmDialog(this, "Do you want to add discount")==JOptionPane.YES_OPTION)
              return ;
            } 
            
            if(d.length()==0){
              JOptionPane.showMessageDialog(this,"Enter Total");
              return ;
            } 
            
            
            if(e.length()==0){
              JOptionPane.showMessageDialog(this,"Enter Grand Total");
              return ;
            } 
            
            
            
        int sname=s1.getSelectedIndex();
      String x[]=(String[])supplierlist.get(sname);
           String code=x[0];  
         int scode=m1.getSelectedIndex();
      String y[]=(String[])medicinelist.get(scode);
           String ccode=y[0];  
           
           String orderid,medicineid,batch,type,qbox,qitem,qtotal,rate,ggtotal,mfdate,expdate;
          String sgst = txtsgst.getText();
        String igst = txtigst.getText();
        String cgst = txtcgst.getText();
          String discount=txtdisc.getText();
          String delivery=txtdelivery.getText();
          String quantity=txtbox.getText();
          String gtotal=txtgtotal.getText();
          
         

          
        try
        {
          
            String sql = "insert into supplierdata (supplierid,dateofdelivery,sgst,discount,grandtotal,cgst,igst) values(?,?,?,?,?,?,?)";

            PreparedStatement p = con.prepareStatement(sql);

            p.setString(1, code);
            p.setString(2, delivery);
            p.setString(3, sgst);
            p.setString(4, discount);
            p.setString(5, gtotal);
            p.setString(6, igst);
              p.setString(7, cgst);
            p.executeUpdate();

            
            
            
String sq2 = "select orderid from supplierdata order by orderid desc";
PreparedStatement ps=con.prepareStatement(sq2);
ResultSet rs=ps.executeQuery();
orderid="";
if(rs.next()){
  orderid=rs.getString("orderid");
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
  
     TableModel tm =jTable1.getModel();
     
for(int i=0;i<data.size();i++)
{
    medicineid=(String)tm.getValueAt(i,1);
    batch=(String)tm.getValueAt(i,2);
    type=(String)tm.getValueAt(i,3);
    qbox=(String)tm.getValueAt(i,4);
    qitem=(String)tm.getValueAt(i,5);
    qtotal=(String)tm.getValueAt(i,6);
    rate=(String)tm.getValueAt(i,7);
    mfdate=(String)tm.getValueAt(i,8);
    expdate=(String)tm.getValueAt(i,9);
    ggtotal=(String)tm.getValueAt(i,10);

   String sl = "insert into boughtitems (orderid,productid,batchnumber,type,quantityofbox,quantityofitem,rate,total,manufacturingdate,expirydate,qtotal) values(?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pp = con.prepareStatement(sl);

            pp.setString(1, orderid);
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
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error occured "+ex.getMessage());
            ex.printStackTrace();
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       Date d=new Date();
        SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");
        txtdelivery.setText(sd.format(d));
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void txtdiscFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiscFocusLost
    
    }//GEN-LAST:event_txtdiscFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       float sgst = 0,igst=0,cgst=0, b = 0,tax=0;
        float discount = 0;
       try{
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
       try{
        igst = Integer.parseInt(txtigst.getText());
       }
       catch(Exception e){
           igst=0;
       }
        b=sgst+cgst+igst;
        tax=(total*b)/100;
        total=total+tax;
        
        txtgtotal.setText(String.valueOf(total));
       }
       catch(Exception ee){
           JOptionPane.showMessageDialog(this,"Enter all values");
       }
     
       
       
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
      txtdelivery.setText(""); 
    }//GEN-LAST:event_jRadioButton2ActionPerformed

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

    private void txtsgstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsgstFocusGained

    }//GEN-LAST:event_txtsgstFocusGained

    private void txtsgstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsgstFocusLost

    }//GEN-LAST:event_txtsgstFocusLost

    private void txtcgstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcgstFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcgstFocusGained

    private void txtcgstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcgstFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcgstFocusLost

    private void txtcgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcgstActionPerformed

    private void txtigstFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtigstFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtigstFocusGained

    private void txtigstFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtigstFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtigstFocusLost

    private void txtigstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtigstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtigstActionPerformed

    private void txtsgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsgstActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton btndelete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
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
    private javax.swing.JComboBox s1;
    private javax.swing.JTextField txtbatch;
    private javax.swing.JTextField txtbox;
    private javax.swing.JTextField txtcgst;
    private javax.swing.JTextField txtdelivery;
    private javax.swing.JTextField txtdisc;
    private org.jdesktop.swingx.JXDatePicker txtexpdate;
    private javax.swing.JTextField txtgtotal;
    private javax.swing.JTextField txtigst;
    private org.jdesktop.swingx.JXDatePicker txtmandate;
    private javax.swing.JTextField txtrate;
    private javax.swing.JTextField txtsgst;
    private javax.swing.JTextField txtstrip;
    private javax.swing.JTextField txttab;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttotal1;
    // End of variables declaration//GEN-END:variables
}
