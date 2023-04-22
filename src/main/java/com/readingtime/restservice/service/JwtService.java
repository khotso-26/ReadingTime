package com.readingtime.restservice.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {



    public String extractUsername(String jwtToken);

    Key getSignInKey();

    public String generateToken(UserDetails userDetails);

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    public String generateRefreshToken(UserDetails userDetails);

    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver);

    public Claims extractAllClaims(String jwtToken);

    public boolean isTokenValid(String token, UserDetails userdetails);

    public boolean isTokenExpired(String jwtToken);

    public Date extractExpiration(String jwtToken);

}
