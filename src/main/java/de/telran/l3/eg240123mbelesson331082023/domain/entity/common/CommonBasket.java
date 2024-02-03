package de.telran.l3.eg240123mbelesson331082023.domain.entity.common;

import de.telran.l3.eg240123mbelesson331082023.domain.entity.Basket;
import de.telran.l3.eg240123mbelesson331082023.domain.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CommonBasket implements Basket {

    private List<Product> products = new ArrayList<>();


    @Override
    public double getTotalCost() {
        return products.stream().mapToDouble(x -> x.getPrice()).sum();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
