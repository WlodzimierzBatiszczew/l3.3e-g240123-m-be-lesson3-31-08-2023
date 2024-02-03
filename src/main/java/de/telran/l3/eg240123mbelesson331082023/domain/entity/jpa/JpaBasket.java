package de.telran.l3.eg240123mbelesson331082023.domain.entity.jpa;

import de.telran.l3.eg240123mbelesson331082023.domain.entity.Basket;
import de.telran.l3.eg240123mbelesson331082023.domain.entity.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "basket")
public class JpaBasket implements Basket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private JpaClient client;

    @ManyToMany
    @JoinTable(
            name = "basket_product",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<JpaProduct> products;


    @Override
    public double getTotalCost() {
        return products.stream().mapToDouble(x -> x.getPrice()).sum();
    }

    @Override
    public void addProduct(Product product) {
        products.add(new JpaProduct(product.getId(), product.getName(), product.getPrice()));

    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
