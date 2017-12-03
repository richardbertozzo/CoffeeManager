package richard.coffeemanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import richard.coffeemanager.constants.Constants;
import richard.coffeemanager.model.Phone;

public class PhoneDAO extends GenericDAO {

    public PhoneDAO(Context context) {
        super(context);
    }

    public void insert(Phone phone) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(Constants.Dao.COLUMN_DDD, phone.getDdd());
        data.put(Constants.Dao.COLUMN_PHONE, phone.getPhone());
        data.put(Constants.Dao.COLUMN_ID_SUPPLIER, phone.getIdSupplier());
        db.insert(Constants.Dao.TABLE_PHONE, null, data);
        db.close();
    }

    public List<Phone> list(Integer idSupplier) {
        List<Phone> phones = new ArrayList<>();
        String sql = Constants.Sql.COMANDO_SELECT + Constants.Dao.TABLE_PHONE +
                Constants.Sql.WHERE + Constants.Dao.COLUMN_ID_SUPPLIER + Constants.Geral.EQUAL + idSupplier + Constants.Geral.DOT_COM;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            Phone phone = new Phone();
            phone.setId(cursor.getInt(cursor.getColumnIndex(Constants.Dao.COLUMN_ID_PHONE)));
            phone.setDdd(cursor.getInt(cursor.getColumnIndex(Constants.Dao.COLUMN_DDD)));
            phone.setPhone(cursor.getInt(cursor.getColumnIndex(Constants.Dao.COLUMN_PHONE)));
            phone.setIdSupplier(idSupplier);
            phones.add(phone);
        }

        db.close();
        return phones;
    }

    public void delete(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = {id.toString()};
        db.delete(Constants.Dao.TABLE_PHONE, Constants.Dao.COLUMN_ID + " = ?", params);
    }
}
