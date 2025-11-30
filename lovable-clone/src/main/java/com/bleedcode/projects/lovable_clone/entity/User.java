package com.bleedcode.projects.lovable_clone.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class User {

    Long id;
    String email;
    String passwordHash;
    String name;

    String avatarUrl;

    // Can use Instant instead of LocalDateTime if needed
     LocalDateTime createdAt;
     LocalDateTime updatedAt;
     LocalDateTime deletedAt; //soft delete
}
