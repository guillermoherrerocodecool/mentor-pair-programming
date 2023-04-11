package com.codecool.robodog.utilities;

import com.codecool.robodog.model.Dog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DogStorage {
    private List<Dog> dogStorageForDogsThatNeedStorage = new ArrayList<>();

    public void add(Dog dog) {
        dogStorageForDogsThatNeedStorage.add(dog);
    }

    public List<Dog> getAll() {
        return dogStorageForDogsThatNeedStorage;
    }

    public void update(String name, int age, String breed) {
        Optional<Dog> oDog = dogStorageForDogsThatNeedStorage.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst();
        if (oDog.isPresent()) {
            Dog dog = oDog.get();
            dog.setAge(age);
            dog.getBreed().setName(breed);
        }
    }
}
