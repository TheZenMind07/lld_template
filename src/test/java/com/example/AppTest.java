package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.domain.Person;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void personShouldExposeNameAndAge() {
        Person person = Person.builder()
                .name("Alice")
                .age(30)
                .build();

        assertEquals("Alice", person.getName());
        assertEquals(30, person.getAge());
        assert(person.getName().equals("Alice"));
        
    }
}
