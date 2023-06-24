package com.example.sfcpetclinic.services.map;

import com.example.sfcpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PetServiceMapTest {

    PetServiceMap petServiceMap;
    private long id = 1L;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(new Pet().id(id));
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();

        assertEquals(1, pets.size());
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(id);

        assertNotNull(pet);
        assertEquals(1, pet.getId());
    }

    @Test
    void saveExistingId() {
        petServiceMap.save(new Pet().id(2L));

        assertEquals(2, petServiceMap.findAll().size());
    }

    @Test
    void saveNoId() {
        Pet savedPet = petServiceMap.save(new Pet());

        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());

    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(id));

        assertEquals(0, petServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(id);

        assertEquals(0, petServiceMap.findAll().size());
    }
}