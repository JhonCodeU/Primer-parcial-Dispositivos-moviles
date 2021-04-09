package com.example.primerparcialdispositivosmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ShowProduct extends AppCompatActivity {

    Modelo modelo = Modelo.getInstance();
    private TextView tvPromedio;
    private TextView tvMasCostoso;
    private TextView tvMenosCostoso;
    private TextView tvSinIva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);

        int number = modelo.getListProducts().size();
        Log.v("Cantidad", number+"");

        calcularPromedioYsinIva();
        valoresMinimos();
        valoresMaximos();
    }

    public void calcularPromedioYsinIva(){

        double max, min;
        double promedio = 0, suma = 0;
        String cuerpo = "";

        for (int i = 0; i < modelo.getListProducts().size(); i++){

            suma = suma + modelo.getListProducts().get(i).getValor();

            if (modelo.getListProducts().get(i).isConIva() == false){
                cuerpo += modelo.getListProducts().get(i).getNombre()+": "+modelo.getListProducts().get(i).isConIva()+"\n";
            }
        }

        tvSinIva = findViewById(R.id.tvSinIva);
        tvSinIva.setText(cuerpo);

        promedio = suma/modelo.getListProducts().size();

        tvPromedio = findViewById(R.id.tvProm);
        tvPromedio.setText(promedio+"");
    }

    public void valoresMinimos(){

        Collections.sort(modelo.getListProducts());

        int contador = 0;
        String cuerpo = "";

        for(Product aux: modelo.getListProducts()){
            contador++;
            Log.v("orden", aux.getNombre()+" "+aux.getValor());

            cuerpo += aux.getNombre()+" "+aux.getValor()+"\n";
            if (contador == 10){
                break;
            }
        }
        tvMenosCostoso = findViewById(R.id.tvMenosCostosos);
        tvMenosCostoso.setText(cuerpo);
    }

    public void valoresMaximos(){

        Collections.reverse(modelo.getListProducts());

        int contador = 0;
        String cuerpo = "";

        for(Product aux: modelo.getListProducts()){
            contador++;
            Log.v("orden", aux.getNombre()+" "+aux.getValor());

            cuerpo += aux.getNombre()+" "+aux.getValor()+"\n";
            if (contador == 10){
                break;
            }
        }
        tvMasCostoso = findViewById(R.id.tvMasCostosos);
        tvMasCostoso.setText(cuerpo);
    }
}