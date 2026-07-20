package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
