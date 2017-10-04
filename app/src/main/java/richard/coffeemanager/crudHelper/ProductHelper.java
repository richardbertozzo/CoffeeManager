package richard.coffeemanager.crudHelper;

import android.widget.EditText;

import richard.coffeemanager.R;
import richard.coffeemanager.activity.ProductCrudActivity;
import richard.coffeemanager.model.Product;

public class ProductHelper {

    private EditText name;
    private EditText costPrice;
    private EditText salePrice;

    public ProductHelper(ProductCrudActivity productCrudActivity) {
        name = (EditText) productCrudActivity.findViewById(R.id.productName);
        costPrice = (EditText) productCrudActivity.findViewById(R.id.productCostPrice);
        salePrice = (EditText) productCrudActivity.findViewById(R.id.productSalePrice);
    }

    public Product makeProduct(){
        Product product = new Product();
        product.setName(name.getText().toString());
        product.setCostPrice(Double.parseDouble(costPrice.getText().toString()));
        product.setSalePrice(Double.parseDouble(salePrice.getText().toString()));
        return product;
    }
}
