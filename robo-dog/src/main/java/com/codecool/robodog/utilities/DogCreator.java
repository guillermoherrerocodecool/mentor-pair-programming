package com.codecool.robodog.utilities;

import com.codecool.robodog.model.Dog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DogCreator {
    private Random random = new Random();
    private List<String> names;
    private List<String> breedNames;
    private int minAge;
    private int maxAge;

    public DogCreator(@Value("${names}") List<String> names, 
                      @Value("${breedNames}") List<String> breedNames, 
                      @Value("${minAge}") int minAge, 
                      @Value("${maxAge}") int maxAge) {
        this.names = names;
        this.breedNames = breedNames;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Dog createRandomDog() {
        String name = names.get(random.nextInt(names.size()));
        int age = random.nextInt(minAge, maxAge);
        String breedName = breedNames.get(random.nextInt(breedNames.size()));
        return new Dog(name, age, breedName);
    }
}
