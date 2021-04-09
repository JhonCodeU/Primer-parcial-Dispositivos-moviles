package com.example.primerparcialdispositivosmoviles;

import java.util.ArrayList;
import java.util.Iterator;

public class Modelo {

    private static Modelo ourInstance = new Modelo();

    public static Modelo getInstance() {
        return ourInstance;
    }

    private Modelo() {

    }

    private ArrayList<Product> listProducts = new ArrayList<Product>();

    public void addProduct(Product newProduct) {

        Iterator<Product> iterator = listProducts.iterator();

        while (iterator.hasNext()) {
            Product prod = iterator.next();
            if (prod.getCodigo() == newProduct.getCodigo()) {
                iterator.remove();
            }
        }
        listProducts.add(newProduct);

    }
    public ArrayList<Product> getListProducts() {
        return listProducts;
    }


}
