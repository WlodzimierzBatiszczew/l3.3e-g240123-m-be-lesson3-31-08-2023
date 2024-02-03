package de.telran.l3.eg240123mbelesson331082023.repository.common;

import de.telran.l3.eg240123mbelesson331082023.domain.database.Database;
import de.telran.l3.eg240123mbelesson331082023.domain.entity.Product;
import de.telran.l3.eg240123mbelesson331082023.repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class CommonProductRepository implements ProductRepository {

    private Database database;
    @Override
    public List<Product> getAll() {
        try {
            return database.select("Select all products").stream().map(x -> (Product)x).toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getById(int id) {
        try {
            return (Product) database.select("Select product where id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String name, double price) {
        try {
            database.execute("Add new product name = " + name + " price = " + price);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            database.execute("Delete product where id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
