package richard.coffeemanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import richard.coffeemanager.constants.Constants;
import richard.coffeemanager.model.Phone;
import richard.coffeemanager.model.Product;
import richard.coffeemanager.model.Supplier;

public class SupplierDAO extends GenericDAO {

    public SupplierDAO(Context context) {
        super(context);
    }

    public void insert(Supplier supplier) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(Constants.Dao.COLUMN_NAME, supplier.getName());
        data.put(Constants.Dao.COLUMN_EMAIL, supplier.getEmail());
        long idSupplier = db.insert(Constants.Dao.TABLE_SUPPLIER, null, data);
        supplier.getPhones().forEach(phone -> {
            ContentValues dataPhone = new ContentValues();
            dataPhone.put(Constants.Dao.COLUMN_DDD, phone.getDdd());
            dataPhone.put(Constants.Dao.COLUMN_PHONE, phone.getPhone());
            dataPhone.put(Constants.Dao.COLUMN_ID_SUPPLIER, idSupplier);
            db.insert(Constants.Dao.TABLE_PHONE, null, dataPhone);
        });
        db.close();
    }

    public List<Supplier> list() {
        List<Supplier> supplierList = new ArrayList<>();
        String sql = "SELECT * FROM " + Constants.Dao.TABLE_SUPPLIER + ";";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Supplier supplier = new Supplier();
            int idSupplier = cursor.getInt(cursor.getColumnIndex(Constants.Dao.COLUMN_ID));
            supplier.setId(idSupplier);
            supplier.setName(cursor.getString(cursor.getColumnIndex(Constants.Dao.COLUMN_NAME)));
            supplier.setEmail(cursor.getString(cursor.getColumnIndex(Constants.Dao.COLUMN_EMAIL)));

            String sqlPhone = "SELECT * FROM " + Constants.Dao.TABLE_PHONE + " Where " + Constants.Dao.COLUMN_ID_SUPPLIER + " = " + idSupplier + ";";
            Cursor cursorPhone = db.rawQuery(sqlPhone, null);
            ArrayList<Phone> phones = new ArrayList<>();
            while (cursorPhone.moveToNext()) {
                Phone phone = new Phone();
                phone.setId(cursorPhone.getInt(cursorPhone.getColumnIndex(Constants.Dao.COLUMN_ID)));
                phone.setDdd(cursorPhone.getInt(cursorPhone.getColumnIndex(Constants.Dao.COLUMN_DDD)));
                phone.setPhone(cursorPhone.getInt(cursorPhone.getColumnIndex(Constants.Dao.COLUMN_PHONE)));
            }
            supplier.setPhones(phones);
            supplierList.add(supplier);
        }
        db.close();
        return supplierList;
    }

    public void delete(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {id.toString()};
        db.delete(Constants.Dao.TABLE_SUPPLIER, Constants.Dao.COLUMN_ID + " = ?", params);
    }
}
