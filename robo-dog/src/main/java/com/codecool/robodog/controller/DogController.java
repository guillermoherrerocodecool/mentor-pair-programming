package com.codecool.robodog.controller;

import com.codecool.robodog.model.Dog;
import com.codecool.robodog.utilities.DogCreator;
import com.codecool.robodog.utilities.DogStorage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {
    private DogStorage dogStorage;
    private DogCreator dogCreator;
    
    public DogController(DogStorage dogStorage, DogCreator dogCreator) {
        this.dogStorage = dogStorage;
        this.dogCreator = dogCreator;
    }

    @GetMapping("/api/dogs")
    public List<Dog> getAllDogs() {
        return dogStorage.getAll();
    }

    @PostMapping("/api/dogs")
    public Dog createDog(@RequestBody Dog dog) {
        dogStorage.add(dog);
        return dog;
    }

    @PostMapping("/api/dogs/random")
    public Dog createRandomDog() {
        Dog dog = dogCreator.createRandomDog();
        dogStorage.add(dog);
        return dog;
    }

    @PatchMapping("/api/dogs")
    public Dog updateDog(@RequestBody Dog dog) {
        dogStorage.update(dog.getName(), dog.getAge(), dog.getBreed().getName());
        return dog;
    }
}
