package com.guilhermesantos.petshop.controller;

import com.guilhermesantos.petshop.model.Pet;
import com.guilhermesantos.petshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAll();
    }

    @PostMapping
    public Pet create(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deleteById(id);
    }


}
