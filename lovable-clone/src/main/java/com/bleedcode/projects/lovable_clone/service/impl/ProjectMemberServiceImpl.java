package com.bleedcode.projects.lovable_clone.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bleedcode.projects.lovable_clone.dto.project.ProjectReponse;
import com.bleedcode.projects.lovable_clone.dto.project.ProjectRequest;
import com.bleedcode.projects.lovable_clone.entity.Project;
import com.bleedcode.projects.lovable_clone.service.ProjectMemberService;

@Service
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper ProjectMapper;

    @Override
    public ProjectReponse createProject(ProjectRequest request, Long userId) {
        User  = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Project project = Project.builder()
            .name(request.name())
            .isPublic(request.isPublic())
            .build();

        project = projectRepository.save(project);
        return ProjectMapper.toResponse(savedProject);
    }   


}
