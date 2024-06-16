/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class koneksi {
    private String databaseName="wanda_2210010321";
    private String username="root";
    private String password="";
    private String lokasi="jdbc:mysql://localhost/"+databaseName;
    public static Connection koneksiDB;
    
    
    public koneksi(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB=DriverManager.getConnection(lokasi,username,password);
            System.out.println("Database Terkoneksi");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
    //coding tabel pelanggan
    
    public void ubahKatering(int ketId, String ketUsername, String ketPassword, String ketNama, String ketAlamat, String ketTelp){
        try {
            String SQL="UPDATE pelanggan SET username=?, password=?, nama=?, alamat=?, telp=? WHERE id_pelanggan=?";
            
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setString(1,ketUsername);
           perintah.setString(2,ketPassword);
           perintah.setString(3,ketNama);
           perintah.setString(4,ketAlamat);
           perintah.setString(5,ketTelp);
           perintah.setInt(6,ketId);
           perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
 
        
    }
    
        public void simpanKatering(int ketId, String ketUsername, String ketPassword, String ketNama, String ketAlamat, String ketTelp){
        try {
            String SQL="INSERT INTO pelanggan(id_pelanggan,username,password,nama,alamat,telp)"
                    +"VALUE(?,?,?,?,?,?)";
            
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,ketId);
           perintah.setString(2,ketUsername);
           perintah.setString(3,ketPassword);
           perintah.setString(4,ketNama);
           perintah.setString(5,ketAlamat);
           perintah.setString(6,ketTelp);
           perintah.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
 
        
    }
        
      public void hapusKatering(int ketId){
          try {
              String SQL ="DELETE FROM Pelanggan WHERE id_pelanggan=?";
              PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
              perintah.setInt(1, ketId);
              perintah.executeUpdate();
              System.out.println("Data berhasil dihapus");
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
          
      }
      
      public void cariKatering(int ketId){
          try {
              String SQL="SELECT*FROM Pelanggan WHERE id_pelanggan=?";
              PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
              perintah.setInt(1, ketId);
              ResultSet data = perintah.executeQuery();
              while(data.next()){
                  System.out.println("ID :"+data.getInt("id_pelanggan"));
                  System.out.println("NAMA :"+data.getString("username"));
                  System.out.println("Alamat :"+data.getString("password"));
                  System.out.println("Tanggal Kirim :"+data.getString("nama"));
                  System.out.println("Menu :"+data.getString("alamat"));
                  System.out.println("Total Bayar :"+data.getString("telp"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
      public void dataKatering(){
          try {
              Statement state = koneksiDB.createStatement();
              ResultSet baris= state.executeQuery("SELECT*FROM pelanggan ORDER BY id_pelanggan ASC");
              while(baris.next()){
                  System.out.println(baris.getInt("id_pelanggan")+" |" +
                          baris.getString("username")+" | "+
                          baris.getString("password")+" | "+
                          baris.getString("nama")+" | "+
                          baris.getString("alamat")+" | "+
                          baris.getString("telp"));
              }
          } catch (Exception e) {
             System.err.println(e.getMessage());  
          }
      }
      //akhir tabel pelanggan
      
      //awal tabel pemesanan
          public void ubahPemesanan(int pemId, String pemTgl, int pemId_pelanggan, String pemAlamat, String pemTotal){
        try {
            String SQL="UPDATE pemesanan SET tgl_pesan=?, id_pelanggan=?, alamat_pengirim=?, total_bayar=? WHERE id_pemesanan=?";
            
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setString(1,pemTgl);
           perintah.setInt(2,pemId_pelanggan);
           perintah.setString(3,pemAlamat);
           perintah.setString(4,pemTotal);
           perintah.setInt(5,pemId);
           perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
          
        public void simpanPemesanan(int pemId, String pemTgl, int pemId_pelanggan, String pemAlamat, String pemTotal){
        try {
            String SQL="INSERT INTO pemesanan(id_pemesanan,tgl_pesan,id_pelanggan,alamat_pengirim,total_bayar)"
                    +"VALUE(?,?,?,?,?)";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,pemId);
           perintah.setString(2,pemTgl);
           perintah.setInt(3,pemId_pelanggan);
           perintah.setString(4,pemAlamat);
           perintah.setString(5,pemTotal);
           
           perintah.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        public void hapusPemesanan(int pemId){
          try {
              String SQL ="DELETE FROM Pemesanan WHERE id_pemesanan=?";
              PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
              perintah.setInt(1, pemId);
              perintah.executeUpdate();
              System.out.println("Data berhasil dihapus");
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
          
      }
       //akhir tabel pemesanan
        
       //awal tabel keranjang
        public void ubahKeranjang(int kerId, int kerId_menu, String kerHarga, String kerJumlah,String kerTgl,int kerId_pemesanan ){
        try {
            String SQL="UPDATE keranjang SET id_menu=?, harga=?, jumlah=?, tgl_order=?, id_pemesanan=? WHERE id_keranjang=?";
            
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,kerId_menu);
           perintah.setString(2,kerHarga);
           perintah.setString(3,kerJumlah);
           perintah.setString(4,kerTgl);
           perintah.setInt(5,kerId_pemesanan);
           perintah.setInt(6,kerId);
           perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        
        public void simpanKeranjang(int kerId, int kerId_menu, String kerHarga, String kerJumlah,String kerTgl,int kerId_pemesanan ){
        try {
            String SQL="INSERT INTO keranjang(id_keranjang,id_menu,harga,jumlah,tgl_order,id_pemesanan)"
                    +"VALUE(?,?,?,?,?,?)";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,kerId);
           perintah.setInt(2,kerId_menu);
           perintah.setString(3,kerHarga);
           perintah.setString(4,kerJumlah);
           perintah.setString(5,kerTgl);
           perintah.setInt(6,kerId_pemesanan);
           
           perintah.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
          public void hapusKeranjang(int kerId){
          try {
              String SQL ="DELETE FROM Keranjang WHERE id_keranjang=?";
              PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
              perintah.setInt(1, kerId);
              perintah.executeUpdate();
              System.out.println("Data berhasil dihapus");
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
          
      }
          
   //akhir tabel keranjang
          
   //awal tabel detail pemesanan
        public void ubahDetail(int detId, int detId_pemesanan, int detId_menu ){
        try {
            String SQL="UPDATE detail_pemesanan SET id_pemesanan=?, id_menu=? WHERE id_det_pemesanan=?";
            
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,detId_pemesanan);
           perintah.setInt(2,detId_menu);
           perintah.setInt(3,detId);
           perintah.executeUpdate();
            System.out.println("Data berhasil diubah");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
        public void simpanDetail(int detId, int detId_pemesanan, int detId_menu ){
        try {
            String SQL="INSERT INTO detail_pemesanan(id_det_pemesanan,id_menu,id_pemesanan)"
                    +"VALUE(?,?,?)";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,detId);
           perintah.setInt(2,detId_pemesanan);
           perintah.setInt(3,detId_menu);
           perintah.executeUpdate();
            System.out.println("Data berhasil disimpan");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
          public void hapusDetail(int detId){
          try {
              String SQL ="DELETE FROM detail_pemesanan WHERE id_det_pemesanan=?";
              PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
              perintah.setInt(1, detId);
              perintah.executeUpdate();
              System.out.println("Data berhasil dihapus");
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
          
      }      
}
