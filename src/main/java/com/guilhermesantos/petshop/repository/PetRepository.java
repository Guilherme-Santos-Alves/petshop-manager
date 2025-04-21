package com.guilhermesantos.petshop.repository;

import com.guilhermesantos.petshop.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
