package com.example.cinemabe.login;

import com.example.cinemabe.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils{

    @Value("${jwt.secret}")
    private static String secret = "secret";

    public static String generateToken(Authentication authentication) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, authentication.getName());
    }

    private static String doGenerateToken(Map<String, Object> claims, String subject) {
        claims.put("userName", subject); // Add the "username" claim to the map
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        return extractClaim(token, claims -> claims.get("userName", String.class));
    }

    public boolean validateToken(String token, User userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUserName()) && !isTokenExpired(token));
    }

    public static String extractUsername(String token) {
        return extractClaim(token, claims -> claims.get("userName", String.class));
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}