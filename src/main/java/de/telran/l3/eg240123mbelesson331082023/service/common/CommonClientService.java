package de.telran.l3.eg240123mbelesson331082023.service.common;

import de.telran.l3.eg240123mbelesson331082023.domain.entity.Basket;
import de.telran.l3.eg240123mbelesson331082023.domain.entity.Client;
import de.telran.l3.eg240123mbelesson331082023.domain.entity.Product;
import de.telran.l3.eg240123mbelesson331082023.repository.ClientRepository;
import de.telran.l3.eg240123mbelesson331082023.service.ClientService;
import de.telran.l3.eg240123mbelesson331082023.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonClientService implements ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private ProductService productService;

    @Override
    public List<Client> getAll() {
        return repository.getClients();
    }

    @Override
    public Client getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void add(Client client) {
        repository.addClient(client.getName());

    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);

    }

    @Override
    public void deleteByName(String name) {
        int idToDelete = repository.getClients().stream().filter(x -> x.getName().equals(name)).findFirst().get().getId();
        repository.deleteById(idToDelete);

    }

    @Override
    public int getCount() {
        return repository.getClients().size();
    }

    @Override
    public double getTotalPriceById(int id) {
        return repository.findById(id).getBasket().getTotalCost();
    }

    @Override
    public double getAveragePriceById(int id) {
        Basket basket = repository.findById(id).getBasket();
        return basket.getTotalCost() / basket.getProducts().size();
    }

    @Override
    public void addToBasketById(int clientId, int productId) {
        Client client = repository.findById(clientId);
        Product product = productService.getById(productId);
        client.getBasket().addProduct(product);

    }

    @Override
    public void deleteFromBasket(int clientId, int productId) {
        Client client = repository.findById(clientId);
        client.getBasket().getProducts().removeIf(x -> x.getId() == productId);


    }

    @Override
    public void clearBasket(int clientId) {
        Client client = repository.findById(clientId);
        client.getBasket().getProducts().clear();

    }
}
