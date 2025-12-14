package com.bleedcode.projects.lovable_clone.dto.member;

import java.time.Instant;
import com.bleedcode.projects.lovable_clone.enums.ProjectRole;

public record MemberResponse(
    Long userid,
    Long username,
    String name,
    ProjectRole projectRole,
    Instant invitedAt
) {

}
