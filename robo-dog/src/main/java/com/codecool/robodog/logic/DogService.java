package com.codecool.robodog.logic;

import com.codecool.robodog.model.Dog;
import com.codecool.robodog.persistence.DogStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private final DogStorage dogStorage;
    private final DogCreator dogCreator;

    public DogService(DogStorage dogStorage, DogCreator dogCreator) {
        this.dogStorage = dogStorage;
        this.dogCreator = dogCreator;
    }

    public List<Dog> getAll() {
        return dogStorage.getAll();
    }

    public Dog add(Dog dog) {
        dogStorage.add(dog);
        return dog;
    }

    public Dog createOneRandom() {
        Dog dog = dogCreator.createRandomDog();
        dogStorage.add(dog);
        return dog;
    }

    public Dog update(Dog dog) {
        dogStorage.update(dog.getName(), dog.getAge(), dog.getBreed().getName());
        return dog;
    }
}
