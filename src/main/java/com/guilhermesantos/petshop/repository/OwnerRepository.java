package com.guilhermesantos.petshop.repository;

import com.guilhermesantos.petshop.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
