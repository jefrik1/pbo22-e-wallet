package entity;


import java.util.Date;

public class UserEntity{
    public String nama;
    private Date tgllahir;
    String username,password;
    private String alamat,noTelp;
    int umur,saldo,nominal,pulsa;
    public UserEntity(String nama, Date tgllahir,String alamat, String noTelp , String username, String password) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.tgllahir = tgllahir;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }
    public Date getTglLahir() {
        return tgllahir;
    }
    public void setNoTelp(String  noTelp) {
        this.noTelp = noTelp;
    }

    public int getSaldo() {
        return saldo;
    }

    public int setSaldo(int saldo) {
        this.saldo = saldo;
        return 0;
    }
    public int getNominal() {
        return nominal;
    }

    public int getPulsa() {
        return pulsa;
    }

    public void setPulsa(int pulsa) {
        this.pulsa = pulsa;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
