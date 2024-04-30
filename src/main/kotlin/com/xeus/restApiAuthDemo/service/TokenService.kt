package com.xeus.restApiAuthDemo.service

import com.xeus.restApiAuthDemo.config.JwtProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.Date

@Service
class TokenService (
    jwtProperties: JwtProperties
){

    private val secretKey = Jwts.SIG.HS256.key().build();

    fun generate(
        userDetails: UserDetails,
        expirationDate: Date,
        additionalClaims: Map<String, Any> = emptyMap()
    ): String = Jwts.builder()
        .claims()
        .subject(userDetails.username)
        .issuedAt(Date(System.currentTimeMillis()))
        .expiration(expirationDate)
        .add(additionalClaims)
        .and()
        .signWith(secretKey)
        .compact()

    fun extractEmail(token: String): String? = getAllClaims(token).subject

    fun isExpired(token: String): Boolean = getAllClaims(token).expiration
        .before(Date(System.currentTimeMillis()))

    fun isTokenValid(token: String, userDetails: UserDetails): Boolean {
        val email = extractEmail(token)

        return  userDetails.username == email && !isExpired(token)
    }

    private fun getAllClaims(token: String): Claims {
        val parser = Jwts.parser()
            .verifyWith(secretKey)
            .build()

        return  parser.parseSignedClaims(token)
            .payload
    }
}