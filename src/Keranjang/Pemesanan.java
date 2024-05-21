/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Keranjang;

/**
 *
 * @author User
 */
public class Pemesanan extends Keranjang{
    
    String alamatPengirim,nama,tglPengriman;
    int totalBayar;
    public Pemesanan(){}
    
    public Pemesanan(String alamatPengiriman, String nama,int totalBayar){
        this.alamatPengirim=alamatPengiriman;
        this.totalBayar=totalBayar;

        this.nama=nama;

    }
    
    public void inputAlamatPesan(String alamatPengirim){
        this.alamatPengirim= alamatPengirim;
    }
    
    public String ambilAlmatPengirim(){
        return this.alamatPengirim;
    }
    
    
    public void inputNama(String nama){
        this.nama=nama;
    }
    
    public String ambilNama(){
        return this.nama;
    }
    
    public void inputTglPengiriman(String tglPengiriman){
    this.tglPengriman= tglPengiriman;
    }
    
    public String ambilTglPengiriman(){
        return this.tglPengriman;
    }
    
    public int totabayar(){
        return ambilhargaMenu()*ambilJumlah();
    }
    
    
}
