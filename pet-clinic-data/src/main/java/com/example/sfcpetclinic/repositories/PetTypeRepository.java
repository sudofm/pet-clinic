package com.example.sfcpetclinic.repositories;

import com.example.sfcpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
