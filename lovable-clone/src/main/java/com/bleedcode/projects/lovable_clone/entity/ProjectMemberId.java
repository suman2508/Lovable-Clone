package com.bleedcode.projects.lovable_clone.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProjectMemberId {
    Long projectId;
    Long userId;
}
