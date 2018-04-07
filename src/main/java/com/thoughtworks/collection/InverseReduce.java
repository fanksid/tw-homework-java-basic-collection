package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> listRtn = new ArrayList<>();
        number -= 2;
        while (number > 0) {
            listRtn.add(number);
            number -= 2;
        }
        return listRtn;
    }
}
