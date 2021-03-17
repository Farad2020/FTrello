package com.faraby_lab.task3.restapivue.filters;

import com.faraby_lab.task3.restapivue.jwt.JWTTokenGenerator;
import com.faraby_lab.task3.restapivue.services.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTTokenGenerator jwtTokenGenerator;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authentication");

        String email = null;
        String jwtToken = null;

        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7);
            try{

                email = jwtTokenGenerator.getEmailFromToken(jwtToken);

            }catch (IllegalArgumentException e){

                System.out.println("Unable get JWT Token");

            }catch (ExpiredJwtException e){

                System.out.println("JWT Token expired");

            }
        }else {
            System.out.println("Header dont start with Bearer ");
        }

        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userService.loadUserByUsername(email);

            if(jwtTokenGenerator.validateToken(jwtToken, userDetails)){

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }

        filterChain.doFilter(request, response);
    }
}
