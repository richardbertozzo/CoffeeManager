package richard.coffeemanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import richard.coffeemanager.R;
import richard.coffeemanager.controller.SupplierController;
import richard.coffeemanager.model.Supplier;

public class SupplierAdpater extends RecyclerView.Adapter {

    private List<Supplier> suppliers;
    private Context context;
    private SupplierController supplierController;

    public SupplierAdpater(List<Supplier> suppliers, Context context) {
        this.suppliers = suppliers;
        this.context = context;
        this.supplierController = new SupplierController(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_supplier, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        SupplierViewHolder supplierViewHolder = (SupplierViewHolder) holder;
        Supplier supplier = suppliers.get(position);
        supplierViewHolder.name.setText(supplier.getName());
        supplierViewHolder.buttonDelete.setOnClickListener(view -> deleteItem(position, supplier.getId()));
        supplierViewHolder.buttonEdit.setOnClickListener(view -> updateItem(position));
    }

    private void updateItem(int position) {

    }

    private void deleteItem(int position, Integer id) {
        supplierController.delete(id);
        suppliers.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, suppliers.size());
    }

    @Override
    public int getItemCount() {
        return suppliers.size();
    }
}
