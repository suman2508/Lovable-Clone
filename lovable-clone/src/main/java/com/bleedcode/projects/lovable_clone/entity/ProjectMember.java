package com.bleedcode.projects.lovable_clone.entity;

import java.time.Instant;

import com.bleedcode.projects.lovable_clone.enums.ProjectRole;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProjectMember {
    ProjectMemberId id;

    Project project;
    User user;  
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}
