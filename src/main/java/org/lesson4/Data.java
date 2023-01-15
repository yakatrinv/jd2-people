package org.lesson4;

import java.util.Random;

public class Data {
    public static final String[] NAMES = {
            "Ivan", "Natalya", "Petr", "Olga", "Alexandr", "Elena",
            "Aleksey", "Svetlana", "Victor", "Marina", "Konstantin",
            "Irina", "Vitaliy", "Antonina", "Sergey", "Nadezda", "Michail"
    };
    public static final String[] SURNAMES = {
            "Ivanov/a", "Petrov/a", "Sidorov/a", "Stupin/a",
            "Darkin/a", "Bublikov/a", "Poloskun"
    };

    public static final int MAX_AGE = 30;
    public static final int MIN_AGE = 15;

    public static final Random RANDOM = new Random();
    public static final int COUNT_PERSONS = 100;
    public static final int COMING_OF_AGE = 21;
    public static final String PATH=".\\resources\\data.txt";
}
