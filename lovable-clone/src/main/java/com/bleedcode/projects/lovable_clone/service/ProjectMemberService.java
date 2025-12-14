package com.bleedcode.projects.lovable_clone.service;

import java.util.List;

import com.bleedcode.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.bleedcode.projects.lovable_clone.dto.member.MemberResponse;
import com.bleedcode.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long projectId, Long userId);
    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);
    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest role, Long userId);
    void removeProjectMember(Long projectId, Long memberId, Long userId);
} 