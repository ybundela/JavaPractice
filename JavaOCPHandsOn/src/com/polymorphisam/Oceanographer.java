package com.polymorphisam;

public class Oceanographer {

    public void checkSound(LivesInOcean livesInOcean){
        livesInOcean.makeSound();
    }

    public static void main(String[] args){
        Oceanographer oceanographer = new Oceanographer();
        oceanographer.checkSound(new Dolphin());
        oceanographer.checkSound(new Whale());

    }
}
