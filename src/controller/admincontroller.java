package controller;

import entity.AdminEntity;
import entity.UserEntity;

import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class admincontroller implements ControllerInterface{
        int indexLogin = 0;
        public admincontroller() {
        }

        public void dataAdmin() {
            String usernameAdmin[] = {"01", "02"};
            String passwordAdmin[] = {"01", "02"};
            String namaAdmin[] = {"Saad", "Safir"};
            String noTelpAdmin[] = {"12345", "54321"};
            String tanggalLahirAdmin[] = {"04/05/2000", "01/12/2000"};
            for(int i = 0; i < usernameAdmin.length; i++) {
                AllObjekModel.admn.insertAdmin(new AdminEntity(usernameAdmin[i], passwordAdmin[i], namaAdmin[i],
                        noTelpAdmin[i], new Date(tanggalLahirAdmin[i])));
            }
        }
        public DefaultTableModel viewUser() {
            DefaultTableModel use = new DefaultTableModel();
            Object[] kolom = new Object[]{"No", "Username", "Nama", "Alamat", "Saldo","Tgl Lahir","No Telepon"};
            use.setColumnIdentifiers(kolom);
            int size = AllObjekModel.user.dataUser().size();

            for(int i = 0; i < size; ++i) {
                Object[] data = new Object[]{i + 1, ((UserEntity)AllObjekModel.user.dataUser().get(i)).getUsername(), ((UserEntity)AllObjekModel.user.dataUser().get(i)).getNama(), ((UserEntity)AllObjekModel.user.dataUser().get(i)).getAlamat()
                ,((UserEntity)AllObjekModel.user.dataUser().get(i)).getSaldo(),((UserEntity)AllObjekModel.user.dataUser().get(i)).getTglLahir(),((UserEntity)AllObjekModel.user.dataUser().get(i)).getNoTelp()};
                use.addRow(data);
            }
            return use;
        }
        public void viewAdmin(){
            AllObjekModel.admn.view();
        }
        @Override
        public void login(String username, String password) {
            indexLogin = AllObjekModel.admn.cekData(username, password);
        }
        public AdminEntity adminEntity() {
            return AllObjekModel.admn.showDataAdmin(indexLogin);
        }
    }

