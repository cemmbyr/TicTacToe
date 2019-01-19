package proje4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class oyunTahtasi {

    private char[][] oyuntahtasi;
    private boolean oyunhazirla = true;
    private boolean oyuncuOzellik;

    public oyunTahtasi() {
        Scanner keyboard = new Scanner(System.in);
        int n;
        System.out.println("Tic Tac Toe oyununun boyutunu(3,5,7) giriniz.");
        n = keyboard.nextInt();
        while (n != 3 && n != 5 && n != 7) {
            System.out.println("Tic Tac Toe oyununun boyutunu(3,5,7) giriniz.");
            n = keyboard.nextInt();
        }
        oyuntahtasi = new char[n][n];
        for (int i = 0; i < oyuntahtasi.length; i++) {
            Arrays.fill(oyuntahtasi[i], ' ');
        }

    }

    public int kisiSayisi() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Oyun kaç oyunculu olsun?(2 veya 1)");
        int sayi;
        String birinci = "X";
        String ikinci = "O";
        String girilecek;
        sayi = keyboard.nextInt();
        if (sayi == 2) {
            oyuncu(2);
        } else {
            oyuncu(1);
        }
        return sayi;
    }

    public void oyuncu(int kisi) {

        if (kisi == 1) {
            oyuncuOzellik = false;
        } else {

            oyuncuOzellik = true;

        }
    }

    public void gosterTahta(){
        for (int i = 0; i < oyuntahtasi.length; i++) {
            for (int j = 0; j < oyuntahtasi[0].length; j++) {
                System.out.print("\t" + oyuntahtasi[i][j]);
                if (oyuntahtasi.length == 3) {
                    if (j == 0 || j == 1) {
                        System.out.print("|");
                    }
                }
                if (oyuntahtasi.length == 5) {
                    if (j == 0 || j == 1 || j == 2 || j == 3) {
                        System.out.print("|");
                    }
                }
                if (oyuntahtasi.length == 7) {
                    if (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5) {
                        System.out.print("|");
                    }
                }
            }
            if (oyuntahtasi.length == 3) {
                if (i == 0 || i == 1) {
                    System.out.print("\n---------------------------\n");
                }
            }
            if (oyuntahtasi.length == 5) {
                if (i == 0 || i == 1 || i == 2 || i == 3) {
                    System.out.print("\n------------------------------------------\n");
                }
            }
            if (oyuntahtasi.length == 7) {
                if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                    System.out.print("\n----------------------------------------------------------\n");
                }
            }
        }

        System.out.println("\n");
    }

    public boolean oyunhazir() {
        return oyunhazirla;
    }

    public void oyuncusor(char oyuncu) {
        Scanner keyboard = new Scanner(System.in);
        int i, j;
        do {
            System.out.printf("Oyuncu %s lütfen satır sayısını giriniz:", oyuncu);
            i = keyboard.nextInt();
            System.out.printf("Oyuncu %s lütfen sütun sayısını giriniz:", oyuncu);
            j = keyboard.nextInt();
        } while (yanlis(i, j));
        hamleyiYaz(oyuncu, i - 1, j - 1);
    }

    public void bilgisayarHamlesiUret(char oyuncu) {
        int i = 0, j = 0;
        do {
            if (oyuntahtasi.length == 3) {
                Random rnd = new Random();
                i = rnd.nextInt(4);
                j = rnd.nextInt(4);
            }
            if (oyuntahtasi.length == 5) {
                Random rnd = new Random();
                i = rnd.nextInt(6);
                j = rnd.nextInt(6);
            }
            if (oyuntahtasi.length == 7) {
                Random rnd = new Random();
                i = rnd.nextInt(8);
                j = rnd.nextInt(8);
            }
        } while (yanli(i, j));
        hamleyiYaz(oyuncu, i - 1, j - 1);
    }

    public boolean kazanan() {
        int k = 0;
        for (int i = 0; i < oyuntahtasi.length; i++) {
            if (oyuntahtasi.length == 3) {
                if (oyuntahtasi[i][0] == oyuntahtasi[i][1] && oyuntahtasi[i][1] == oyuntahtasi[i][2] && oyuntahtasi[i][0] != ' ') {
                    k = 1;
                    System.out.println("Kazandınız " + oyuntahtasi[i][0]);
                    oyunhazirla = false;
                }
            }
            if (oyuntahtasi.length == 5) {
                if (oyuntahtasi[i][0] == oyuntahtasi[i][1] && oyuntahtasi[i][1] == oyuntahtasi[i][2] && oyuntahtasi[i][2] == oyuntahtasi[i][3] && oyuntahtasi[i][3] == oyuntahtasi[i][4] && oyuntahtasi[i][0] != ' ') {
                    k = 1;
                    System.out.println("Kazandınız " + oyuntahtasi[i][0]);
                    oyunhazirla = false;
                }
            }
            if (oyuntahtasi.length == 7) {
                if (oyuntahtasi[i][0] == oyuntahtasi[i][1] && oyuntahtasi[i][1] == oyuntahtasi[i][2] && oyuntahtasi[i][2] == oyuntahtasi[i][3] && oyuntahtasi[i][3] == oyuntahtasi[i][4] && oyuntahtasi[i][4] == oyuntahtasi[i][5] && oyuntahtasi[i][5] == oyuntahtasi[i][6] && oyuntahtasi[i][0] != ' ') {
                    k = 1;
                    System.out.println("Kazandınız " + oyuntahtasi[i][0]);
                    oyunhazirla = false;
                }
            }
        }
        for (int j = 0; j < oyuntahtasi.length; j++) {
            if (oyuntahtasi.length == 3) {
                if (oyuntahtasi[0][j] == oyuntahtasi[1][j] && oyuntahtasi[1][j] == oyuntahtasi[2][j] && oyuntahtasi[0][j] != ' ') {
                    k = 1;
                    System.out.println("Kazandınız " + oyuntahtasi[0][j]);
                    oyunhazirla = false;
                }
            }
            if (oyuntahtasi.length == 5) {
                if (oyuntahtasi[0][j] == oyuntahtasi[1][j] && oyuntahtasi[1][j] == oyuntahtasi[2][j] && oyuntahtasi[2][j] == oyuntahtasi[3][j] && oyuntahtasi[3][j] == oyuntahtasi[4][j] && oyuntahtasi[0][j] != ' ') {
                    k = 1;
                    System.out.println("Kazandınız " + oyuntahtasi[0][j]);
                    oyunhazirla = false;
                }
            }
            if (oyuntahtasi.length == 7) {
                if (oyuntahtasi[0][j] == oyuntahtasi[1][j] && oyuntahtasi[1][j] == oyuntahtasi[2][j] && oyuntahtasi[2][j] == oyuntahtasi[3][j] && oyuntahtasi[3][j] == oyuntahtasi[4][j] && oyuntahtasi[4][j] == oyuntahtasi[5][j] && oyuntahtasi[5][j] == oyuntahtasi[6][j] && oyuntahtasi[0][j] != ' ') {
                    k = 1;
                    System.out.println("Kazandınız " + oyuntahtasi[0][j]);
                    oyunhazirla = false;
                }
            }
        }
        if (oyuntahtasi.length == 3) {
            if (oyuntahtasi[0][0] == oyuntahtasi[1][1] && oyuntahtasi[1][1] == oyuntahtasi[2][2] && oyuntahtasi[0][0] != ' ') {
                k = 1;
                System.out.println("Kazandınız " + oyuntahtasi[0][0]);
                oyunhazirla = false;
            }
            if (oyuntahtasi[0][2] == oyuntahtasi[1][1] && oyuntahtasi[1][1] == oyuntahtasi[2][0] && oyuntahtasi[0][2] != ' ') {
                k = 1;
                System.out.println("Kazandınız " + oyuntahtasi[0][2]);
                oyunhazirla = false;
            }
        }
        if (oyuntahtasi.length == 5) {
            if (oyuntahtasi[0][0] == oyuntahtasi[1][1] && oyuntahtasi[1][1] == oyuntahtasi[2][2] && oyuntahtasi[2][2] == oyuntahtasi[3][3] && oyuntahtasi[3][3] == oyuntahtasi[4][4] && oyuntahtasi[0][0] != ' ') {
                k = 1;
                System.out.println("Kazandınız " + oyuntahtasi[0][0]);
                oyunhazirla = false;
            }
            if (oyuntahtasi[0][4] == oyuntahtasi[1][3] && oyuntahtasi[1][3] == oyuntahtasi[2][2] && oyuntahtasi[2][2] == oyuntahtasi[3][1] && oyuntahtasi[3][1] == oyuntahtasi[4][0] && oyuntahtasi[0][4] != ' ') {
                k = 1;
                System.out.println("Kazandınız " + oyuntahtasi[0][4]);
                oyunhazirla = false;
            }
        }
        if (oyuntahtasi.length == 7) {
            if (oyuntahtasi[0][0] == oyuntahtasi[1][1] && oyuntahtasi[1][1] == oyuntahtasi[2][2] && oyuntahtasi[2][2] == oyuntahtasi[3][3] && oyuntahtasi[3][3] == oyuntahtasi[4][4] && oyuntahtasi[4][4] == oyuntahtasi[5][5] && oyuntahtasi[5][5] == oyuntahtasi[6][6] && oyuntahtasi[0][0] != ' ') {
                k = 1;
                System.out.println("Kazandınız " + oyuntahtasi[0][0]);
                oyunhazirla = false;
            }
            if (oyuntahtasi[0][6] == oyuntahtasi[1][5] && oyuntahtasi[1][5] == oyuntahtasi[2][4] && oyuntahtasi[2][4] == oyuntahtasi[3][3] && oyuntahtasi[3][3] == oyuntahtasi[4][2] && oyuntahtasi[4][2] == oyuntahtasi[5][1] && oyuntahtasi[5][1] == oyuntahtasi[6][0] && oyuntahtasi[0][6] != ' ') {
                k = 1;
                System.out.println("Kazandınız " + oyuntahtasi[0][6]);
                oyunhazirla = false;
            }
        }
        beraberlikKontrol(k);
        return false;

    }

    public boolean beraberlikKontrol(int k) {
        int sayac = 0;
        for (int i = 0; i < oyuntahtasi.length; i++) {
            for (int j = 0; j < oyuntahtasi.length; j++) {
                if (k != 1) {
                    if (oyuntahtasi[i][j] != ' ') {
                        sayac++;
                    }
                    if (oyuntahtasi.length == 3 && sayac == 9) {
                        System.out.println("BERABERE ");
                        oyunhazirla = false;
                    }
                    if (oyuntahtasi.length == 5 && sayac == 25) {
                        System.out.println("BERABERE ");
                        oyunhazirla = false;
                    }
                    if (oyuntahtasi.length == 7 && sayac == 49) {
                        System.out.println("BERABERE ");
                        oyunhazirla = false;
                    }
                }
            }
        }
        return false;
    }

    public boolean yanli(int i, int j) {
        if (i > 7 || i < 1 || j > 7 || j < 1 || !bosm(i, j)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean yanlis(int i, int j) {
        if (i > 7 || i < 1 || j > 7 || j < 1 || !bosmu(i, j)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean bosm(int i, int j) {
        if (oyuntahtasi[i - 1][j - 1] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public boolean bosmu(int i, int j) {
        if (oyuntahtasi[i - 1][j - 1] == ' ') {
            return true;
        } else {
            System.out.println("Girdiğiniz koordinatların yeri boş değil.");
            return false;
        }
    }

    public boolean hamleyiYaz(char oyuncu, int i, int j) {
        if (i >= 0 && i <= 6 && j >= 0 && j <= 6) {

            if (oyuntahtasi[i][j] != ' ') {
                return false;
            } else {
                oyuntahtasi[i][j] = oyuncu;
                return true;
            }
        } else {
            return false;
        }
    }

}
