package tiket.wisata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLConnection {
       Connection con;
       Statement stm;
        
        public void config() {
             try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiketwisata","root","");
              stm = con.createStatement();
              System.out.println("Berhasil terhubung ke database");
          } catch (Exception e) {
              System.out.println("Gagal terhubung ke database " + e.getMessage());
          }
        } 
}
