package richard.coffeemanager.controller;

import android.content.Context;

import java.util.List;

import richard.coffeemanager.dao.GenericDAO;
import richard.coffeemanager.model.Product;

public class ProductController {

    private GenericDAO genericDAO;

    public ProductController(Context context) {
        this.genericDAO = new GenericDAO(context);
    }

    public void insert(Product product) {
        if (product != null) {
            genericDAO.insert(product);
        }
    }

    public List<Product> list() {
        return genericDAO.list();
    }


    public void update(Product o) {

    }

    public void delete(Integer id) {
        genericDAO.delete(id);
    }
}
