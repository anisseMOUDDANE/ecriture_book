package com.example.ecriture_marketplace.repository;

import com.example.ecriture_marketplace.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        System.out.println(client);
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        if (existingClient != null) {
            existingClient.setNom(client.getNom());
            existingClient.setSiret(client.getSiret());
            existingClient.setSirene(client.getSirene());
            existingClient.setAdresse(client.getAdresse());
            existingClient.setTelephone(client.getTelephone());
            existingClient.setEmail(client.getEmail());
            return clientRepository.save(existingClient);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}