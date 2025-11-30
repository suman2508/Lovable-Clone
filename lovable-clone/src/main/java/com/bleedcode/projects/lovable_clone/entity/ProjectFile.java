package com.bleedcode.projects.lovable_clone.entity;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;   

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProjectFile {

    Long id;

    Project project;

    String path;
    String minioObjectKey;

    User createdBy;
    User updatedBy;

    Instant createdAt;
    Instant updatedAt;
}
