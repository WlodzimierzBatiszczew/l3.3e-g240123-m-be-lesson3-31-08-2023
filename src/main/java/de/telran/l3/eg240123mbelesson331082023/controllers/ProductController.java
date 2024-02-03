package de.telran.l3.eg240123mbelesson331082023.controllers;

import de.telran.l3.eg240123mbelesson331082023.domain.entity.Product;
import de.telran.l3.eg240123mbelesson331082023.domain.entity.common.CommonProduct;
import de.telran.l3.eg240123mbelesson331082023.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    public Product add(@RequestBody CommonProduct product) {
        try {
            service.add(product);
            return product;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/deletename/{name}")
    public void delete(@PathVariable String name) {

        service.deleteByName(name);
    }

    @GetMapping("/count")
    public int getCount() {
        return service.getCount();
    }

    @GetMapping("/total")
    public double getTotalPrice() {
        return service.getTotalPrice();
    }

    @GetMapping("/average")
    public double getAverage() {
        return service.getAveragePrice();
    }


}
