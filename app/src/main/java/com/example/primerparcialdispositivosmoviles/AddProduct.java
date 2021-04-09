package com.example.primerparcialdispositivosmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.ib.custom.toast.CustomToastView;

import java.util.Iterator;

public class AddProduct extends AppCompatActivity implements View.OnClickListener {

    private EditText txtCode;
    private EditText txtName;
    private EditText txtValor;
    private EditText txtDescription;
    private Spinner spinnerProduct;

    RadioButton radioSi, radioNo;

    private Button btnAdd;

    Modelo modelo = Modelo.getInstance();

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

        radioSi = (RadioButton) findViewById(R.id.radioSi);
        radioNo = (RadioButton) findViewById(R.id.radioNo);

        Product product1 = new Product(1, "Arroz", 1500, true, "Roa", "Grano");
        Product product2 = new Product(2, "Leche", 2300, false, "lateos", "lateos");
        Product product3 = new Product(3, "Yogurt", 1200, false, "lateos", "lateos");
        Product product4 = new Product(4, "Galletas", 5400, true, "harina", "harina");

        modelo.addProduct(product1);
        modelo.addProduct(product2);
        modelo.addProduct(product3);
        modelo.addProduct(product4);

        int number = modelo.getListProducts().size();
        Log.v("Cantidad", number+"");


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
            boolean haveIva;

            if(name.isEmpty()){
                CustomToastView.makeInfoToast(this,"Descripcion vacia",R.layout.custom_toast).show();
            }

            if(description.isEmpty()){
                CustomToastView.makeInfoToast(this,"Descripcion vacia",R.layout.custom_toast).show();
            }

            if(category.isEmpty()){
                CustomToastView.makeInfoToast(this,"Categoria vacia",R.layout.custom_toast).show();
            }

            if (radioSi.isChecked()){
                haveIva = true;
            }else {
                haveIva = false;
            }

            Log.d("Radio Button",haveIva+"");
            Product product = new Product(code, name, valor, haveIva, description, category);
            modelo.addProduct(product);

            /*Iterator itr = list.getListProducts().iterator();

            while(itr.hasNext()){
                Product st= (Product)itr.next();
                System.out.println(st.getNombre()+" "+st.getDescripcion()+" "+st.getValor());
            }*/
            //Intent intent = new Intent(this, ShowProduct.class);
            //startActivity(intent);

            CustomToastView.makeInfoToast(this,"Se registro Correctamente",R.layout.custom_toast).show();
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