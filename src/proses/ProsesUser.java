package proses;
import entity.*;
import view.AllObjectController;

import java.text.SimpleDateFormat;
import java.util.*;

public class ProsesUser implements Interface{
    static ArrayList<UserEntity> data = new ArrayList<>();
    private ArrayList<EntityTransaksi> riwayat;

    UserEntity user;
    String nama,username,noTelp, password, alamat;
    Date tgllahir;

    public ProsesUser() {
        user = new UserEntity(nama, tgllahir, alamat, noTelp, username, password);
        riwayat = new ArrayList<EntityTransaksi>();
    }

    public void insert(UserEntity User) {
        data.add(User);
    }
    public int cekData(String username, String password) {
        int loop = 0;
        for (UserEntity userEntity : data) {
            if (userEntity.getUsername().equals(username) && userEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    public void CekSaldo(){
        for (int i = 0; i < data.size(); i++) {
            System.out.println("Pemasukan : " + data.get(i).getNominal());
            System.out.println("Pengeluaran : " + data.get(i).getPulsa());
            System.out.println("Saldo Akun Anda Saat Ini : " + data.get(i).getSaldo());
        }
    }
    public void Tp(int nominal,String username, String password ){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUsername().equals(username)) {
                if (data.get(i).getPassword().equals(password)) {
                if  (nominal < 10000){
                    System.out.println("Minimal Top Up Rp.10000");
                }else{
                    data.get(i).setSaldo(data.get(i).getSaldo() + nominal);
                    data.get(i).setNominal(nominal);
                    riwayat.add(new EntityTransaksi(new Date(), "Top Up", data.get(i).getNominal()));
                    System.out.println("Top Up Rp." + data.get(i).getNominal() + " berhasil.");
                }
                }
            }
        }
    }
    public void pmb(int nominal,String username, String password){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUsername().equals(username)&&data.get(i).getPassword().equals(password)){
                if (data.get(i).getSaldo() < nominal) {
                    System.out.println("Saldo tidak cukup.");
                } else {
                    data.get(i).setSaldo(data.get(i).getSaldo() - nominal);
                    data.get(i).setPulsa(nominal);
                    riwayat.add(new EntityTransaksi(new Date(), "Pembelian Pulsa", data.get(i).getPulsa()));
                    System.out.println("Pembelian Pulsa Rp." + data.get(i).getPulsa() + " berhasil.");
                }
            }
        }
    }
    public ArrayList<EntityTransaksi> riwayat() {
        return this.riwayat;
    }
    public void tampilkanRiwayat(ArrayList<EntityTransaksi> riwayat) {
        System.out.println("========== RIWAYAT TRANSAKSI ==========");
        for (int j = 0; j < riwayat.size(); j++) {
            System.out.println((j + 1) + ". " + riwayat.get(j).getTanggalWaktu() + " | " + riwayat.get(j).getJenisTransaksi() + " | Rp." + riwayat.get(j).getNominal());
        }
        System.out.println("=======================================");
    }
    public void lihatriwayat(){
        tampilkanRiwayat(riwayat);
    }
    public UserEntity getUserEntityArrayList(int index) {
        return data.get(index);
    }
    public void nmbaru(String namaBaru,String username){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUsername().equals(username)) {
                data.get(i).setNama(namaBaru);
            }
        }
    }
    public void alamat(String alamatBaru,String username){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUsername().equals(username)) {
                data.get(i).setAlamat(alamatBaru);
            }
        }
    }
    public void noTelp(String noTelpBaru,String username){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUsername().equals(username)) {
                data.get(i).setNoTelp(noTelpBaru);
            }
        }
    }
    public void username(String usernameBaru,String username){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUsername().equals(username)) {
                data.get(i).setUsername(usernameBaru);
            }
        }
    }
    public void password(String passwordBaru,String username){
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUsername().equals(username)) {
                data.get(i).setPassword(passwordBaru);
            }
        }
    }
    public ArrayList<UserEntity> dataUser() {
        return this.data;
    }
    @Override
    public void view() {
        for (UserEntity datum : data) {
            System.out.println("====================================");
            System.out.println("nama        : " + datum.getNama());
            System.out.println("Tanggal Lahir        : " + new SimpleDateFormat("dd-MM-yyyy").format(datum.getTglLahir()));
            System.out.println("alamat      : " + datum.getAlamat());
            System.out.println("No Telpon   : " + datum.getNoTelp());
            System.out.println("Saldo       : " + datum.getSaldo());
            System.out.println("Username    : " + datum.getUsername());
            System.out.println("Password    : " + datum.getPassword());
            System.out.println("====================================");
        }
    }
    public void hapus(String username) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getUsername().equals(username)) {
                data.remove(i);
            }
        }
    }
}