package com.bleedcode.projects.lovable_clone.service.impl;

import com.bleedcode.projects.lovable_clone.dto.project.FileContentResponse;
import com.bleedcode.projects.lovable_clone.dto.project.FileNode;
import com.bleedcode.projects.lovable_clone.service.FileService;

import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
