package com.inheritance;

/**
 * Created by shantonu on 8/9/16.
 */
public class Animale {
    private String name;
    protected String habit;

    public Animale(String name, String habit) {
        this.name = name;
        this.habit = habit;
    }

    public Animale(String name) {
        this.name = name;
    }
    public String toString(){
        return this.name;
    }
    public void printHabit(){
        System.out.println(">>> Habit"+this .habit+" from "+this.getClass().getName());
    }
}
