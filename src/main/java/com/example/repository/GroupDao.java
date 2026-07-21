package com.example.repository;

import com.example.domain.Group;
import com.example.domain.User;

import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class GroupDao {
    Map<Integer, Group> store;
    private static int groupId = 0;

    public Group createGroup(User admin, String name, List<Integer> members) {
        Group newGroup = Group.builder()
                                .admin(admin.getUserId())
                                .name(name)
                                .members(new HashSet<>(members))
                                .groupId(groupId++)
                                .build();
        newGroup.getMembers().add(admin.getUserId());
        return newGroup;
    }
}
