package utils;

import com.github.javafaker.Faker;

public class Generator {

    static Faker faker = new Faker();

    public static String generateUsername(){
        return faker.superhero().name().toLowerCase();
    }

    public static String generateEmail(){
        return faker.internet().emailAddress();
    }

    public static String generatePassword(){
        return faker.internet().password();
    }
}
