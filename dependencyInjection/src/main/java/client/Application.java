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

    public static void main(String... args) {
       // System.out.println("Injecting XML" + new Application().aService.serve());
        System.out.println("Injecting string >> "+new Application().aService);
    }
}
