package org.automation;


import java.io.IOException;
import java.util.logging.*;

public class App {
    private static Logger log = Logger.getLogger(App.class.getName());
    private static Handler handler = null;

    public static void main(String... args) {
        filterExample();
        /*
        ConsoleHandlerExample();
        MemoryHandlerExample();
        StreamHandlerExample();
        try {
            SocketHandlerExample();// start log server before running
            FileHandlerExample();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    private static void FileHandlerExample() throws IOException {
        handler = new FileHandler("./logs/logs_from_javaApi. log");
        log.addHandler(handler);
        handler.setLevel(Level.ALL);
        log.setLevel(Level.ALL);
        defaultLogging();

    }

    private static void ConsoleHandlerExample() {
        handler = new ConsoleHandler();
        log.addHandler(handler);
        handler.setLevel(Level.ALL);
        log.setLevel(Level.ALL);
        defaultLogging();
    }

    private static void MemoryHandlerExample() {
        handler = new MemoryHandler(new ConsoleHandler(),1024,Level.ALL);
        log.addHandler(handler);
        handler.setLevel(Level.ALL);
        log.setLevel(Level.ALL);
        defaultLogging();
    }
    private static void SocketHandlerExample() throws IOException {
        handler = new SocketHandler("localhost",9200);
        log.addHandler(handler);
        handler.setLevel(Level.ALL);
        log.setLevel(Level.ALL);
        defaultLogging();
    }
    private static void StreamHandlerExample() {
        handler = new StreamHandler(System.out,new SimpleFormatter());
        log.addHandler(handler);
        handler.setLevel(Level.ALL);
        log.setLevel(Level.ALL);
        log.setUseParentHandlers(false);
        defaultLogging();
    }

    private static void defaultLogging() {
        log.fine("This is fine logging using " + log.getClass());
        log.info("This is info logging using " + log.getClass());
        log.finer("This is finer logging using " + log.getClass());
        log.finest("This is finest logging using " + log.getClass());
        log.config("This is config logging using " + log.getClass());
        log.severe("This is severe logging using " + log.getClass());
        log.warning("This is warning logging using " + log.getClass());
        System.out.println("example of " + log.getClass());
    }
    private static void filterExample(){
        log.setFilter(new LogFilter("warning"));// only logs messages with warning keywords
        defaultLogging();
    }
}
