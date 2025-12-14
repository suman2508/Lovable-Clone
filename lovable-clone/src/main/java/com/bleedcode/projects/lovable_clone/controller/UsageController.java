package com.bleedcode.projects.lovable_clone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bleedcode.projects.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.bleedcode.projects.lovable_clone.dto.subscription.UsageTodayResponse;
import com.bleedcode.projects.lovable_clone.service.UsageService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")   
public class UsageController {

    private final UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getTodayUsage() {
        Long userId = 1L; // Placeholder for authenticated user ID
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
    }

    @GetMapping("/limits")
    public ResponseEntity<PlanLimitsResponse> getPlanLimits() {
       Long userId = 1L; // Placeholder for authenticated user ID
       return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitsOfUser(userId));
    }
    
    
}
