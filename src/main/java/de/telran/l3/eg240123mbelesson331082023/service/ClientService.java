package de.telran.l3.eg240123mbelesson331082023.service;

import de.telran.l3.eg240123mbelesson331082023.domain.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAll();
    Client getById(int id);
    void add(Client client);
    void deleteById(int id);
    void deleteByName(String name);
    int getCount();
    double getTotalPriceById(int id);
    double getAveragePriceById(int id);
    void addToBasketById(int clientId, int productId);
    void deleteFromBasket(int clientId, int productId);
    void clearBasket(int clientId);

}
