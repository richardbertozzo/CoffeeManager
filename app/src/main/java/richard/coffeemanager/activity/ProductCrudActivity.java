package richard.coffeemanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.text.ParseException;

import richard.coffeemanager.R;
import richard.coffeemanager.controller.ProductController;
import richard.coffeemanager.crudHelper.ProductHelper;
import richard.coffeemanager.model.Product;

public class ProductCrudActivity extends AppCompatActivity {

    private ProductHelper productHelper;
    private ProductController productController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_crud);

        productHelper = new ProductHelper(this);
        productController = new ProductController(this);

        this.setUpToolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_home:
                finish();
                Intent intent = new Intent(ProductCrudActivity.this, CoffeeManagerActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_save:
                this.saveProduct();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveProduct() {
        try {
            Product product = productHelper.makeProduct();
            productController.insert(product);
            Toast.makeText(ProductCrudActivity.this, "Produto: " + product.getName() + " salvo!", Toast.LENGTH_SHORT).show();
            finish();
        } catch (ParseException e) {
            System.out.print("Error of parser: " + e);
        }
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarPrdocutCrud);
        toolbar.setTitle(getResources().getString(R.string.title_crud_product));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();
    }
}
