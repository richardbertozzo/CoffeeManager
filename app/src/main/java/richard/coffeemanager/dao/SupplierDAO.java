package richard.coffeemanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import richard.coffeemanager.constants.Constants;
import richard.coffeemanager.model.Supplier;

public class SupplierDAO extends GenericDAO {

    public SupplierDAO(Context context) {
        super(context);
    }

    public long insert(Supplier supplier) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(Constants.Dao.COLUMN_NAME, supplier.getName());
        data.put(Constants.Dao.COLUMN_EMAIL, supplier.getEmail());
        long idSupplier = db.insert(Constants.Dao.TABLE_SUPPLIER, null, data);
        db.close();
        return idSupplier;
    }

    public List<Supplier> list() {
        List<Supplier> supplierList = new ArrayList<>();
        String sql = Constants.Sql.COMANDO_SELECT + Constants.Dao.TABLE_SUPPLIER + Constants.Geral.DOT_COM;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Supplier supplier = new Supplier();
            supplier.setId(cursor.getInt(cursor.getColumnIndex(Constants.Dao.COLUMN_ID)));
            supplier.setName(cursor.getString(cursor.getColumnIndex(Constants.Dao.COLUMN_NAME)));
            supplier.setEmail(cursor.getString(cursor.getColumnIndex(Constants.Dao.COLUMN_EMAIL)));
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
