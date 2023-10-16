package ru.hvayon.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hvayon.person.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
