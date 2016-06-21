package client;

import annotation.InjectMeHere;
import annotation.processor.AppLoader;
import annotation.processor.Factory;
import products.Service;

/**
 * Created by shantonu on 6/16/16.
 */
public class Application {


    /* this is needed when we do not use apploader
    static {
        Factory.createInstance(Application.class);
        InjectMeProcessor.inject(Application.class);
    }*/
    @InjectMeHere
    private static String aService = "old static value";

    @InjectMeHere
    private static Service myService;

    @InjectMeHere
    private Service mySer;

    @InjectMeHere
    private String service = "old normal value";

    public static void main(String... args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        AppLoader.load(Application.class);
        Application app = (Application) Factory.getObject(Application.class);
        // System.out.println("Injecting XML" + new Application().aService.serve());
        System.out.println("String in static member >> "+Application.aService);
        System.out.println("String in regular member >> "+app.service);

        System.out.println("String in static Service initilization >> "+Application.myService.serve());
        System.out.println("String in regular Service init >> "+app.mySer.serve());

        //RefUtils.setField(app,"service","I have changed");
        //System.out.println("String in regular member >> "+app.service);

       // System.out.println(RefUtils.getField(app,"service"));
        //System.out.println(RefUtils.getField(app,"service").toString());

    }
}
