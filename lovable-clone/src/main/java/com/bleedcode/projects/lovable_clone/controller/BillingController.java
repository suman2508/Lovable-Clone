package com.bleedcode.projects.lovable_clone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bleedcode.projects.lovable_clone.dto.subscription.CheckoutRequest;
import com.bleedcode.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.bleedcode.projects.lovable_clone.dto.subscription.PlanResponse;
import com.bleedcode.projects.lovable_clone.dto.subscription.PortalResponse;
import com.bleedcode.projects.lovable_clone.dto.subscription.SubscriptionResponse;
import com.bleedcode.projects.lovable_clone.service.PlanService;
import com.bleedcode.projects.lovable_clone.service.SubscriptionService;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class BillingController {

    PlanService planService;
    SubscriptionService subscriptionService;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription() {
        Long userId = 1L; // TODO: get from security context
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
    }

    @PostMapping("/api/stripe/checkout")
    public  ResponseEntity<CheckoutResponse> createCheckoutResponse(
        @RequestBody CheckoutRequest request) {
        //TODO: process POST request
        Long userId = 1L; // TODO: get from security context
        return  ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(request, userId));
    }

    @PostMapping("/api/stripe/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal() {
        Long userId = 1L; // TODO: get from security context
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }
    
    
}
