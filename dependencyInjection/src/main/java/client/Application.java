package client;

import annotation.InjectMeHere;
import annotation.processor.AppLoader;
import annotation.processor.Factory;

/**
 * Created by shantonu on 6/16/16.
 */
public class Application {

    private static Application app;
    public Application(){}
    /*static {
        Factory.createInstance(Application.class);
        InjectMeProcessor.inject(Application.class);
    }*/
    @InjectMeHere
    private static String aService = "old static value";

    @InjectMeHere
    private String service = "old normal value";

    public static void main(String... args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        //app = Application.getObject();
        AppLoader.load(Application.class);
        app = (Application) Factory.getObject(Application.class);
        // System.out.println("Injecting XML" + new Application().aService.serve());
        System.out.println("String in static member >> "+Application.aService);
        System.out.println("String in regular member >> "+app.service);

        //RefUtils.setField(app,"service","I have changed");
        //System.out.println("String in regular member >> "+app.service);

       // System.out.println(RefUtils.getField(app,"service"));
        //System.out.println(RefUtils.getField(app,"service").toString());

    }
}
