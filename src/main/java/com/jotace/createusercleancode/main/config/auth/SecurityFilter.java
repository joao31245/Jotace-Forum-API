package com.jotace.createusercleancode.main.config.auth;

import com.jotace.createusercleancode.application.gateway.user.token.provider.TokenProvider;
import com.jotace.createusercleancode.infra.mapper.user.UserMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private final TokenProvider tokenProvider;
    private final UserMapper userMapper;

    public SecurityFilter(TokenProvider tokenProvider, UserMapper userMapper) {
        this.tokenProvider = tokenProvider;
        this.userMapper = userMapper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recoverToken(request);
        if(!token.isEmpty()) {
            var subject = tokenProvider.getSubject(token);

            var user = tokenProvider.findUserByLogin(subject);

            if (user != null) {
                var userEntity = userMapper.toEntity(user);

                var authentication = new UsernamePasswordAuthenticationToken(userEntity,null, userEntity.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }

        return "";
    }
}
