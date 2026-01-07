package com.bleedcode.projects.lovable_clone.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
//import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String email;
    String passwordHash;
    String name;

    String avatarUrl;

    // Can use Instant instead of LocalDateTime if needed
    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;

    LocalDateTime deletedAt; //soft delete
}

//public class User implements UserDetails {
//
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//
//    String username;
//    String password;
//    String name;
//
//    // Can use Instant instead of LocalDateTime if needed
//    @CreationTimestamp
//    LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    LocalDateTime updatedAt;
//
//    LocalDateTime deletedAt; //soft delete
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // TODO Auto-generated method stub
//        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
//    }
//}
