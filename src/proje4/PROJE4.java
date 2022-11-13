package proje4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class PROJE4 {

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String isim;
        oyunTahtasi oyun = new oyunTahtasi();
        System.out.println("Kullanıcı adını giriniz.");
        isim = keyboard.nextLine();
        System.out.println("Hoşgeldin " + isim);
        String birinci = "X";
        String ikinci = "O";
        int a = 0;
        oyun.gosterTahta();
        
        int x = 1;
        if (oyun.kisiSayisi() == 2) {
            while (oyun.oyunhazir()) {
                if (x % 2 == 0) {
                    oyun.oyuncusor('O');
                } else {
                    oyun.oyuncusor('X');
                }
                x++;
                oyun.gosterTahta();
                oyun.kazanan();
                oyun.beraberlikKontrol(1);
            }
        } else {
            System.out.println("Oynamak istediğiniz harfi seçiniz.(X veya O)");
        String girilecek = keyboard.nextLine();
        if (!(girilecek.equals(birinci) || girilecek.equals(ikinci))) {
            while (a != 1) {
                System.out.println("Oynamak istediğiniz harfi seçiniz.(X veya O)");
                girilecek = keyboard.nextLine();
                if ((girilecek.equals(birinci) || girilecek.equals(ikinci))) {
                    a = 1;
                }
            }
        }
            if (girilecek.equalsIgnoreCase(birinci)) {
                while (oyun.oyunhazir()) {
                    if (x % 2 == 0) {
                        oyun.bilgisayarHamlesiUret('O');
                    } else {
                        oyun.oyuncusor('X');
                    }
                    x++;
                    oyun.gosterTahta();
                    oyun.kazanan();
                    oyun.beraberlikKontrol(1);
                }
            }
            if (girilecek.equalsIgnoreCase(ikinci)) {
                while (oyun.oyunhazir()) {
                    if (x % 2 == 0) {
                        oyun.bilgisayarHamlesiUret('X');
                    } else {
                        oyun.oyuncusor('O');
                    }
                    x++;
                    oyun.gosterTahta();
                    oyun.kazanan();
                    oyun.beraberlikKontrol(1);
                }
            }
        }  
        
    }

}
