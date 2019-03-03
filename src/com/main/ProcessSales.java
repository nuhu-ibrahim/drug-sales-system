/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;


import com.dataStructures.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.TableColumn;
/**
 *
 * @author NUHU
 */
public class ProcessSales extends javax.swing.JPanel {  
    /**
     * Creates new form CourseReg
     */
    Options main;
    public ProcessSales(Options main) {
        this.main=main;
        DBConnect.connect();
        try{
            //String sql="delete from TempPostTbl";
            String sql="drop table IF EXISTS tempsalestbl";
            DBConnect.st.executeUpdate(sql);
            sql="create TABLE tempsalestbl(SNo int unsigned AUTO_INCREMENT PRIMARY KEY, ID char(6), name varchar(200), quantity varchar(6), amount varchar(30), date DATE, type varchar(15))";
            DBConnect.st.executeUpdate(sql);
            
            String sql2="drop table IF EXISTS tempinventorytbl";
            DBConnect.st.executeUpdate(sql2);
            sql2="create TABLE tempinventorytbl(productID char(6),qty int(11))";
            DBConnect.st.executeUpdate(sql2);
            sql2="insert into tempinventorytbl (productID, qty)"
                + "select productID, qty from inventory";
            DBConnect.st.executeUpdate(sql2);
            
        }catch(Exception sql){
            System.out.println(sql.getMessage());
        }
        initComponents();
        createTable();
    }
    public void createTable(){
        final JTable table;
        TableColumn column = null;
        JScrollPane scrollPane;
        String meta[]={"#","ID", "Name", "Quantity", "Amount"};
        table= MyTable.createTable("Select SNo, ID, name, quantity, amount from tempsalestbl", meta);
        table.setPreferredScrollableViewportSize(new Dimension(663, 180));
        scrollPane = new JScrollPane(table);
       
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try{
                    int row= table.getSelectedRow();
                    String table_click1=table.getModel().getValueAt(row, 0).toString();
                    String table_click2=table.getModel().getValueAt(row, 1).toString();
                    String table_click3=table.getModel().getValueAt(row, 2).toString();
                    String table_click4=table.getModel().getValueAt(row, 3).toString();

                    int rslt=JOptionPane.showConfirmDialog(null,"Are you sure you want to remove pending transaction record for:\n ID => "+table_click2+" \n Name => "+table_click3+"" ,"Confirmation!", JOptionPane.YES_NO_OPTION,1, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-210-cart-out.png")));
                    if(rslt==0){
                        String sql="delete from tempsalestbl where SNo='"+table_click1+"' ";
                        DBConnect.st.executeUpdate(sql);
                        try{
                            DBConnect.con.setAutoCommit(false);
                            String msql="drop table IF EXISTS tempsalestbl2";
                            DBConnect.st.executeUpdate(msql);
                            msql="create TABLE tempsalestbl2(SNo int unsigned AUTO_INCREMENT PRIMARY KEY, ID char(6), name varchar(200), quantity varchar(6), amount varchar(30), date DATE, type varchar(15))";
                            DBConnect.st.executeUpdate(msql);
                            msql="insert into tempsalestbl2 (ID, name, quantity, amount, date)"
                                    + "select ID, name, quantity, amount, date from tempsalestbl";
                            DBConnect.st.executeUpdate(msql);
                            msql="drop table IF EXISTS tempsalestbl";
                            DBConnect.st.executeUpdate(msql);
                            msql="create TABLE tempsalestbl(SNo int unsigned AUTO_INCREMENT PRIMARY KEY, ID char(6), name varchar(200), quantity varchar(6), amount varchar(30), date DATE, type varchar(15))";
                            DBConnect.st.executeUpdate(msql);
                            msql="insert into tempsalestbl (ID, name, quantity, amount, date)"
                                    + "select ID, name, quantity, amount, date from tempsalestbl2";
                            DBConnect.st.executeUpdate(msql);
                            msql="drop table IF EXISTS tempsalestbl2";
                            DBConnect.st.executeUpdate(msql);
                            
                            sql="select * from tempinventorytbl where productID='"+table_click2+"'";
                            DBConnect.rs= DBConnect.st.executeQuery(sql);
                            if(DBConnect.rs.next()){
                                PreparedStatement st;
                                sql="update tempinventorytbl set qty=? where productID=?";
                                st=DBConnect.con.prepareStatement(sql);
                                st.setInt(1, DBConnect.rs.getInt("qty")+Integer.parseInt(table_click4));
                                st.setString(2, table_click2);
                                st.executeUpdate();
                            }
                            DBConnect.con.commit();
                        }catch(SQLException msql){
                            try{
                                DBConnect.con.rollback();
                            }catch(SQLException sqlex){
                                
                            }
                            System.out.println(msql.getMessage());
                        }finally{
                            try{
                                DBConnect.con.setAutoCommit(true);
                            }catch(SQLException sqlex){
                                
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Removed Successfully", "Information!", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-199-ok-circle.png")));
                        createTable();
                    }
                }catch(SQLException ex){
                    
                }
            }
        });
        
        for (int i = 0; i < 5; i++) {
                column = table.getColumnModel().getColumn(i);
                if (i == 0) //MemberID
                        column.setPreferredWidth(40);
                if (i == 1) //ID
                        column.setPreferredWidth(110);
                if (i == 2) //MemberID
                        column.setPreferredWidth(150);
                if (i == 3) //ID
                        column.setPreferredWidth(80);
                if (i == 4) //ID
                        column.setPreferredWidth(80);
        }
        contentPanel.removeAll();
        scrollPane.setViewportView(table);
        contentPanel.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 230));
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        close = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        uDemo16 = new javax.swing.JLabel();
        transType = new javax.swing.JComboBox();
        transPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(new java.awt.Dimension(771, 344));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        close.setText("Close");
        close.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 80, 35));

        insert.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        insert.setText("Complete the Transaction");
        insert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 210, 35));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 56, 330, 230));

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Tiger Expert", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CUSTOMER TRANSACTION PAGE");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 540, 40));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 750, 40));

        uDemo16.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 18)); // NOI18N
        uDemo16.setForeground(new java.awt.Color(0, 0, 102));
        uDemo16.setText("Transaction Type");
        add(uDemo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, 30));

        transType.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        transType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   ", "PRODUCT", "SERVICE" }));
        transType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                transTypeItemStateChanged(evt);
            }
        });
        add(transType, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 55, 130, -1));

        transPanel.setBackground(new java.awt.Color(255, 255, 255));
        transPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        transPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(transPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 280, 185));
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        MainMenuTest.contentPanel.removeAll();
        MainMenuTest.contentPanel.setVisible(false);
        MainMenuTest.contentPanel.setVisible(true);
        
        main.refresh();
    }//GEN-LAST:event_closeActionPerformed
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
    
    public void unblur(){
        main.unblur();
    }
    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        try{
            String sql="select * from tempSalesTbl";
            DBConnect.rs=DBConnect.st.executeQuery(sql);
            if(DBConnect.rs.next()){
                main.blur();
                CustInfo c= new CustInfo(main.getMenu(), true, ProcessSales.this);
                c.setLocationRelativeTo(null);
                c.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "No sales has been performed","Information!", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-196-info-sign.png")));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Issue excecuting query","Issue!", JOptionPane.OK_OPTION, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
        }
    }//GEN-LAST:event_insertActionPerformed

    private void transTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_transTypeItemStateChanged
        if(transType.getSelectedIndex()==0){
            transPanel.removeAll();
            transPanel.setVisible(false);
            transPanel.setVisible(true);
        }else if(transType.getSelectedIndex()==1){
            Thread runner = new Thread() {

                public void run() {
                    Product editForm = new Product(ProcessSales.this);
                    transPanel.removeAll();
                    transPanel.add(editForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0));//, 620, 477) );
                    try {
                        transPanel.setVisible(false);
                        transPanel.setVisible(true);
                    } catch (Exception e) {
                        //JOptionPane.showMessageDialog(null, e.getMessage());
                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
                    }
                }
            };
            runner.start();
        }else if(transType.getSelectedIndex()==2){
            Thread runner = new Thread() {

                public void run() {
                    Service editForm = new Service(ProcessSales.this);
                    transPanel.removeAll();
                    transPanel.add(editForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0));//, 620, 477) );
                    try {
                        transPanel.setVisible(false);
                        transPanel.setVisible(true);
                    } catch (Exception e) {
                        //JOptionPane.showMessageDialog(null, e.getMessage());
                        JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
                    }
                }
            };
            runner.start();
        }
    }//GEN-LAST:event_transTypeItemStateChanged
    
    public void refresh(){
        Thread runner = new Thread() {

            public void run() {
                ProcessSales editForm = new ProcessSales(main);
                MainMenuTest.contentPanel.removeAll();
                MainMenuTest.contentPanel.add(editForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0));//, 620, 477) );
                try {
                    MainMenuTest.contentPanel.setVisible(false);
                    MainMenuTest.contentPanel.setVisible(true);
                } catch (Exception e) {
                    //JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
                }
            }
        };
        runner.start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    public static javax.swing.JPanel contentPanel;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel transPanel;
    private javax.swing.JComboBox transType;
    private javax.swing.JLabel uDemo16;
    // End of variables declaration//GEN-END:variables

}
