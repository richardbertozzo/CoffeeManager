package richard.coffeemanager.crudHelper;

import android.widget.EditText;
import android.widget.RadioButton;

import java.text.ParseException;

import faranjit.currency.edittext.CurrencyEditText;
import me.himanshusoni.quantityview.QuantityView;
import richard.coffeemanager.R;
import richard.coffeemanager.activity.ProductCrudActivity;
import richard.coffeemanager.model.Product;

public class ProductHelper {

    private EditText name;
    private CurrencyEditText costPrice;
    private CurrencyEditText salePrice;
    private QuantityView quantity;
    private RadioButton radioButtonIsPack;

    public ProductHelper(ProductCrudActivity productCrudActivity) {
        name = productCrudActivity.findViewById(R.id.productName);
        costPrice = productCrudActivity.findViewById(R.id.productCostPrice);
        salePrice = productCrudActivity.findViewById(R.id.productSalePrice);
        quantity = productCrudActivity.findViewById(R.id.productQuantity);
        radioButtonIsPack = productCrudActivity.findViewById(R.id.productRadioPack);
    }

    public Product makeProduct() throws ParseException {
        Product product = new Product();
        product.setName(name.getText().toString());
        product.setCostPrice(costPrice.getCurrencyDouble());
        product.setSalePrice(salePrice.getCurrencyDouble());
        product.setAmount(quantity.getQuantity());
        Integer isPack = 0;
        if (radioButtonIsPack.isChecked()) {
            isPack = 1;
        }
        product.setIsPack(isPack);

        return product;
    }
}
