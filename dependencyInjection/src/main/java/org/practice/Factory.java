package org.practice;

/**
 * Created by shantonu on 6/16/16.
 */
public class Factory {
    private static Factory intance ;

    public static Factory getInstance(){
        if(intance.equals(null)){
            intance = new Factory();
        }
        return intance;
    }

}
