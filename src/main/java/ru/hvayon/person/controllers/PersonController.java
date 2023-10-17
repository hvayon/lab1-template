package ru.hvayon.person.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.hvayon.person.domain.Person;
import ru.hvayon.person.model.PersonRequest;
import ru.hvayon.person.service.PersonService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/ping")
    public String getPersonById() {
        return "pong";
    }
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable("id") Integer id){
        return personService.getPersonById(id);
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PostMapping("/persons")
    public ResponseEntity<Void> addPerson(@RequestBody PersonRequest person) {
        int id = personService.addPerson(person);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri()
        ).build();
    }

    @PatchMapping("/persons/{id}")
    public Person editPerson(@PathVariable int id, @RequestBody Map<String, Object> fields) throws Throwable {
        return personService.editPerson(id, fields);
    }

    @DeleteMapping("/persons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
    }

}
