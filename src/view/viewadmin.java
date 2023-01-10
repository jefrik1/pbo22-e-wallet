package view;

import controller.UserController;
import controller.admincontroller;
import java.util.Scanner;

public class viewadmin {
    admincontroller admin = new admincontroller();
    UserController user = new UserController();
    Scanner in = new Scanner(System.in);
    public void loginAdmin() {
        System.out.println("Username : ");
        String username = in.next();
        System.out.println("Password : ");
        String password = in.next();
        try {
            admin.login(username, password);
            System.out.println("Selamat Datang " + admin.adminEntity().getUsername());
            menuAdm();
        } catch (Exception e) {
            System.out.println("Username atau Password Anda Salah !!!");
        }
    }
    public void menuAdm() {
        int pil;
        do {
            System.out.println("1. Daftar User");
            System.out.println("2. Update Data User");
            System.out.println("3. Hapus User");
            System.out.println("0. Keluar\n");
            System.out.print("Masukkan pilihan : ");
            pil = in.nextInt();
            switch (pil) {
                case 1 -> admin.viewUser();
                case 2 -> update();
                case 3 -> Hapus();
            }
        } while (pil != 0);
    }
    public void Hapus(){
        System.out.println("Masukkan Username : ");
        String username = in.next();
        user.Del(username);
    }
    public void update() {
        int pilih;
        System.out.println("Masukkan Username Yang Ingin Diubah : ");
        String username = in.next();
        do {
            System.out.println("Masukkan Pilihan Untuk Merubah Data");
            System.out.println("1. Nama");
            System.out.println("2. Alamat");
            System.out.println("3. No Telpon");
            System.out.println("4. Username");
            System.out.println("5. Password");
            System.out.println("0. Exit");
            pilih = in.nextInt();
            switch (pilih) {
                case 1 -> {
                    System.out.println("Masukkan Nama Baru : ");
                    String namaBaru = in.next();
                    user.editNama(namaBaru,username);
                }
                case 2 -> {
                    System.out.println("Masukkan Alamat Baru : ");
                    String alamatBaru = in.next();
                    user.editAlamat(alamatBaru,username);
                }
                case 3 -> {
                    System.out.println("Masukkan No Telpon Baru : ");
                    String notelpBaru = in.next();
                    user.editNoTelp(notelpBaru,username);
                }
                case 4 -> {
                    System.out.println("Masukkan Username Baru : ");
                    String usernameBaru = in.next();
                    user.editUsername(usernameBaru,username);
                }
                case 5 -> {
                    System.out.println("Masukkan Password Baru : ");
                    String passwordBaru = in.next();
                    user.editPassword(passwordBaru,username);
                }
            }
        } while (pilih != 0);
    }
}
