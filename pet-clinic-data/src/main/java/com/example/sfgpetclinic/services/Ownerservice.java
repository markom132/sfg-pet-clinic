package com.example.sfgpetclinic.services;

import com.example.sfgpetclinic.model.Owner;

import java.util.Set;

public interface Ownerservice {
    Owner findById(Long id);

    Owner findByLastname(String lastName);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
