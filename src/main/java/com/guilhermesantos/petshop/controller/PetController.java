package com.guilhermesantos.petshop.controller;


import com.guilhermesantos.petshop.dto.PetCreateDTO;
import com.guilhermesantos.petshop.dto.PetDTO;
import com.guilhermesantos.petshop.model.Owner;
import com.guilhermesantos.petshop.model.Pet;
import com.guilhermesantos.petshop.service.OwnerService;
import com.guilhermesantos.petshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<PetDTO> getAll() {
        List<Pet> pets = petService.getAll();
        return pets.stream().map(pet -> new PetDTO(
                pet.getId(),
                pet.getName(),
                pet.getBreed(),
                pet.getGender(),
                pet.getColor(),
                pet.getWeight(),
                pet.getHeight(),
                pet.getBirthDate(),
                pet.getOwner() != null ? pet.getOwner().getId() : null // Retorna apenas o ID do Owner
        )).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> createPet(@RequestBody PetCreateDTO petCreateDTO) {
        // Recupera o Owner com base no ownerId
        Owner owner = ownerService.getOwnerById(petCreateDTO.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));


        // Cria o pet com os dados recebidos
        Pet pet = new Pet(petCreateDTO.getName(), petCreateDTO.getBreed(), petCreateDTO.getGender(), petCreateDTO.getColor(),
                petCreateDTO.getWeight(), petCreateDTO.getHeight(), petCreateDTO.getBirthDate(), owner.getId(), owner);



        petService.save(pet);


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deleteById(id);
    }
}
