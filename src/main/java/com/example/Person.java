package com.example;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {
    @NotBlank
    private final String name;

    @Min(1)
    private final int age;
}
