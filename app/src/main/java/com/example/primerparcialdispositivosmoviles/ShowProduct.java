package com.example.primerparcialdispositivosmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;
import java.util.Iterator;

public class ShowProduct extends AppCompatActivity {

    Modelo listModelo = Modelo.getInstance();
    private TextView tvPromedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);

        int number = listModelo.getListProducts().size();
        Log.v("Cantidad", number+"");

        calcular();
    }

    public void calcular(){

        double max, min;
        double promedio = 0, suma = 0;

        for (int i = 0; i < listModelo.getListProducts().size(); i++){

            suma = suma + listModelo.getListProducts().get(i).getValor();
        }

        promedio = suma/listModelo.getListProducts().size();

        tvPromedio = findViewById(R.id.tvProm);
        tvPromedio.setText(promedio+"");
    }
}