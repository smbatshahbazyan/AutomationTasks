package org.example;

public class Main {
    public static void main(String[] args) {
        User.register("Karen", "Abgaryan", "karen@gmail.com", "karijkaren55", "karenKarij1999+");
        User.register("Margar", "Margaryan", "margarg@mail.ru", "margarin66", "Margarin1010+");
        System.out.println(User.users);
    }
}