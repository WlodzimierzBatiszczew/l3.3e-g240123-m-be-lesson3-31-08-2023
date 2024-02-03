package de.telran.l3.eg240123mbelesson331082023.controllers;

import de.telran.l3.eg240123mbelesson331082023.domain.entity.Client;
import de.telran.l3.eg240123mbelesson331082023.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
@Autowired
    private ClientService service;
    @GetMapping
     public List<Client> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Client getById(@PathVariable int id){
        return service.getById(id);
    }
}
