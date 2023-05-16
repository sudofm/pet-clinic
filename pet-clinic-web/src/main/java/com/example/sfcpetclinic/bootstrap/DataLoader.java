package com.example.sfcpetclinic.bootstrap;

import com.example.sfcpetclinic.model.Owner;
import com.example.sfcpetclinic.model.Vet;
import com.example.sfcpetclinic.services.OwnerService;
import com.example.sfcpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Jean ");
        owner1.setLastName("Dupont");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Omar ");
        owner2.setLastName("Sy");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Oumar");
        vet1.setLastName("Kamissoko");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mariam");
        vet2.setLastName("Kanté");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
