package org.lesson4;

import java.util.List;

public class App {
    public static List<Person> people;
    public static List<Person> peopleNotComingOfAge;

    public static void main(String[] args) {
        people = ImplementatiomClass.createGroup();

        peopleNotComingOfAge = ImplementatiomClass.getPeopleNotComingOfAge(people);
        ImplementatiomClass.print(peopleNotComingOfAge);

        peopleNotComingOfAge = ImplementatiomClass.getSortList(peopleNotComingOfAge);

        peopleNotComingOfAge = ImplementatiomClass.getUniqList(peopleNotComingOfAge);

        ImplementatiomClass.writeToFile(peopleNotComingOfAge);

        ImplementatiomClass.printDataInFile();
        System.out.println();

    }
}
