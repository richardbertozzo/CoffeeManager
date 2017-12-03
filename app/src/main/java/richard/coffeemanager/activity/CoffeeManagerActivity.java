package richard.coffeemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import richard.coffeemanager.R;

public class CoffeeManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_manager);

        String[] menus = listMenus();
        final ListView listMenu = findViewById(R.id.listMenus);
        ArrayAdapter<String> arrayAdapterListMenu = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menus);
        listMenu.setAdapter(arrayAdapterListMenu);
        listMenu.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent;
            if (position == 0) {
            } else if (position == 1) {
                intent = new Intent(CoffeeManagerActivity.this, ProductListActivity.class);
                startActivity(intent);
            } else if (position == 2) {
                intent = new Intent(CoffeeManagerActivity.this, SupplierListActivity.class);
                startActivity(intent);
            }
        });
    }

    private String[] listMenus() {
        return getResources().getStringArray(R.array.menus);
    }
}
