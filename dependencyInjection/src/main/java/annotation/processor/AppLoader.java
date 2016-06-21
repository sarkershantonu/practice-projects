package annotation.processor;

import client.Application;
import products.FileService;
import products.XMLService;

/**
 * Created by shantonu on 6/19/16.
 */
public class AppLoader {

    public static void load(Class<?> aClass){
        load();
        Factory.createInstance(aClass);
        InjectMeProcessor.inject(aClass);

    }

    /**
     * This will responsible for load instructions by default.
     */
    private static void load(){
        Factory.createInstance(XMLService.class);
        Factory.createInstance(FileService.class);
    }
   // aulternate loader , it should be in class path, inject externally
/*
    static {
        Factory.createInstance(XMLService.class);
        Factory.createInstance(FileService.class);
        Factory.createInstance(Application.class);
        InjectMeProcessor.inject(Application.class);
    }*/
}
