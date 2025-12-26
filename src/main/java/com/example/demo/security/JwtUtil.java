package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private Key key;
    private final long expirationMillis = 3600000; 

   
    public void initKey() {
        if (this.key == null) {
            this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        }
    }

    
    public String generateTokenForUser(UserAccount user) {
        initKey();
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());

        return createToken(claims, user.getEmail());
    }

    
    public String generateToken(Map<String, Object> claims, String subject) {
        initKey();
        return createToken(claims, subject);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(key)
                .compact();
    }

   
    public boolean isTokenValid(String token, String email) {
        try {
            final String username = extractUsername(token);
            return (username.equals(email) && !isTokenExpired(token));
        } catch (JwtException e) {
            return false;
        }
    }

    
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

  
    public Long extractUserId(String token) {
        Number userId = (Number) extractAllClaims(token).get("userId");
        return userId != null ? userId.longValue() : null;
    }
 
    public String extractRole(String token) {
        return (String) extractAllClaims(token).get("role");
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

  
    public Jws<Claims> parseToken(String token) {
        initKey();
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }

    private Claims extractAllClaims(String token) {
        return parseToken(token).getBody();
    }
}