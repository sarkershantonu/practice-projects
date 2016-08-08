package com.inheritance;

/**
 * Created by shantonu on 8/9/16.
 */
public class Application {

    public static void main(String[] args) {
        Animale animale =  new Animale ("Blank", "First entry animale");
        animale.printHabit();
        Animale mammals= new Mammals("Blank", "First entry mamale");
        mammals.printHabit();
        Animale dog= new Dog("Blank", "First entry dog");
        dog.printHabit();
        Animale human= new Human("Blank", "First entry human");
        human.printHabit();
        // the upper part tests, using this. will be get on current class context not super

        /*
        animale = new Animale ("animale");

        System.out.println("\n\n\nanimale = "+animale.toString()+"\nmammals = "+mammals.toString()+"\ndog = "+dog.toString()+"\nhuman = "+human.toString());
        mammals = new Mammals("Mamales");
        System.out.println( "\n\n\nanimale = "+animale.toString()+"\nmammals = "+mammals.toString()+"\ndog = "+dog.toString()+"\nhuman = "+human.toString());
        dog  = new Dog("Dog");
        System.out.println("\n\n\nanimale = "+animale.toString()+"\nmammals = "+mammals.toString()+"\ndog = "+dog.toString()+"\nhuman = "+human.toString());
        human = new Human("Human");
        System.out.println("\n\n\nanimale = "+animale.toString()+"\nmammals = "+mammals.toString()+"\ndog = "+dog.toString()+"\nhuman = "+human.toString());
        */
    }
}
