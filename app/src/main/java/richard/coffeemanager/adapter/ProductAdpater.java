package richard.coffeemanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Locale;

import richard.coffeemanager.R;
import richard.coffeemanager.controller.ProductController;
import richard.coffeemanager.model.Product;

public class ProductAdpater extends RecyclerView.Adapter {

    private List<Product> products;
    private Context context;
    private ProductController productController;

    public ProductAdpater(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
        this.productController = new ProductController(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ProductViewHolder productViewHolder = (ProductViewHolder) holder;
        Product product = products.get(position);
        productViewHolder.name.setText(product.getName());
        String costPrice = String.format("%.2f", product.getCostPrice());
        productViewHolder.costPrice.setText("R$ " + costPrice);
        String salePrice = String.format("%.2f", product.getSalePrice());
        productViewHolder.salePrice.setText("R$ " + salePrice);
        productViewHolder.buttonDelete.setOnClickListener(view -> deleteItem(position, product.getId()));
        productViewHolder.buttonEdit.setOnClickListener(view -> updateItem(position));
    }

    private void updateItem(int position) {

    }

    private void deleteItem(int position, Integer id) {
        productController.delete(id);
        products.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, products.size());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
