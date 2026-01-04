package com.bleedcode.projects.lovable_clone.security;

import java.io.IOException;
import java.security.Security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter{

    private final AuthUtil authUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain) throws ServletException {
        // TODO Auto-generated method stub
        log.info("Incoming request: {} {}", request.getMethod(), request.getRequestURI());

        final String requestHeaderToken = request.getHeader("Authorization");
        if(requestHeaderToken == null || !requestHeaderToken.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        String jwtToken = requestHeaderToken.split("Bearer ")[1].trim();
        
        JwtUserPrincipal user = authUtil.verifyAccessToken(jwtToken);

        if(user != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }   
    }

}
