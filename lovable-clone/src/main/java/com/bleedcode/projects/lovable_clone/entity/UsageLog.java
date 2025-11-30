package com.bleedcode.projects.lovable_clone.entity;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UsageLog {

    Long id;
    User user;
    Project project;

    String action;
    
    Integer tokenUsed;
    Integer durationMs;

    String metaData;//JSON of {model: "", prompt: "", response: "" }
    Instant createdAt;
}
