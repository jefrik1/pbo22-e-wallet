package proses;

import entity.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProsesAdmin implements Interface{
    private ArrayList<AdminEntity> dataadmn;
    public ProsesAdmin() {
        dataadmn = new ArrayList<AdminEntity>();
    }
    public void insertAdmin(AdminEntity admin) {
        dataadmn.add(admin);
    }
    @Override
    public void view() {
        for (AdminEntity admin : dataadmn) {
            System.out.println(admin.getUsername());
            System.out.println(admin.getNama());
            System.out.println(admin.getPassword());
            System.out.println(admin.getNoTelp());
            System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(admin.getTglLahir()));
        }
    }
    public AdminEntity showDataAdmin(int index) {
        return dataadmn.get(index);
    }
    public int cekData(String username, String password) {
    int loop = 0;
        for (AdminEntity admin : dataadmn) {
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            break;
        } else {
            loop++;
        }
        }
        return loop;
    }
}