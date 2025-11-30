package com.bleedcode.projects.lovable_clone.entity;

import java.time.Instant;

import com.bleedcode.projects.lovable_clone.enums.PreviewStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Preview {

    Long id;

    Project project;

    String nameSpace;
    String podName;
    String previewUrl;

    PreviewStatus status;

    Instant startedAt;
    Instant terminatedAt;

    Instant createdAt;
}
