package org.lesson4;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AppTest {
    @Test
    public void agePersonTest() {
        List<Person> people = ImplementatiomClass.createGroup();
        for (Person person:people) {
            System.out.println("Age: "+person.getAge());
            Assert.assertFalse("Возраст за пределами диапазона от 15 до 30",(person.getAge()<15 || person.getAge()>=30));
        }
    }

    @Test
    public void agePersonNotComingOfAgeTest() {
        List<Person> people = ImplementatiomClass.createGroup();
        List<Person> peopleNotComingOfAge = ImplementatiomClass.getPeopleNotComingOfAge(people);
        for (Person person:peopleNotComingOfAge) {
            System.out.println("Age: "+person.getAge());
            Assert.assertFalse("Возраст больше 21",person.getAge()>21);
        }
    }
}
