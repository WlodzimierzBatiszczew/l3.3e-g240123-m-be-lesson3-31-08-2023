package de.telran.l3.eg240123mbelesson331082023.repository;

import de.telran.l3.eg240123mbelesson331082023.domain.entity.Client;

import java.util.List;

public interface ClientRepository {
    Client findById(int id);
    List<Client> getClients();
    void deleteById(int id);
    void addClient(String name);
}
