package com.example.sfgpetclinic.bootstrap;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Pet;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.Ownerservice;
import com.example.sfgpetclinic.services.PetTypeService;
import com.example.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final Ownerservice ownerservice;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(Ownerservice ownerservice, VetService vetService, PetTypeService petTypeService) {
        this.ownerservice = ownerservice;

        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glengane");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1586167861");

        ownerservice.save(owner1);


        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Weston");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1586167861");
        ownerservice.save(owner2);

        Pet michaelCat = new Pet();
        michaelCat.setName("Just Cat");
        michaelCat.setPetType(savedCatPetType);
        michaelCat.setOwner(owner2);
        michaelCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(michaelCat);


        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Son");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
