package view;

import controller.UserController;
import proses.ProsesUser;

import java.util.Date;
import java.util.Scanner;
import static view.AllObjectController.admin;

public class viewuser {
    UserController user = new UserController();
    ProsesUser use = new ProsesUser();
    viewadmin adm = new viewadmin();
    Scanner in = new Scanner(System.in);
    public void Reg(){
    admin.dataAdmin();
    int pil;
            do {
        Scanner inputan = new Scanner(System.in);
        System.out.println("1. Login Admin");
        System.out.println("2. Register User");
        System.out.println("3. Login User");
        System.out.println("0. Keluar");
        pil=inputan.nextInt();
        switch (pil) {
            case 1 -> adm.loginAdmin();
            case 2 -> user();
            case 3 -> login();
            case 4 -> admin.viewAdmin();
        }
    } while(pil!=0);
}
    public void user() {
        try {
            System.out.println("Input Nama : ");
            String nama = in.next();
            System.out.println("Input Alamat : ");
            String alamat = in.next();
            System.out.println("Input Tgl Lahir dd/mm/yyyy : ");
            Date tglLahir = new Date(in.next());
            System.out.println("Input No.Telp : ");
            String noTelp = in.next();
            System.out.print("Username = ");
            String username = in.next();
            System.out.print("Password = ");
            String password = in.next();
            user.insert(nama, tglLahir, alamat, noTelp, username, password);
            System.out.println("Registrasi Berhasil !!");
        } catch (Exception e) {
            System.out.println("Format Pengisian Salah");
        }
    }
    public void login() {
        System.out.println("Masukkan Username : ");
        String username = in.next();
        System.out.println("Masukkan Password : ");
        String password = in.next();
        try {
            user.login(username,password);
            System.out.println("Selamat Datang " + user.userEntity().getUsername());
            menuCus();
        } catch (Exception e) {
            System.out.println("Username atau Password Anda Salah !!!");
        }
    }
    public void Topup(){
        System.out.print("Masukkan Nominal : Rp.");
        int nominal = in.nextInt();
        user.topup(nominal);
    }
    public void Riwayat(){
        user.History();
    }
    public void Pembelian(int nominal){
        user.pmbl(nominal);
    }
    public void CekSaldo(){
        user.saldo();
    }
    public void Pulsa() {
        int pulsa;
        System.out.println("Pilih Jumlah Pulsa :");
        System.out.println("1. Rp.20.000");
        System.out.println("2. Rp.50.000");
        System.out.println("3. Rp.100.000");
        System.out.println("4. Rp.1.000.000");
        System.out.println("0. Keluar");
        System.out.print("Masukkan Pilihan : ");
        pulsa = in.nextInt();
        switch (pulsa) {
            case 1 -> Pembelian(20000);
            case 2 -> Pembelian(50000);
            case 3 -> Pembelian(100000);
            case 4 -> Pembelian(1000000);
            case 5 -> menuCus();
        }
    }
    public void menuCus() {
        int pil;
        do {
            System.out.println("1. Beli Pulsa");
            System.out.println("2. Top Up");
            System.out.println("3. Cek Saldo");
            System.out.println("4. Riwayat Transaksi");
            System.out.println("0. Keluar\n");
            System.out.print("Masukkan pilihan : ");
            pil=in.nextInt();
            switch (pil) {
                case 1 -> Pulsa();
                case 2 -> Topup();
                case 3 -> CekSaldo();
                case 4 -> use.lihatriwayat();
            }
        } while(pil!=0);
    }
}
