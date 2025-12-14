package com.bleedcode.projects.lovable_clone.dto.auth;

//record class helps to create immutable data carriers
public record AuthResponse( 
        String token, 
        UserProfileResponse user
    ) {

}
