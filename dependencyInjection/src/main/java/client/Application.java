package client;

import annotation.InjectMeHere;
import annotation.processor.InjectMeProcessor;
import products.Service;

/**
 * Created by shantonu on 6/16/16.
 */
public class Application {

    static {
        InjectMeProcessor.inject(Application.class);
    }
    @InjectMeHere
    private static String aService;

    //@InjectMeHere
    private String service;

    public static void main(String... args) {
       // System.out.println("Injecting XML" + new Application().aService.serve());
        System.out.println("String in static member >> "+Application.aService);
        System.out.println("String in regular member >> "+new Application().service);
    }
}
