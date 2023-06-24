package com.example.sfcpetclinic.repositories;

import com.example.sfcpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
