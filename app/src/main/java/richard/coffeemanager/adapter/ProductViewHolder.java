package richard.coffeemanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import richard.coffeemanager.R;

class ProductViewHolder extends RecyclerView.ViewHolder {

    final TextView name;
    final TextView costPrice;
    final TextView salePrice;
    final ImageButton buttonDelete;
    final ImageButton buttonEdit;

    ProductViewHolder(View view) {
        super(view);
        name = (TextView) view.findViewById(R.id.textProductName);
        costPrice = (TextView) view.findViewById(R.id.textProductCostPrice);
        salePrice = (TextView) view.findViewById(R.id.textProductSalePrice);
        buttonDelete = (ImageButton) view.findViewById(R.id.buttonDelete);
        buttonEdit = (ImageButton) view.findViewById(R.id.buttonEdit);
    }
}
