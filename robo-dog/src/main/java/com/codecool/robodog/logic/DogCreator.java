package com.codecool.robodog.logic;

import com.codecool.robodog.model.Dog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogCreator {
    private final RandomService randomService;
    private final List<String> names;
    private final List<String> breedNames;
    private final int minAge;
    private final int maxAge;

    public DogCreator(RandomService randomService, @Value("${names}") List<String> names,
                      @Value("${breedNames}") List<String> breedNames,
                      @Value("${minAge}") int minAge,
                      @Value("${maxAge}") int maxAge) {
        this.randomService = randomService;
        this.names = names;
        this.breedNames = breedNames;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Dog createRandomDog() {
        return new Dog(
                randomService.getOneRandom(names),
                randomService.getOneRandomBetween(minAge, maxAge),
                randomService.getOneRandom(breedNames));
    }
}
