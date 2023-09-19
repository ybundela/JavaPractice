package com.designPattern.Singleton;

public class LazyInstantiation {

    private static volatile LazyInstantiation lazyInstantiation;
    private LazyInstantiation(){};

    //Using synchronized to make Lazy instantiation thread safe
    public static  LazyInstantiation getInstance(){
        if(lazyInstantiation == null){
            synchronized (LazyInstantiation.class){
                if(lazyInstantiation == null){
                    lazyInstantiation = new LazyInstantiation();
                }
            }

        }
        return lazyInstantiation;
    }



}
