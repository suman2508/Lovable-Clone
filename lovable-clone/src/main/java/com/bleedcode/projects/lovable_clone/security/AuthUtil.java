package com.bleedcode.projects.lovable_clone.security;



import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;

@Component
public class AuthUtil {

    @Value("${jwt.secret-key}")
    private String jwtSecretKey;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8 ));
    }

    public String generateAccessToken(User user){
        return Jwts;
    }

    public JwtUserPrincipal verifyAccessToken(String token){
        
            Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

            Long userId = Long.parseLong(claims.getSubject());
            String username = claims.get("username", String.class);

            Long userId = Long.parseLong(claims.get());
            return new JwtUserPrincipal(userId, username,new ArrayList<>());
    }

    public Long getCurrentUserId(){
        JwtUserPrincipal principal = (JwtUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getId();
    }   
    

}
