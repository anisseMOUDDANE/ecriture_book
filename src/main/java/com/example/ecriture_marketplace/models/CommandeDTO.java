package com.example.ecriture_marketplace.models;

import java.time.LocalDate;
import java.util.List;

public class CommandeDTO {
    private LocalDate date;
    private Long idLibrairie;
    private Long idClient;
    private List<CommandeLivreDTO> commandesLivres;

    public LocalDate getDate() {
        return date;
    }

    public Long getIdLibrairie() {
        return idLibrairie;
    }

    public Long getIdClient() {
        return idClient;
    }

    public List<CommandeLivreDTO> getCommandesLivres() {
        return commandesLivres;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setIdLibrairie(Long idLibrairie) {
        this.idLibrairie = idLibrairie;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public void setCommandesLivres(List<CommandeLivreDTO> commandesLivres) {
        this.commandesLivres = commandesLivres;
    }
}

