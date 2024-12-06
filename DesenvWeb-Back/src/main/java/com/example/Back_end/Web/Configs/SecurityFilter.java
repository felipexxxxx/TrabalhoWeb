package com.example.Back_end.Web.Configs;

import com.example.Back_end.Web.Entities.User.User;
import com.example.Back_end.Web.Repositories.UserRepository;
import com.example.Back_end.Web.Services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = this.recoverToken(request);
            System.out.println("Token recebido: " + token); // Debug

            if(token != null){
                String login = tokenService.validateToken(token);
                System.out.println("Login extraído do token: " + login); // Debug

                if(login != null){
                    User user = userRepository.findByEmail(login);
                    System.out.println("Usuário encontrado: " + (user != null ? user.getEmail() : "null")); // Debug
                    
                    if(user != null && user.getRole() != null) {
                        System.out.println("Role do usuário: " + user.getRole().name()); // Debug
                        
                        var authorities = Collections.singletonList(
                            new SimpleGrantedAuthority(user.getRole().name())
                        );
                        
                        var authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        
                        System.out.println("Autenticação configurada com sucesso");
                        System.out.println("Authorities: " + authorities);
                    }
                }
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("Erro no SecurityFilter: " + e.getMessage());
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private String recoverToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        System.out.println("Authorization header: " + authHeader); // Debug
        if(authHeader == null || authHeader.isEmpty() || !authHeader.startsWith("Bearer ")) return null;
        return authHeader.substring(7);
    }
}