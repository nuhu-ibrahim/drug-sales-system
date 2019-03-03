/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.main;


import com.dataStructures.MyContainer;
import com.dataStructures.MyTable;
import com.dataStructures.MyVisitor;
import com.dataStructures.ResultSetTableModel;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author NUHU
 */
public class ViewSalesInfo extends javax.swing.JPanel {

    Options main;
    public ViewSalesInfo(Options main) {
        this.main=main;
        DBConnect.connect();
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        uDemo16 = new javax.swing.JLabel();
        fromDate = new javax.swing.JTextField();
        uDemo17 = new javax.swing.JLabel();
        toDate = new javax.swing.JTextField();
        generate = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        compute1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(new java.awt.Dimension(755, 455));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 12, 92)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uDemo16.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 18)); // NOI18N
        uDemo16.setForeground(new java.awt.Color(0, 0, 102));
        uDemo16.setText("From (Date)");
        jPanel2.add(uDemo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        fromDate.setBackground(new java.awt.Color(204, 204, 255));
        fromDate.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        fromDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, -1));

        uDemo17.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 18)); // NOI18N
        uDemo17.setForeground(new java.awt.Color(0, 0, 102));
        uDemo17.setText("To (Date)");
        jPanel2.add(uDemo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, 30));

        toDate.setBackground(new java.awt.Color(204, 204, 255));
        toDate.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        toDate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 110, -1));

        generate.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        generate.setText("Generate Report");
        generate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateActionPerformed(evt);
            }
        });
        jPanel2.add(generate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 45, 170, 35));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 490, 90));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 630, 200));

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tiger Expert", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("VIEW TRANSACTION REPORT");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 40));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 40));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tiger Expert", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("REPORT");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 580, 40));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 740, -1));

        compute1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        compute1.setText("Close");
        compute1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153), 2));
        compute1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compute1ActionPerformed(evt);
            }
        });
        add(compute1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 170, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void compute1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compute1ActionPerformed
        MainMenuTest.contentPanel.removeAll();
        MainMenuTest.contentPanel.setVisible(false);
        MainMenuTest.contentPanel.setVisible(true);
        
        main.refresh();
    }//GEN-LAST:event_compute1ActionPerformed
    
    private void createTable(){
        String sql="select ID, name, quantity, amount, date, custname, custNumber from salestbl where date between '"+fromDate.getText()+"' and '"+toDate.getText()+"'";

        JTable table;
        TableColumn column = null;
        JScrollPane scrollPane;
        String meta[]={"ID", "Name", "Quantity", "Amount", "Date", "Cust. Name", "Cust. #"};
        table= MyTable.createTable(sql, meta);
        table.setPreferredScrollableViewportSize(new Dimension(763, 180));
        scrollPane = new JScrollPane(table);
        for (int i = 0; i < 6; i++) {
                column = table.getColumnModel().getColumn(i);
                if (i == 0) //MemberID
                        column.setPreferredWidth(50);
                if (i == 1) //ID
                        column.setPreferredWidth(200);
                if (i == 2) //MemberID
                        column.setPreferredWidth(50);
                if (i == 3) //ID
                        column.setPreferredWidth(70);
                if (i == 4) //MemberID
                        column.setPreferredWidth(70);
                if (i == 5) //ID
                        column.setPreferredWidth(200);  
                if (i == 6) //ID
                        column.setPreferredWidth(150);  
        }
        contentPanel.removeAll();
        scrollPane.setViewportView(table);
        contentPanel.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 190));
        contentPanel.setVisible(false);
        contentPanel.setVisible(true);
    }
    
    private void generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateActionPerformed
        String fromDate=this.fromDate.getText().trim();
        String toDate=this.toDate.getText().trim();
        
        MyContainer c= new MyContainer();
        
        String patDate="^[0-9]{4}-(01|02|03|04|05|06|07|08|09|10|11|12)-([0-2][1-9]|3[0-1])$";
        
        if(!Pattern.matches(patDate, fromDate)){
            c.insert("Invalid from Date, dates should be written in format yyyy-mm-dd");
        }
        if(!Pattern.matches(patDate, toDate)){
            c.insert("Invalid to Date, dates should be written in format yyyy-mm-dd");
        }
        if(this.toDate.getText().trim().equals("") || this.fromDate.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Empty Fields", "Issue!", JOptionPane.OK_OPTION, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
        }else if(c.getCount()!=0){
            MyVisitor v= new MyVisitor();
            c.accept(v);
            
            JOptionPane.showMessageDialog(null,v.getErrors(), "Error!", JOptionPane.OK_OPTION, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
        }else{
            try{
                PreparedStatement st;
                String sql="select * from salestbl where date between ? and ?";
                st=DBConnect.con.prepareStatement(sql);
                st.setString(1, fromDate);
                st.setString(2, toDate);
                DBConnect.rs=st.executeQuery();
                
                if(DBConnect.rs.next()){
                    //Populate the table
                    createTable();
                }else{
                    JOptionPane.showMessageDialog(null, "No record exist for the period specified","Information!", JOptionPane.INFORMATION_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-196-info-sign.png")));
                    //clear the table
                    contentPanel.removeAll();
                    
                    contentPanel.setVisible(false);
                    contentPanel.setVisible(true);
                }
            }catch(SQLException sqlEx){
                JOptionPane.showMessageDialog(null, "Issues excecuting query","Issue!", JOptionPane.OK_OPTION, new javax.swing.ImageIcon(getClass().getResource("/com/images/png/glyphicons-197-exclamation-sign.png")));
                //Clear the table
                contentPanel.removeAll();
                    
                contentPanel.setVisible(false);
                contentPanel.setVisible(true);
            }
        }
    }//GEN-LAST:event_generateActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compute1;
    public static javax.swing.JPanel contentPanel;
    private javax.swing.JTextField fromDate;
    private javax.swing.JButton generate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField toDate;
    private javax.swing.JLabel uDemo16;
    private javax.swing.JLabel uDemo17;
    // End of variables declaration//GEN-END:variables
    public static String getMsg(){
        return "UNIT PERSONNEL INFORMATION PAGE";
    }
}