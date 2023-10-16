package ru.hvayon.person.model;

import ru.hvayon.person.domain.Person;

public class PersonResponse {
    private int id;
    private String name;
    private int age;
    private String address;
    private String work;

    public PersonResponse(int id, String name, Integer age, String address, String work) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.work = work;
    }

    public PersonResponse(Person person) {
        person.getId();
        person.getName();
        person.getAge();
        person.getAddress();
        person.getWork();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getWork() {
        return work;
    }
}
