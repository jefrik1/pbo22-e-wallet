package entity;

import java.util.Date;

public class AdminEntity extends BiodataEntity{
    String noTelp,nama;
    Date tglLahir;

    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public Date getTglLahir() {
        return tglLahir;
    }
    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }
    public AdminEntity(String username, String password, String noTelp, String nama, Date tglLahir) {
        super(username, password);
        this.nama = nama;
        this.noTelp = noTelp;
        this.tglLahir = tglLahir;
    }
}

