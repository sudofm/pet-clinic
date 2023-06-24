package com.example.sfcpetclinic.services.map;

import com.example.sfcpetclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VetServiceMapTest {

    VetServiceMap vetServiceMap;
    private long id = 1L;

    @BeforeEach
    void setUp() {
        vetServiceMap = new VetServiceMap(new SpecialitiyServiceMap());
        vetServiceMap.save(new Vet().id(id));
    }

    @Test
    void findAll() {
        Set<Vet> vets = vetServiceMap.findAll();

        assertEquals(1, vets.size());

    }

    @Test
    void findById() {
        Vet vet = vetServiceMap.findById(id);

        assertNotNull(vet);
        assertEquals(1L, vet.getId());
    }

    @Test
    void saveExistingId() {
        vetServiceMap.save(new Vet().id(2L));
        assertEquals(2, vetServiceMap.findAll().size());
    }

    @Test
    void saveNoId() {
        Vet newVet = vetServiceMap.save(new Vet());
        assertNotNull(newVet);
        assertNotNull(newVet.getId());
    }

    @Test
    void delete() {
        vetServiceMap.delete(vetServiceMap.findById(id));
        assertEquals(0, vetServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        vetServiceMap.deleteById(id);
        assertEquals(0, vetServiceMap.findAll().size());
    }
}