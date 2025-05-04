package com.guilhermesantos.petshop.service;

import com.guilhermesantos.petshop.model.Owner;
import com.guilhermesantos.petshop.model.Pet;
import com.guilhermesantos.petshop.repository.PetRepository;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;


    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAll() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPetById(Long id) {
        return petRepository.findById(id);
    }

    public List<Pet> getPetByOwnerId(Long id) {
        return petRepository.findAllById(Collections.singleton(id));
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
