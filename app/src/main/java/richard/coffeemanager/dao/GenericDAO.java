package richard.coffeemanager.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import richard.coffeemanager.constants.Constants;
import richard.coffeemanager.model.Product;

public class GenericDAO extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "coffemanager";
    private static final int VERSION = 1;

    public GenericDAO(Context context) {
        super(context, NOME_BANCO, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createSqlPhone());
        db.execSQL(createSqlProduct());
        db.execSQL(createSqlSupplier());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS product;";
        db.execSQL(sql);
        onCreate(db);
    }

    private String createSqlProduct() {
        return "CREATE TABLE " + Constants.Dao.TABLE_PRODUCT + " ( " +
                Constants.Dao.COLUMN_ID + " integer primary key autoincrement, " +
                Constants.Dao.COLUMN_NAME + " text not null, " +
                Constants.Dao.COLUMN_COST_PRICE + " real not null, " +
                Constants.Dao.COLUMN_SALE_PRICE + " real not null);";
    }

    private String createSqlSupplier() {
        return "CREATE TABLE " + Constants.Dao.TABLE_SUPPLIER + " ( " +
                Constants.Dao.COLUMN_ID + " integer primary key autoincrement, " +
                Constants.Dao.COLUMN_NAME + " text not null, " +
                Constants.Dao.COLUMN_EMAIL + " text);";
    }

    private String createSqlPhone() {
        return "CREATE TABLE " + Constants.Dao.TABLE_PHONE + " ( " +
                Constants.Dao.COLUMN_ID + " integer primary key autoincrement, " +
                Constants.Dao.COLUMN_DDD + " integer not null, " +
                Constants.Dao.COLUMN_PHONE + " integer not null, " +
                Constants.Dao.COLUMN_ID_SUPPLIER + " integer not null, " +
                "FOREIGN KEY (" + Constants.Dao.COLUMN_ID_SUPPLIER + ") REFERENCES " + Constants.Dao.TABLE_SUPPLIER + "(" + Constants.Dao.COLUMN_ID + "));";
    }
}
