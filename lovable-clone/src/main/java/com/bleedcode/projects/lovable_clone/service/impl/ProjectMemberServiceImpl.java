package com.bleedcode.projects.lovable_clone.service.impl;

import com.bleedcode.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.bleedcode.projects.lovable_clone.dto.member.MemberResponse;
import com.bleedcode.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.bleedcode.projects.lovable_clone.entity.Project;
import com.bleedcode.projects.lovable_clone.mapper.ProjectMemberMapper;
import com.bleedcode.projects.lovable_clone.repository.ProjectMemberRepository;
import com.bleedcode.projects.lovable_clone.repository.ProjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.bleedcode.projects.lovable_clone.dto.project.ProjectReponse;
//import com.bleedcode.projects.lovable_clone.dto.project.ProjectRequest;
//import com.bleedcode.projects.lovable_clone.entity.Project;
import com.bleedcode.projects.lovable_clone.service.ProjectMemberService;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId,userId);

        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponse(project.getOwner()));


        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest role, Long userId) {
        return null;
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {

    }

    ///  Internal Utility Functions
    private Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
    }
}
