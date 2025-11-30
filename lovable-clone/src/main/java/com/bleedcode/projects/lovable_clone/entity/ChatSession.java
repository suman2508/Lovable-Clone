package com.bleedcode.projects.lovable_clone.entity;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ChatSession {

    Project project;
    User user;

    String title;

    Instant createdAt;
    Instant updatedAt;

    Instant deletedAt;
}
