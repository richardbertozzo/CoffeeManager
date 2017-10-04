package richard.coffeemanager.controller;

import android.content.Context;

import java.util.List;

import richard.coffeemanager.dao.GenericDAO;
import richard.coffeemanager.model.Supplier;

public class SupplierController {

    private GenericDAO genericDAO;

    public SupplierController(Context context) {
        this.genericDAO = new GenericDAO(context);
    }

    public List<Supplier> list() {
        return null;
    }

    public void delete(Integer id) {

    }
}
