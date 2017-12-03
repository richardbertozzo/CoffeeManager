package richard.coffeemanager.controller;

import android.content.Context;

import java.util.List;

import richard.coffeemanager.dao.GenericDAO;
import richard.coffeemanager.dao.SupplierDAO;
import richard.coffeemanager.model.Phone;
import richard.coffeemanager.model.Supplier;

public class SupplierController {

    private SupplierDAO supplierDAO;
    private PhoneController phoneController;

    public SupplierController(Context context) {
        this.supplierDAO = new SupplierDAO(context);
        this.phoneController = new PhoneController(context);
    }

    public List<Supplier> list() {
        List<Supplier> suppliers = supplierDAO.list();
        suppliers.forEach(supplier -> {
            List<Phone> phones = phoneController.list(supplier.getId());
            supplier.setPhones(phones);
        });
        return suppliers;
    }

    public void delete(Integer id) {
        this.supplierDAO.delete(id);
    }

    public int insert(Supplier supplier) {
        int insert = (int) this.supplierDAO.insert(supplier);
        this.phoneController.insert(supplier.getPhones(), insert);
        return insert;
    }
}
