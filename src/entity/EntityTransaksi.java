package entity;

import java.util.Date;

public class EntityTransaksi{
    private Date tanggalWaktu;
    private String jenisTransaksi;
    int nominal;

    public EntityTransaksi(Date tanggalWaktu, String jenisTransaksi, int nominal) {
        this.tanggalWaktu = tanggalWaktu;
        this.jenisTransaksi = jenisTransaksi;
        this.nominal = nominal;
    }

    public Date getTanggalWaktu() {
        return tanggalWaktu;
    }
    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public int getNominal() {
        return nominal;
    }
}
