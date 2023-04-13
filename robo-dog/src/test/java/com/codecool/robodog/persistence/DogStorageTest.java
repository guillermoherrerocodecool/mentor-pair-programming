package com.codecool.robodog.persistence;

import com.codecool.robodog.model.Breed;
import com.codecool.robodog.model.Dog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class DogStorageTest {


    @Test
    void add() {
        List<Dog> dogs = new ArrayList<>();
        DogStorage dogStorage = new DogStorage(dogs);
        Dog dog = new Dog("test", 0, new Breed("breed"));

        Assertions.assertTrue(dogs.isEmpty());

        dogStorage.add(dog);

        Assertions.assertEquals(1, dogs.size());
        Assertions.assertEquals(dog, dogs.get(0));
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }
}