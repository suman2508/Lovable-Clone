package com.bleedcode.projects.lovable_clone.service;

import java.util.List;

import com.bleedcode.projects.lovable_clone.dto.project.FileContentResponse;
import com.bleedcode.projects.lovable_clone.dto.project.FileNode;

public interface FileService {
    List<FileNode> getFileTree(Long projectId,Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
    
}
