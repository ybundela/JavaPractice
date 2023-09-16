package com.designPattern.Singleton;

public class LazyInstantiation {

    private static volatile LazyInstantiation lazyInstantiation;
    private LazyInstantiation(){};

    //Using synchronized to make Lazy instantiation thread safe
    public static synchronized LazyInstantiation getInstance(){
        if(lazyInstantiation == null){
             lazyInstantiation = new LazyInstantiation();
        }
        return lazyInstantiation;
    }



}
