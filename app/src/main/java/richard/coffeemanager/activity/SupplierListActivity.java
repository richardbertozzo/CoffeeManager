package richard.coffeemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.List;

import richard.coffeemanager.R;
import richard.coffeemanager.adapter.SupplierAdpater;
import richard.coffeemanager.controller.SupplierController;
import richard.coffeemanager.model.Supplier;

public class SupplierListActivity extends AppCompatActivity {

    private List<Supplier> suppliers;
    private SupplierController supplierController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton buttonNew = (FloatingActionButton) findViewById(R.id.buttonNew);
        buttonNew.setOnClickListener(v -> {
            Intent intent = new Intent(SupplierListActivity.this, SupplierCrudActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getAndPutSuppliers(){
        this.supplierController = new SupplierController(this);
        suppliers = supplierController.list();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setAdapter(new SupplierAdpater(suppliers, this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);
    }
}
