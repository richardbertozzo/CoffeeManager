package richard.coffeemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class CoffeeManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_manager);

        String[] menus = listMenus();
        final ListView listMenu = (ListView) findViewById(R.id.listMenus);
        ArrayAdapter<String> arrayAdapterListMenu = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menus);
        listMenu.setAdapter(arrayAdapterListMenu);
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                if (position == 0) {

                } else if (position == 1) {
                    intent = new Intent(CoffeeManagerActivity.this, ProductList.class);
                    startActivity(intent);
                } else if (position == 2) {

                }
            }
        });
    }

    private String[] listMenus() {
        return getResources().getStringArray(R.array.menus);
    }
}
