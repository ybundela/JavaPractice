package com.polymorphisam;

public class Secondary extends Primary implements PrimaryInterface{

    public int age = 10;
    @Override
    public boolean testAgain() {
        return false;
    }

    public static void main(String[] args){
        Secondary secondary = new Secondary();
        System.out.println(secondary.age);

        Primary primary = secondary;
        System.out.println(primary.test());
       Secondary secondary2 = (Secondary)primary;
        //try to access age
        //primary.testAgain(); //does not complie
        //primary.age; //does not complie

        PrimaryInterface primaryInterface = (Secondary)secondary;
        //try to access method of secondary
        //primaryInterface.age; //does not complie
        primaryInterface.testAgain();
    }
}
