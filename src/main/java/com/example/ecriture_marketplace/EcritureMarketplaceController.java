package com.example.ecriture_marketplace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcritureMarketplaceController {

    @GetMapping("/")
    public String index(){
        return "Bienvenue dans le back end de l'application Ecriture Marketplace !";
    }


}
