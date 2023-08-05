//package com.nguyenngo.apigateway.util;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//
//@Component
//public class JwtUtil {
//    public static final String SECRET = "Ij1kMKJ45QGZhvMUSJjZUBSi5mg1nGFrUunz/KMC0tDZgdBx09eqrRfyHYGY/WUq";
//
//    public void validateToken(final String token) {
//        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
//    }
//
//    private Key getSignKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//}
