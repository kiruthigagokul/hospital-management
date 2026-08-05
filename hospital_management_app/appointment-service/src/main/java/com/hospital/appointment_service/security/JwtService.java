package com.hospital.appointment_service.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;

import java.util.Date;



@Service
public class JwtService {


    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey123456";



    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );
    }



    public String extractUsername(String token) {


        return Jwts.parser()

                .verifyWith(getSigningKey())

                .build()

                .parseSignedClaims(token)

                .getPayload()

                .getSubject();

    }

}
