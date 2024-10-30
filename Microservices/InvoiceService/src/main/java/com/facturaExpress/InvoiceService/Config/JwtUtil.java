package com.facturaExpress.InvoiceService.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.jsonwebtoken.Jwts.*;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "a3c23b0f8b4f2c99f6e6b1e6f9f4b6a5c1c5a3d2c1e0f4b9e8c2d5e1b0f3a6e";
    private long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora

    public String generateToken(String username, Long userId) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username, userId);
    }

    private String createToken(Map<String, Object> claims, String subject, Long userId) {
        claims.put("userId", userId);
        return builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}