package com.example.sfcpetclinic.services.springdatajpa;

import com.example.sfcpetclinic.model.Pet;
import com.example.sfcpetclinic.repositories.OwnerRepository;
import com.example.sfcpetclinic.repositories.PetRepository;
import com.example.sfcpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PetSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    PetSDJpaService service;

    Pet returnPet;
    private long id = 1L;

    @BeforeEach
    void setUp() {
        returnPet = new Pet().id(id);
    }

    @Test
    void findAll() {
        Set<Pet> returnedPets = new HashSet<>();
        returnedPets.add(new Pet().id(1L));
        returnedPets.add(new Pet().id(2L));

        when(petRepository.findAll()).thenReturn(returnedPets);

        Set<Pet> pets = service.findAll();

        assertNotNull(pets);
        assertEquals(2, pets.size());
    }

    @Test
    void findById() {
        when(petRepository.findById(id)).thenReturn(Optional.of(returnPet));

        Pet pet = service.findById(id);

        assertEquals(id, pet.getId());
    }

    @Test
    void findIdNotFound() {
        when(petRepository.findById(anyLong())).thenReturn(Optional.empty());

        Pet pet = service.findById(id);

        assertNull(pet);
    }

    @Test
    void save() {
        Pet toSave = new Pet().id(1L);

        when(petRepository.save(any())).thenReturn(returnPet);

        Pet savedPet = service.save(toSave);

        assertNotNull(savedPet);
        assertEquals(toSave.getId(), savedPet.getId());
    }

    @Test
    void delete() {
        service.delete(returnPet);
        verify(petRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(id);
        verify(petRepository, times(1)).deleteById(anyLong());
    }
}