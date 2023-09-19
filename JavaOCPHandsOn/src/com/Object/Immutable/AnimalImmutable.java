package com.Object.Immutable;

import java.util.ArrayList;
import java.util.List;

public final class AnimalImmutable {
    private final int age;
    private final String name;
    private final List<String> listOfAnimal;

    public AnimalImmutable(int age, String name, List<String> listOfAnimal){
        this.age = age;
        this.name = name;
        if(listOfAnimal == null){
            throw new RuntimeException();
        }
        this.listOfAnimal = new ArrayList<String>(listOfAnimal);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getListOfAnimal() {
        return listOfAnimal;
    }
}
