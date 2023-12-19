package com.lito.taller.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

public class TokenManager {

    private final static String ACCES_TOKEN_SECRET = "AbhTjkP98sSdff335rf656HredhgtfdGFg678";
    private final static int ACCES_TOKEN_VALIDATY_SECONDS = 86400;

    public static String createToken(String userName){
        long expirationTime = ACCES_TOKEN_VALIDATY_SECONDS *1000;
        Date expirationDate = new Date(System.currentTimeMillis());

        return Jwts.builder()
                .setSubject(userName)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String userName = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(userName, null, Collections.emptyList());
        } catch (JwtException e){
            return null;
        }
    }
}
