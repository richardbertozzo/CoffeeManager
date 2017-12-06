package richard.coffeemanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import richard.coffeemanager.constants.Constants;
import richard.coffeemanager.model.Product;

public class ProductDAO extends GenericDAO {

    public ProductDAO(Context context) {
        super(context);
    }

    public void insert(Product product) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(Constants.Dao.COLUMN_NAME, product.getName());
        data.put(Constants.Dao.COLUMN_COST_PRICE, product.getCostPrice());
        data.put(Constants.Dao.COLUMN_SALE_PRICE, product.getSalePrice());
        data.put(Constants.Dao.COLUMN_AMOUNT, product.getAmount());
        data.put(Constants.Dao.COLUMN_IS_PACK, product.getIsPack());
        db.insert(Constants.Dao.TABLE_PRODUCT, null, data);
        db.close();
    }

    public List<Product> list() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM " + Constants.Dao.TABLE_PRODUCT + ";";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Product product = new Product();
            product.setId(cursor.getInt(cursor.getColumnIndex(Constants.Dao.COLUMN_ID)));
            product.setName(cursor.getString(cursor.getColumnIndex(Constants.Dao.COLUMN_NAME)));
            product.setCostPrice(cursor.getDouble(cursor.getColumnIndex(Constants.Dao.COLUMN_COST_PRICE)));
            product.setSalePrice(cursor.getDouble(cursor.getColumnIndex(Constants.Dao.COLUMN_SALE_PRICE)));
            productList.add(product);
        }
        db.close();
        return productList;
    }

    public void delete(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {id.toString()};
        db.delete(Constants.Dao.TABLE_PRODUCT, Constants.Dao.COLUMN_ID + " = ?", params);
    }
}
