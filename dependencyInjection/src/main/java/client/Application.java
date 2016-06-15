package client;

import annotation.InjectMeHere;
import products.Service;

/**
 * Created by shantonu on 6/16/16.
 */
public class Application {

    @InjectMeHere
    Service aService;

    public static void main(String... args) {
        System.out.println("Injecting XML" + new Application().aService.serve());
    }
}
