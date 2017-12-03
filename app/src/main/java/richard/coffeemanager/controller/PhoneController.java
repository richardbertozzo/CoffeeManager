package richard.coffeemanager.controller;

import android.content.Context;

import java.util.List;

import richard.coffeemanager.dao.PhoneDAO;
import richard.coffeemanager.model.Phone;

public class PhoneController {

    private PhoneDAO phoneDAO;

    public PhoneController(Context context) {
        this.phoneDAO = new PhoneDAO(context);
    }

    public void insert(List<Phone> phones, int idSupplier) {
        phones.forEach(phone -> {
            phone.setIdSupplier(idSupplier);
            phoneDAO.insert(phone);
        });
    }

    public List<Phone> list(Integer idSupplier) {
        return this.phoneDAO.list(idSupplier);
    }
}
