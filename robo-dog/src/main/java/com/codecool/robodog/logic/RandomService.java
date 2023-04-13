package com.codecool.robodog.logic;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RandomService {
    private final Random random;

    public RandomService(Random random) {
        this.random = random;
    }

    public int getOneRandomBetween(int min, int max) {
        return random.nextInt(min, max);
    }

    public String getOneRandom(List<String> collection) {
        int randomIndex = random.nextInt(collection.size());
        return collection.get(randomIndex);
    }
}
