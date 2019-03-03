/*
 * DBConnection
 */
package com.main;
import javax.swing.JOptionPane;
import java.sql.*;
public class DBConnect {
    public static Connection con;
    public static ResultSet rs;
    public static Statement st;
    public static void connect(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/drugs_sales_system", "root", "");
            st=con.createStatement();
        }catch (SQLException e){ 
            JOptionPane.showMessageDialog(null, "Cannot connect to the database","Issue!", JOptionPane.OK_OPTION);
        } 
    }
    public static void main (String [] args){
        connect();
    }
}
