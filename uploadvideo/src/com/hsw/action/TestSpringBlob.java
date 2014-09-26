package com.hsw.action;

import java.sql.*;

public class TestSpringBlob {
	static String url = "jdbc:mysql://106.38.138.177:3306/test";
    static String usr = "root";
    static String psd = "hsw24000";
 
    public static void main(String args[]) {
       Connection conn = null;
       try {
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(url, usr, psd);
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("SELECT * FROM user");
           while (rs.next()) {
              System.out.print(rs.getString(1));
              System.out.print("  ");
               System.out.println(rs.getString(2));
           }
           rs.close();
           st.close();
           conn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
