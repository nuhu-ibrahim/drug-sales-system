package com.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author SHANMA
 */
public class MainMenuTest extends javax.swing.JFrame{

    /**
     * Creates new form MainMenu
     */
    public MainMenuTest(){ 
        Container first= getContentPane();
        
        DBConnect.connect();
        initComponents();
        
        jPanel1.remove(this.date);
        Date date= new Date();
        String today=DateFormat.getDateInstance(DateFormat.FULL).format(date);
        this.date.setText(""+today);
        jPanel1.add("Center", this.date);
        
        loginPage();
    }
    
    public void initComponents2(){
        desktop1 = new javax.swing.JDesktopPane();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        desktop1.setBackground(new java.awt.Color(204, 204, 255));
        desktop1.setPreferredSize(new java.awt.Dimension(880, 450));
        desktop1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contentPanel.setBackground(new java.awt.Color(204, 204, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        desktop1.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 430, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(930, 619));
        setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        optionPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        desktop1.setBackground(new java.awt.Color(204, 204, 255));
        desktop1.setPreferredSize(new java.awt.Dimension(880, 450));
        desktop1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/banner1.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 140));

        desktop1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 140));

        contentPanel.setBackground(new java.awt.Color(204, 204, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        desktop1.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 670, 450));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        date.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("Sun, 02 Jan 2015");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        desktop1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        optionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        desktop1.add(optionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 250, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(930, 619));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void initComponents3() {
        desktop1.removeAll();
        //desktop1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        optionPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        desktop1.setBackground(new java.awt.Color(204, 204, 255));
        desktop1.setPreferredSize(new java.awt.Dimension(880, 450));
        desktop1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/banner1.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 140));

        desktop1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 140));

        contentPanel.setBackground(new java.awt.Color(204, 204, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        desktop1.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 670, 450));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        date.setFont(new java.awt.Font("Traditional Arabic", 1, 16)); // NOI18N
        date.setForeground(new java.awt.Color(0, 0, 153));
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("Sun, 02 Jan 2015");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        desktop1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, -1));

        optionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        desktop1.add(optionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 250, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(930, 619));
        setLocationRelativeTo(null);
        
        jPanel1.remove(this.date);
        Date date= new Date();
        String today=DateFormat.getDateInstance(DateFormat.FULL).format(date);
        this.date.setText(""+today);
        jPanel1.add("Center", this.date);
    }  
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        String msg = "Are you sure you want to Quit Window?";
        int result = JOptionPane.showConfirmDialog(this, msg);
        if (result == JOptionPane.YES_OPTION)
            System.exit(0);
        else {
            int keepOpen = WindowConstants.DO_NOTHING_ON_CLOSE;
            setDefaultCloseOperation(keepOpen);
        }

    }//GEN-LAST:event_formWindowClosing
    LoginPage loginPanel1;    
    Container c;
    
    public Container getContent(){
        return c;
    }
    
    public void loginPage(){
        loginPanel1 = new LoginPage(MainMenuTest.this);
        
        MainMenuTest.jPanel2.setVisible(false);
        jPanel1.setVisible(false);
        optionPanel.setVisible(false);
        MainMenuTest.contentPanel.removeAll();
        MainMenuTest.contentPanel.add(loginPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -5, 465, 410));
        MainMenuTest.contentPanel.setVisible(false);
        MainMenuTest.contentPanel.setVisible(true);
        LoginPage.message.setVisible(false);

    }
        
    public MainMenuTest getMainMenu(){
        return this;
    }
    private Color oldC=new Color(184,184,235);
    private Color newC= new Color(204,204,255);
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuTest().setVisible(true);
            }
        });
    }

    public void blur(){
        c=this.getContentPane();
        JLayer<Component> blurLayer = new JLayer<>(this.getContentPane(), new BlurLayerUI());
        this.setContentPane(blurLayer);
        this.setVisible(false);
        this.setVisible(true);
    }
    public void unblur(){
        this.setContentPane(getContent());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel contentPanel;
    public static javax.swing.JLabel date;
    public static javax.swing.JDesktopPane desktop1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel optionPanel;
    // End of variables declaration//GEN-END:variables
}
