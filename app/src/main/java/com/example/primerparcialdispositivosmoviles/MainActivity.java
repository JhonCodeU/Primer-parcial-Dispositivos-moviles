package com.example.primerparcialdispositivosmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAddProduct;
    private Button btnShowProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnShowProducts = findViewById(R.id.btnShowProducts);
        btnAddProduct.setOnClickListener(this);
        btnShowProducts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAddProduct){
            Intent i = new Intent(getApplicationContext(), AddProduct.class);
            startActivity(i);
        }else if(v.getId() == R.id.btnShowProducts){
            Intent i = new Intent(getApplicationContext(), ShowProduct.class);
            startActivity(i);
        }
    }
}