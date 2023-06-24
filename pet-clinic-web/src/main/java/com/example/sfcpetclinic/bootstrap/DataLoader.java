package com.example.sfcpetclinic.bootstrap;

import com.example.sfcpetclinic.model.*;
import com.example.sfcpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }
    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");

        Owner owner1 = new Owner();
        owner1.setFirstName("Jean ");
        owner1.setLastName("Dupont");
        owner1.setAddress("132 Rue Moriba");
        owner1.setCity("Kayes");
        owner1.setPhone("+22372472823");

        Pet jeansPet = new Pet();
        jeansPet.setPetType(savedDogType);
        jeansPet.setOwner(owner1);
        jeansPet.setName("Boby");
        jeansPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(jeansPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Omar ");
        owner2.setLastName("Sy");
        owner2.setCity("Dakar");
        owner2.setPhone("+22472472023");

        Pet omarsCat = new Pet();
        omarsCat.setPetType(savedCatType);
        omarsCat.setOwner(owner2);
        omarsCat.setName("Michou");
        omarsCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(omarsCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(omarsCat);
        catVisit.setVisitDate(LocalDate.now());
        catVisit.setDescription("Petite visite");

        visitService.save(catVisit);

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
