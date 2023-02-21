package com.example.sfcpetclinic.services;

import com.example.sfcpetclinic.model.Pet;

import java.util.Set;

interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
