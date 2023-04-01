package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        addPerson("Tom");
        addPerson("Bob");
        addPerson("Mike");
        addPerson("Katy");
    }

    private void addPerson(String name) {
        people.add(new Person(++PEOPLE_COUNT, name));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(people->people.getId()==id)
                .findAny()
                .orElse(null);
    }
}
