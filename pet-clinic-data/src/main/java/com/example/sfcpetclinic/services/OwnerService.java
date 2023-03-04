package com.example.sfcpetclinic.services;

import com.example.sfcpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
