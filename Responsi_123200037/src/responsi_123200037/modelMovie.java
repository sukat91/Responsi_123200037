
package responsi_123200037;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class modelMovie {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/movie_db"; 
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public modelMovie(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    
    public String[][] readdata(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5]; 

            String query = "Select * from movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Judul"); 
                data[jmlData][1] = String.valueOf(resultSet.getDouble("alur"));
                data[jmlData][2] = String.valueOf(resultSet.getDouble("penokohan"));
                data[jmlData][3] = String.valueOf(resultSet.getDouble("akting"));
                data[jmlData][4] = String.valueOf(resultSet.getDouble("nilai"));
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
          public void insertData(String Judul, double Alur, double Penokohan, double Akting, double Nilai){
        int jmlData=0;
        try {String query = "SELECT * FROM movie WHERE judul='" + Judul +"'"; 
           System.out.println(Judul + " " + Alur + " " + Penokohan + " " + Akting);
           ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) { 
                query = "INSERT INTO movie(judul,alur,penokohan,akting,nilai) VALUES('"+ Judul +"','"+ Alur +"','"+ Penokohan +"','"+ Akting +"','"+ Nilai +"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); 
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
               public void updateData(String Judul, double Alur, double Penokohan, double Akting, double Nilai){
        int jmlData=0;
         try {
           String query = "SELECT * FROM movie WHERE judul='" + Judul +"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE movie SET alur='" + Alur + "', penokohan='" + Penokohan + "',akting = '" + Akting  +"', nilai='"+Nilai+"' WHERE judul='" + Judul +"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); 
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
          public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * FROM movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
         
          
        public void deletedata (String Judul) {
        try{
            String query = "DELETE FROM movie WHERE judul = '"+Judul+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }    
     }

