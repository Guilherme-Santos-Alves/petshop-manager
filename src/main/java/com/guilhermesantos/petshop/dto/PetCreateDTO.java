package com.guilhermesantos.petshop.dto;

import java.time.LocalDate;

public class PetCreateDTO {
    private String name;
    private String breed;
    private String gender;
    private String color;
    private double weight;
    private double height;
    private LocalDate birthDate;
    private Long ownerId;

    public PetCreateDTO(String name, String breed, String gender, String color, double weight, double height, LocalDate birthDate, Long ownerId) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.color = color;
        this.weight = weight;
        this.height = height;
        this.birthDate = birthDate;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
