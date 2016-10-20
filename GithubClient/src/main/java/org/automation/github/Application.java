package org.automation.github;

/**
 * Created by shantonu on 10/20/16.
 */
public class Application {
    public static void main(String[] args) {
        final MyClient myClient = new MyClient();
        myClient.run(args);
    }
}
