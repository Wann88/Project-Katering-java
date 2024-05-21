/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Keranjang;

/**
 *
 * @author User
 */
public class Keranjang {
    
    String menu,tgl;
    int hargaMenu,jumlah;
    
    public Keranjang(){}
    
    public Keranjang(String menu,String tgl, int hargaMenu, int jumlah){
    this.menu=menu;
    this.hargaMenu=hargaMenu;
    this.jumlah=jumlah;
    this.tgl=tgl;
    }
    
    public void inputMenu(String menu){
        this.menu = menu;
    
    }
    
    public int ambilhargaMenu(){
        this.hargaMenu=0;
        if(this.menu.equals("I")){
            this.hargaMenu = 1000000;
        }else if (this.menu.equals("II")){
            this.hargaMenu= 2000000;
        }else if (this.menu.equals("III")){
            this.hargaMenu = 3000000;
        }else{
            this.hargaMenu = 4000000;
        }
        return this.hargaMenu;
    }
    
    public void inputJumlah(int jumlah){
        this.jumlah= jumlah;
    }
    
    public int ambilJumlah(){
        return this.jumlah;
    }
    
    public void inputTgl(String tgl){

        this.tgl=tgl;
    }
    public String ambilTgl(){
        return this.tgl;
    }
    

    
    
}
