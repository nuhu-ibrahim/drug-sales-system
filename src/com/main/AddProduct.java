/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;

import com.dataStructures.MyContainer;
import com.dataStructures.MyVisitor;
import static com.main.MainMenuTest.contentPanel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author NUHU
 */
public class AddProduct extends javax.swing.JPanel {

    /**
     * Creates new form AddUser
     */
    public AddProduct(Options main) {
        initComponents();
        this.main=main;
    }

    Options main;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        uDemo16 = new javax.swing.JLabel();
        uDemo14 = new javax.swing.JLabel();
        productID = new javax.swing.JTextField();
        productName = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        upload = new javax.swing.JButton();
        uDemo15 = new javax.swing.JLabel();
        charge = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(360, 347));
        setPreferredSize(new java.awt.Dimension(758, 231));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Tiger Expert", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ADD DRUG INFORMATION");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 540, 40));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 750, 40));

        uDemo16.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 18)); // NOI18N
        uDemo16.setForeground(new java.awt.Color(0, 0, 102));
        uDemo16.setText("Drug ID");
        add(uDemo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 30));

        uDemo14.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 18)); // NOI18N
        uDemo14.setForeground(new java.awt.Color(0, 0, 102));
        uDemo14.setText("Drug Name");
        add(uDemo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        productID.setBackground(new java.awt.Color(204, 204, 255));
        productID.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        productID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        add(productID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 380, -1));

        productName.setBackground(new java.awt.Color(204, 204, 255));
        productName.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        productName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        add(productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 380, -1));

        cancel.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        cancel.setText("Close");
        cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 90, 35));

        upload.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        upload.setText("Upload Product");
        upload.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });
        add(upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 190, 35));

        uDemo15.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 18)); // NOI18N
        uDemo15.setForeground(new java.awt.Color(0, 0, 102));
        uDemo15.setText("Charge");
        add(uDemo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 30));

        charge.setBackground(new java.awt.Color(204, 204, 255));
        charge.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        charge.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        add(charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 380, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        MainMenuTest.contentPanel.removeAll();
        MainMenuTest.contentPanel.setVisible(false);
        MainMenuTest.contentPanel.setVisible(true);
        
        main.refresh();
    }//GEN-LAST:event_cancelActionPerformed
    
    public String ucfirst(String s){
        try{
            String first, second;
            first=s.substring(0,1);
            second=s.substring(1);
            return first.toUpperCase()+second.toLowerCase();
        }catch(Exception ex){
            return "";
        }
    }
    
    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        String productID=this.productID.getText().trim();
        String productName=this.productName.getText().trim();
        String charge= this.charge.getText().trim();
        
        productName=ucfirst(productName);
        productID= productID.toUpperCase();
        
        MyContainer c= new MyContainer();
        
        String patProductID = "^[a-zA-Z0-9]{6}$";
        String patProductName = "^[a-zA-Z0-9].{3,30}$";
        String patCharge = "^(([1-9](\\d*|\\d{0,2}(,\\d{3})*))|0)(\\.\\d{1,2})?";
 
        if(!Pattern.matches(patProductID, productID)){
            c.insert("Invalid Drug ID");
        }
        if(!Pattern.matches(patProductName, productName)){
            c.insert("Invalid Drug Name");
        }
        if(!Pattern.matches(patCharge, charge)){
            c.insert("Invalid Charge Amount");
        }
        
        if(this.productID.getText().equals("") || this.productName.getText().equals("") || this.charge.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Empty Fields","Error!",JOptionPane.OK_OPTION,  new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
        }else if(c.getCount()!=0){
            MyVisitor v= new MyVisitor();
            c.accept(v);
            
            JOptionPane.showMessageDialog(null,v.getErrors(), "Error!", JOptionPane.OK_OPTION,  new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
        }else{
            String sql;
            try{
                sql="select * from product where productID='"+productID+"'";
                DBConnect.rs= DBConnect.st.executeQuery(sql);
                if(DBConnect.rs.next()){
                    JOptionPane.showMessageDialog(null, "Drug ID already exist","Issue!", JOptionPane.OK_OPTION, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
                }else{
                    PreparedStatement st;
                    sql="insert into product values (?,?,?)";
                    st= DBConnect.con.prepareStatement(sql);
                    st.setString(1, productID);
                    st.setString(2, productName);
                    st.setDouble(3, Double.parseDouble(charge));
                    st.executeUpdate();
                    
                    sql="insert into inventory values (?,?)";
                    st= DBConnect.con.prepareStatement(sql);
                    st.setString(1, productID);
                    st.setInt(2, 0);
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Drug Information Uploaded","Success!", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-199-ok-circle.png")));
                    //Refresh page
                    refresh();
                }
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Issue excecuting query","Issue!", JOptionPane.OK_OPTION,  new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
            }finally{
                c.purge();
                DBConnect.rs=null;
            }
        }
        
    }//GEN-LAST:event_uploadActionPerformed
    
    public void refresh(){
        Thread runner = new Thread() {

            public void run() {
                AddProduct editForm = new AddProduct(main);
                contentPanel.removeAll();
                contentPanel.add(editForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0));//, 620, 477) );
                try {
                    contentPanel.setVisible(false);
                    contentPanel.setVisible(true);
                } catch (Exception e) {
                    //JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
                }
            }
        };
        runner.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField charge;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField productID;
    private javax.swing.JTextField productName;
    private javax.swing.JLabel uDemo14;
    private javax.swing.JLabel uDemo15;
    private javax.swing.JLabel uDemo16;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables
}