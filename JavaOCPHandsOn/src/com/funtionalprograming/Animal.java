package com.funtionalprograming;

public class Animal {

    private String species;
    private boolean canSwim;
    private boolean canHop;

    public Animal(String species, boolean canSwim,boolean canHop){
        this.species =  species;
        this.canSwim = canSwim;
        this.canHop = canHop;
    }

    public boolean canHop(){
        return canHop;
    }
    public boolean canSwim(){
        return canSwim;
    }
    public String toString(){
        return species;
    }

}
