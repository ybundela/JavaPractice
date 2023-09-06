package com.funtionalprograming;

public class FindMatching {

    private static void print(Animal animal, CheckTrait checkTrait){
        if(checkTrait.test(animal)){
            System.out.println(animal);
        }
    }
    public static void main(String[] args){
        print(new Animal("kangaroo" ,false,true), a -> a.canHop());
    }
}
