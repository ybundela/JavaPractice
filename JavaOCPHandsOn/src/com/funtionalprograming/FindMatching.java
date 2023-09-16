package com.funtionalprograming;

import java.util.function.Predicate;

public class FindMatching {

//    private static void print(Animal animal, CheckTrait checkTrait){
//        if(checkTrait.test(animal)){
//            System.out.println(animal);
//        }
//    }

    private static void print(Animal animal, Predicate<Animal> testPreidactes){
        if(testPreidactes.test(animal)){
            System.out.println(animal);
        }
    }
    public static void main(String[] args){
        print(new Animal("kangaroo" ,false,true), a -> a.canHop());

    }
}
