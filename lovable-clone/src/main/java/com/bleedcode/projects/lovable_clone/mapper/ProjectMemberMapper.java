package com.bleedcode.projects.lovable_clone.mapper;

import com.bleedcode.projects.lovable_clone.dto.member.MemberResponse;
import com.bleedcode.projects.lovable_clone.entity.ProjectMember;
import com.bleedcode.projects.lovable_clone.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(source = "email",target = "username")
    @Mapping(source = "id", target = "userId")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target = "username",source = "user.email")
    @Mapping(target = "name",source = "user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
