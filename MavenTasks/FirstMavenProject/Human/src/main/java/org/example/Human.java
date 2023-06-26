package org.example;

public class Human {
    String name, surname;

    Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void printingName() {
        System.out.println(name + " " + surname);
    }

}
