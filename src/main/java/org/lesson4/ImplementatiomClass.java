package org.lesson4;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.lesson4.Data.*;

public class ImplementatiomClass {
    public static Person createPerson() {
        String name = NAMES[RANDOM.nextInt(NAMES.length)];
        String surname = SURNAMES[RANDOM.nextInt(SURNAMES.length)];
        int age = RANDOM.nextInt(MAX_AGE - MIN_AGE) + MIN_AGE;
        return new Person(name, surname, age);
    }

    public static List<Person> createGroup() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < COUNT_PERSONS; i++) {
            people.add(createPerson());
        }
        return people;
    }

    public static List<Person> getPeopleNotComingOfAge(List<Person> people) {
        return people.stream().filter(person -> person.getAge() < COMING_OF_AGE).collect(Collectors.toList());
    }

    public static void print(List<Person> list) {
        list.forEach(System.out::println);
    }

    public static List<Person> getSortList(List<Person> personList) {
        personList
                .sort(Comparator.comparing(Person::getSurname)
                        .thenComparing(Person::getName)

                );

        return personList;
    }

    public static List<Person> getUniqList(List<Person> personList) {
        return personList.stream().distinct().collect(Collectors.toList());
    }

    public static void writeToFile(List<Person> peopleNotComingOfAge) {
        File dataFile = new File(PATH);
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                System.out.println("New file is not create");
                return;
            }
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            for (Person person : peopleNotComingOfAge) {
                objectOutputStream.writeObject(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printDataInFile() {
        readFile().stream()
                .map(person -> person.getSurname() + " " + person.getName())
                .forEach(System.out::println);
    }

    public static List<Person> readFile() {
        List<Person> personList = new ArrayList<>();

        File dataFile = new File(PATH);
        if (!dataFile.exists()) {
            System.out.println("New file is not found");
            return personList;
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(dataFile))) {

            while (true) {
                try {
                    Person person = (Person) objectInputStream.readObject();
                    personList.add(person);
                } catch (ClassNotFoundException e) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return personList;
    }
}
