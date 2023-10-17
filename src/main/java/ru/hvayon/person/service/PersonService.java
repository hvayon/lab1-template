package ru.hvayon.person.service;

import ru.hvayon.person.domain.Person;
import ru.hvayon.person.model.PersonRequest;

import java.util.List;
import java.util.Map;

public interface PersonService {
    public Person getPersonById(Integer id);
    public List<Person> getPersons();
    public Integer addPerson(PersonRequest request);
    public Person editPerson(int id, Map<String, Object> field) throws Throwable;
    public void deletePerson(Integer id);
}
