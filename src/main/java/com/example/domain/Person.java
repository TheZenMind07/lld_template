package com.example.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {
    private final String name;

    private final int age;
}
