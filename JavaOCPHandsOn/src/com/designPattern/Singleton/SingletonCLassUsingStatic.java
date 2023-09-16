package com.designPattern.Singleton;

public class SingletonCLassUsingStatic {

    private static final SingletonCLassUsingStatic singletonCLassUsingStatic;

    static {
        singletonCLassUsingStatic = new SingletonCLassUsingStatic();
    }

    private SingletonCLassUsingStatic(){};

    public static SingletonCLassUsingStatic getInstance(){
        return singletonCLassUsingStatic;
    }
}
