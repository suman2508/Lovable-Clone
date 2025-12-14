package com.bleedcode.projects.lovable_clone.service;

import com.bleedcode.projects.lovable_clone.dto.subscription.CheckoutRequest;
import com.bleedcode.projects.lovable_clone.dto.subscription.CheckoutResponse;
import com.bleedcode.projects.lovable_clone.dto.subscription.PortalResponse;
import com.bleedcode.projects.lovable_clone.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);
    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request,Long userId);
    PortalResponse  openCustomerPortal(Long userId);
}
