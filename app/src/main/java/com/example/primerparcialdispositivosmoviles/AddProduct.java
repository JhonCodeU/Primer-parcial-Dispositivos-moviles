package com.example.primerparcialdispositivosmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ib.custom.toast.CustomToastView;

import java.util.Iterator;

public class AddProduct extends AppCompatActivity implements View.OnClickListener {

    private EditText txtCode;
    private EditText txtName;
    private EditText txtValor;
    private EditText txtDescription;
    private Spinner spinnerProduct;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        btnAdd = findViewById(R.id.btnAdd);
        txtCode = findViewById(R.id.txtCodigo);
        txtName = findViewById(R.id.txtName);
        txtValor = findViewById(R.id.txtValor);
        txtDescription = findViewById(R.id.txtDescription);
        spinnerProduct = (Spinner)findViewById(R.id.spinnerProduct);

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAdd){
            int code = Integer.parseInt(txtCode.getText().toString());
            String name = txtName.getText().toString();
            double valor = Double.parseDouble(txtValor.getText().toString());
            String description = txtDescription.getText().toString();
            String category = spinnerProduct.getSelectedItem().toString();

            if(name.isEmpty()){
                CustomToastView.makeInfoToast(this,"Descripcion vacia",R.layout.custom_toast).show();
            }

            if(description.isEmpty()){
                CustomToastView.makeInfoToast(this,"Descripcion vacia",R.layout.custom_toast).show();
            }

            if(category.isEmpty()){
                CustomToastView.makeInfoToast(this,"Categoria vacia",R.layout.custom_toast).show();
            }

            Product product = new Product(code, name, valor, true, description, category);

            ListProducts list = new ListProducts();
            list.setListProducts(product);

            Iterator itr = ListProducts.iterator();

            while(itr.hasNext()){
                Product st= (Product)itr.next();
                System.out.println(st.getNombre()+" "+st.getDescripcion()+" "+st.getValor());
            }

            Intent intent = new Intent(this, ShowProduct.class);
            intent.putExtra("listProducts", ListProducts);
            startActivity(intent);

            clearfields();
        }
    }

    public void clearfields(){
        txtCode.setText("");
        txtName.setText("");
        txtValor.setText("");
        txtDescription.setText("");
    }
}