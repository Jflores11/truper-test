package com.truper.prueba.security;

import com.truper.prueba.TO.UserTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.security.Key;
import java.util.Date;

@Configuration
public class AuthService {

  @Value( "${security.jwt.expiration-minutes}" )
  private long EXPIRATION_MINUTES;

  @Value("${security.jwt.key}")
  private String SECURITY_JWT_KEY;

  public String generateToken(UserTO user) {
    Date now = new Date();
    Date expirationDate = new Date(now.getTime() + (EXPIRATION_MINUTES * 60000));

    return Jwts.builder()
      .setSubject(user.getUsername())
      .setIssuedAt(now)
      .setExpiration(expirationDate)
      .signWith(generateSecureKey())
      .compact();
  }

  public String getUsernameFromToken(String token) {
    return Jwts.parser()
      .setSigningKey(generateSecureKey())
      .build()
      .parseClaimsJws(token)
      .getBody()
      .getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(generateSecureKey()).build().parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private Key generateSecureKey() {
    return Keys.hmacShaKeyFor( Decoders.BASE64.decode( SECURITY_JWT_KEY ) );
  }

}