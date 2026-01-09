package com.bleedcode.projects.lovable_clone.mapper;

import com.bleedcode.projects.lovable_clone.dto.member.MemberResponse;
import com.bleedcode.projects.lovable_clone.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {
    MemberResponse toProjectMemberResponse(User owner);
}
