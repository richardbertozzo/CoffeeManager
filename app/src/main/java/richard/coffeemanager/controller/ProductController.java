package richard.coffeemanager.controller;

import android.content.Context;

import java.util.List;
import java.util.Objects;

import richard.coffeemanager.dao.GenericDAO;
import richard.coffeemanager.dao.ProductDAO;
import richard.coffeemanager.model.Product;

public class ProductController {

    private ProductDAO productDAO;

    public ProductController(Context context) {
        this.productDAO = new ProductDAO(context);
    }

    public void insert(Product product) {
        if (Objects.nonNull(product)) {
            productDAO.insert(product);
        }
    }

    public List<Product> list() {
        return productDAO.list();
    }

    public void update(Product o) {

    }

    public void delete(Integer id) {
        productDAO.delete(id);
    }
}
