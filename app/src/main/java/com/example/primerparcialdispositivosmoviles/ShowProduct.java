package com.example.primerparcialdispositivosmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;
import java.util.Iterator;

public class ShowProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);

        ListProducts list = new ListProducts();

        int number = list.getListProducts().size();
        Log.v("Cantidad", number+"");
        /*Iterator itr = list.getListProducts().iterator();

        while(itr.hasNext()){
            Product st= (Product)itr.next();
            System.out.println(st.getNombre()+" "+st.getDescripcion()+" "+st.getValor());
            CustomToastView.makeInfoToast(this,st.getNombre()+" "+st.getDescripcion()+" "+st.getValor(),R.layout.custom_toast).show();
        }*/
    }
}