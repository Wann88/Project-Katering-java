/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package katering;

import Keranjang.*;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Katering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pemesanan tes = new Pemesanan();
        Scanner input = new Scanner(System.in);
        
        System.out.println("========================Pemesanan================");
        System.out.print("Nama : ");
        tes.inputNama(input.nextLine());
        System.out.print("Masukan Tanggal Pesanan dikirm (dd/mm/yyyy) : ");
        tes.inputTglPengiriman(input.nextLine());
        System.out.print("Masukan Alamat Pengiriman : ");
        tes.inputAlamatPesan(input.nextLine());
        
        System.out.println("========================keranjang================");
        System.out.println("=============Menu============");
        System.out.println("| Paket I   | Rp.1.000.000  |");
        System.out.println("| Paket II  | Rp.2.000.000  |");
        System.out.println("| Paket III | Rp.3.000.000  |");
        System.out.println("| Paket IV  | Rp.4.000.000  |");
        System.out.println("=============================");
        
        
        System.out.print("Masukan Menu : ");
        tes.inputMenu(input.nextLine());
        System.out.print("Masukan Jumlah Pesanan : ");
        tes.inputJumlah(input.nextInt());
        System.out.println("Tanggal Order : 18/05/2024 ");
 
        System.out.println("========================Detail================"); 
        
        System.out.println("Nama :"+tes.ambilNama());
        //System.out.println("Tanggal Order :"+tes.ambilTgl());
        System.out.println("Tanggal kirim :"+tes.ambilTglPengiriman());
        System.out.println("Alamat Pengiriman :"+tes.ambilAlmatPengirim());
        System.out.println("Total Bayar :"+tes.totabayar());
        
        
        
        
    }
    
}
