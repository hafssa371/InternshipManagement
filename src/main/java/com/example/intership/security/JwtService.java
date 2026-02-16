package com.example.intership.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET =
            "mySuperSecretKeymySuperSecretKeymySuperSecretKey";

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // 🔥 GENERATE TOKEN
    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24h
                .signWith(getSigningKey())
                .compact();
    }

    // 🔥 EXTRACT USERNAME
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 🔥 EXTRACT CLAIM GENERIC
    public <T> T extractClaim(String token,
                              Function<Claims, T> claimsResolver) {

        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claimsResolver.apply(claims);
    }

    // 🔥 VALIDATE TOKEN
    public boolean isTokenValid(String token,
                                UserDetails userDetails) {

        final String username = extractUsername(token);

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {

        Date expiration = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

        return expiration.before(new Date());
    }
}
