package com.truper.prueba.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class JWTFilter extends OncePerRequestFilter {

  private final AuthService authService;

  public JWTFilter(AuthService authService) {
    this.authService = authService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
    String header = request.getHeader("Authorization");

    if (Objects.nonNull(header) && header.startsWith("Bearer ")) {
      String token = header.substring(7);
      if (authService.validateToken(token)) {
        String username = authService.getUsernameFromToken(token);
        UsernamePasswordAuthenticationToken authentication =
          new UsernamePasswordAuthenticationToken(username, null, List.of(new SimpleGrantedAuthority("USER")));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    filterChain.doFilter(request, response);
  }

}