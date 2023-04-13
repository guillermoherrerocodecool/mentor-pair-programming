package com.codecool.robodog.controller;

import com.codecool.robodog.logic.DogService;
import com.codecool.robodog.model.Dog;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAll();
    }

    @PostMapping
    public Dog createDog(@RequestBody Dog dog) {
        return dogService.add(dog);
    }

    @PostMapping("random")
    public Dog createRandomDog() {
        return dogService.createOneRandom();
    }

    @PatchMapping
    public Dog updateDog(@RequestBody Dog dog) {
        return dogService.update(dog);
    }
}
