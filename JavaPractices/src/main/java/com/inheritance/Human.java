package com.inheritance;

/**
 * Created by shantonu on 8/9/16.
 */
public class Human extends Mammals{
    //private String name;

    public Human(String name) {
        super(name);
    }
    public Human(String name, String habit){
        super(name,habit);
    }
}
