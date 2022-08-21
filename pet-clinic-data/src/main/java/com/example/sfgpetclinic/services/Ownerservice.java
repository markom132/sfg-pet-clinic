package com.example.sfgpetclinic.services;

import com.example.sfgpetclinic.model.Owner;

public interface Ownerservice extends CrudService<Owner, Long> {
    Owner findByLastname(String lastName);

}
