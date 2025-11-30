package com.bleedcode.projects.lovable_clone.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class Plan {

    Long id;
    String name;
    String stripePriceId;
    Integer maxProjects;
    Integer maxTokensPerDay;
    Integer maxPreviews; // number of previews allowed per plan
    Boolean unlimitedAi; // unlimited access to LLM, ignore maxTokensPerDay.

    Boolean active;
}
