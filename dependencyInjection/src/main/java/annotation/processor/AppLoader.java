package annotation.processor;

import client.Application;

/**
 * Created by shantonu on 6/19/16.
 */
public class AppLoader {
    public static void load(Class<?> aClass){
        Factory.createInstance(aClass);
        InjectMeProcessor.inject(aClass);
    }
}
