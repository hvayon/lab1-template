package ru.hvayon.person.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import ru.hvayon.person.domain.Person;
import ru.hvayon.person.model.PersonRequest;
import ru.hvayon.person.repository.PersonRepository;
import ru.hvayon.person.service.PersonService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Transactional(readOnly = true)
    @Override
    public Person getPersonById(int id) {
        Optional<Person> person = Optional.ofNullable(personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person with id=" + id + " not found")));
        return person.get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public int addPerson(PersonRequest request) {
        Person saved = new Person(request.getName(), request.getAge(), request.getWork(), request.getAddress());
        personRepository.save(saved);
        return saved.getId();
    }

    @Override
    public Person editPerson(int id, Map<String, Object> fields) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Person.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, person.get(), value);
            });
            return (Person) personRepository.save(person.get());
        }
        return null;
    }

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

//    @Transactional(readOnly = true)
//    @Override
//    public PersonResponse getPerson(int id) {
//        PersonDTO person = personRepository.findByName(id)
//                .orElseThrow(() -> new EntityNotFoundException("Person " + id + " not found"));
//        return new PersonResponse(person);
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public List<PersonResponse> getPersons() {
//        List<PersonDTO> persons = personRepository.findAll();
//        return persons.stream()
//                .map(new PersonResponse(this))
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public int createPerson(PersonRequest personRequest) {
//        return 0;
//    }
//
//    @Override
//    public PersonResponse editPerson(int id, PersonRequest personRequest) {
//        return null;
//    }
//
//    @Override
//    public void deletePerson(int id) {
//
//    }
}
