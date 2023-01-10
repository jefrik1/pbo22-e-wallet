package controller;

import entity.*;

import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class UserController implements ControllerInterface{
        int indexLogin = 0;
        public UserController() {
        }
        @Override
        public void login(String username, String password) {
            indexLogin = AllObjekModel.user.cekData(username, password);
        }
        public void topup(int nominal){
            AllObjekModel.user.Tp(nominal, userEntity().getUsername(), userEntity().getPassword());
        }
        public void pmbl(int nominal){
            AllObjekModel.user.pmb(nominal, userEntity().getUsername(), userEntity().getPassword());
        }
        public void editNama(String namaBaru,String username){
            indexLogin = AllObjekModel.user.cekData(username,null);
            AllObjekModel.user.nmbaru(namaBaru, username);
        }
        public void editAlamat(String alamatBaru,String username){
            indexLogin = AllObjekModel.user.cekData(username,null);
            AllObjekModel.user.alamat(alamatBaru, username);
        }
        public void editNoTelp(String noTelpBaru,String username){
            indexLogin = AllObjekModel.user.cekData(username,null);
            AllObjekModel.user.noTelp(noTelpBaru, username);
        }
        public void editPassword(String passwordBaru,String username){
            indexLogin = AllObjekModel.user.cekData(username,null);
            AllObjekModel.user.password(passwordBaru, username);
        }
        public void editUsername(String usernameBaru,String username){
            indexLogin = AllObjekModel.user.cekData(username,null);
            AllObjekModel.user.username(usernameBaru, username);
        }
        public void Del(String username){
            indexLogin = AllObjekModel.user.cekData(username,null);
            AllObjekModel.user.hapus(username);
        }
        public DefaultTableModel History(){
            DefaultTableModel use = new DefaultTableModel();
            Object[] kolom = new Object[]{"No", "Tgl Transaksi", "Jenis Transaksi","Nominal"};
            use.setColumnIdentifiers(kolom);
            int size = AllObjekModel.user.riwayat().size();

            for(int i = 0; i < size; ++i) {
                Object[] data = new Object[]{i + 1, ((EntityTransaksi)AllObjekModel.user.riwayat().get(i)).getTanggalWaktu(), ((EntityTransaksi)AllObjekModel.user.riwayat().get(i)).getJenisTransaksi(), ((EntityTransaksi)AllObjekModel.user.riwayat().get(i)).getNominal()};
                use.addRow(data);
            }
            return use;
        }
        public void insert(String nama, Date tgllahir, String alamat, String noTelp , String username, String password) {
            AllObjekModel.user.insert(new UserEntity(nama, tgllahir, alamat,noTelp, username, password));
        }
        public UserEntity userEntity() {
            return AllObjekModel.user.getUserEntityArrayList(indexLogin);
        }
        public DefaultTableModel saldo(){
            DefaultTableModel saldo = new DefaultTableModel();
            Object[] kolom = new Object[]{"Pengeluaran", "Pemasukan","Jumlah Saldo"};
            saldo.setColumnIdentifiers(kolom);
            int size = AllObjekModel.user.dataUser().size();

            for(int i = 0; i < size; ++i) {
                Object[] data = new Object[]{((UserEntity)AllObjekModel.user.dataUser().get(i)).getPulsa(), ((UserEntity)AllObjekModel.user.dataUser().get(i)).getNominal(), ((UserEntity)AllObjekModel.user.dataUser().get(i)).getSaldo()};
                saldo.addRow(data);
            }
            return saldo;
        }
    }
