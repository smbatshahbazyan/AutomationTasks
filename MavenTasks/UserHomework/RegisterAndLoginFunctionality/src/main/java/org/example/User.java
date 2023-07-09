package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private String mail;
    private String login;
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name field is empty");
        }
        if (name.matches("[A-Z][a-z]*")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Incorrect name format!!!");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.length() < 1) {
            throw new IllegalArgumentException("Surname field is empty");
        }
        if (surname.matches("[A-Z][a-z]*")) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Incorrect surname format!!!");
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if (mail.length() < 1) {
            throw new IllegalArgumentException("Mail field is empty");
        }
        if (mail.matches("^(.+)@(.+)$")) {
            this.mail = mail;
        } else {
            throw new IllegalArgumentException("Incorrect mail format!!!");
        }
    }


    public void setLogin(String login) {
        if (login.matches("^(?=.*[0-9])(?=.*[a-z]).{8,20}$")) {
            this.login = login;
        } else {
            throw new IllegalArgumentException("Incorrect login format!!!");
        }
    }

    public void setPassword(String password) {
        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$")) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Incorrect password format!!!");
        }
    }


    User(String name, String surname, String mail, String login, String password) {
        setName(name);
        setSurname(surname);
        setMail(mail);
        setLogin(login);
        setPassword(password);
    }

    public static List<User> users = new ArrayList<>();

    public static void register(String name, String surname, String mail, String login, String password) {
        for (User user : users) {
            if (Objects.equals(user.login, login)) {
                throw new IllegalArgumentException("This login already taken");
            }
        }
        User user = new User(name, surname, mail, login, password);
        users.add(user);
    }

    public static User login(String login, String password) {
        User u1 = null;
        for (User user : users) {
            if (Objects.equals(user.login, login) && Objects.equals(user.password, password)) {
                System.out.println("Logged in");
                return user;
            }
        }
        if (u1 == null) {
            throw new IllegalArgumentException("Dos`nt exist");
        }
        return u1;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

//    @Override   //in process
//    public boolean equals(Object ob) {
//        return Objects.equals(login, user.login);
//    }
}
