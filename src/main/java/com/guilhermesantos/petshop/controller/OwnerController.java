package com.guilhermesantos.petshop.controller;

import com.guilhermesantos.petshop.model.Owner;
import com.guilhermesantos.petshop.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Owner> getOwnerById(@PathVariable Long id) {
        return ownerService.getOwnerById(id);
    }

    @PostMapping
    public Owner create (@RequestBody Owner owner){
        return ownerService.save(owner);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        ownerService.deleteById(id);
    }


}
