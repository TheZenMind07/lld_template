package com.example.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Group {
    private int groupId;
    private String name;
    private Set<Integer> members;
    private Integer admin;
}
