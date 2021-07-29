package tiket.wisata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        
        MySQLConnection DB = new MySQLConnection();
        DB.config();
        con = DB.con;
        st = DB.stm;
        
        try {
            // menggunakan query seperti ini agar posisi ketika status true berada diatas 
            // ketika hanya menggunakan query status = "true" or status = "false" maka yang dibacanya hanya akan false nya saja alias data pada posisi 1
            String mysql = "SELECT * FROM tblogin order by status desc";
            PreparedStatement stmt = con.prepareStatement(mysql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String status = rs.getString("status");
                // print untuk mengecek status yang didapatkan dari query tersebut 
                System.out.println(status);
                String username =  rs.getString("username");
                // print untuk mengecek username yang didapatkan dari query tersebut 
                System.out.println(username);
                if (rs.next()) {
                    if ("true".equals(status)) {
                        Home home = new Home(username);
                        home.setVisible(true);
                    } else {
                        SignIn masuk = new SignIn();
                        masuk.setVisible(true);
                        masuk.setTitle("Login");
                    }
                }    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan " + ex);
        }     
         
    }
}
