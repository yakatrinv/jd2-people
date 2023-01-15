package org.lesson4;


import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String Surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        Surname = surname;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return Surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && Surname.equals(person.Surname);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
