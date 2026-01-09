package com.bleedcode.projects.lovable_clone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bleedcode.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.bleedcode.projects.lovable_clone.dto.member.MemberResponse;
import com.bleedcode.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.bleedcode.projects.lovable_clone.service.ProjectMemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMember(@PathVariable Long projectId) {
        Long userId = 1L; // Placeholder for authenticated user ID
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId, userId));    
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(
        @PathVariable Long projectId,
        @RequestBody @Valid InviteMemberRequest request
    ) {
        Long userId = 1L; // Placeholder for authenticated user ID
        return ResponseEntity.status(HttpStatus.CREATED).body(
            projectMemberService.inviteMember(projectId, request, userId)
        );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(
        @PathVariable Long projectId,
        @PathVariable Long memberId,
        @RequestBody @Valid UpdateMemberRoleRequest request 
    ) {
        Long userId = 1L; // Placeholder for authenticated user ID
        return ResponseEntity.ok(
            projectMemberService.updateMemberRole(projectId, memberId, request, userId)
        );
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> removeMember(
        @PathVariable Long projectId,
        @PathVariable Long memberId
    ) {
        Long userId = 1L; // Placeholder for authenticated user ID
        projectMemberService.removeProjectMember(projectId, memberId, userId);
        return ResponseEntity.noContent().build();
    }
    
}
