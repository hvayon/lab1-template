//package ru.hvayon.person;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import ru.hvayon.person.controllers.PersonController;
//import ru.hvayon.person.domain.Person;
//import ru.hvayon.person.model.PersonRequest;
//import ru.hvayon.person.repository.PersonRepository;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class PersonControllerTest {
//
//    @MockBean
//    private PersonRepository personRepository;
//
//    @Autowired
//    private PersonController personController;
//
//    private static final PersonRequest testPerson = new PersonRequest("Natalia", 18, "Moscow", "Junior Java Developer");
//    @Test
//    void addPersonTest() {
//        ResponseEntity<Void> response = personController.addPerson(testPerson);
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//    }
//}
