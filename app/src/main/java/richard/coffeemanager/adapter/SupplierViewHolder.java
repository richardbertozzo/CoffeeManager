package richard.coffeemanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.pinball83.maskededittext.MaskedEditText;

import richard.coffeemanager.R;

class SupplierViewHolder extends RecyclerView.ViewHolder{
    final TextView name;
    final MaskedEditText phone;

    final ImageButton buttonDelete;
    final ImageButton buttonEdit;

    SupplierViewHolder(View view) {
        super(view);
        name = (TextView) view.findViewById(R.id.supplierName);
        phone = (MaskedEditText) view.findViewById(R.id.supplierPhone);
        buttonDelete = (ImageButton) view.findViewById(R.id.buttonDelete);
        buttonEdit = (ImageButton) view.findViewById(R.id.buttonEdit);
    }

}

