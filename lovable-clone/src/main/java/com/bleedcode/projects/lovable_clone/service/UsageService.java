package com.bleedcode.projects.lovable_clone.service;

import com.bleedcode.projects.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.bleedcode.projects.lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);
    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}