package richard.coffeemanager.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

import richard.coffeemanager.R;
import richard.coffeemanager.controller.ProductController;
import richard.coffeemanager.crudHelper.ProductHelper;
import richard.coffeemanager.dao.GenericDAO;
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

        ActionBar actionBar = getSupportActionBar();
        if (Objects.nonNull(actionBar)) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        clickButtonSave();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    private void clickButtonSave() {
        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = productHelper.makeProduct();
                productController.insert(product);
                Toast.makeText(ProductCrudActivity.this, "Produto: " + product.getName() + " salvo!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.home:
                finish();
                Intent intent = new Intent(ProductCrudActivity.this, CoffeeManagerActivity.class);
                startActivity(intent);
                return true;
            case R.id.save:
                Product product = productHelper.makeProduct();
                productController.insert(product);
                Toast.makeText(ProductCrudActivity.this, "Produto: " + product.getName() + " salvo!", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
