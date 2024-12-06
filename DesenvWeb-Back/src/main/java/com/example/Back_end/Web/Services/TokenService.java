package com.example.Back_end.Web.Services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.Back_end.Web.Entities.User.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {
    @Value("${api.security.token-secret}")
    private String secret;
    private final ExpirationGenerator expirationGenerator;

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("Back-end-Web")
                    .withSubject(user.getEmail())
                    .withClaim("id", user.getId())
                    .withClaim("role",user.getRole().getAuthority())
                    .withClaim("name",user.getNome())
                    .withClaim("cpf",user.getCpf())
                    .withClaim("email", user.getEmail())
                    .withExpiresAt(expirationGenerator.generateExpiraton())
                    .sign(algorithm);

        }
        catch (Exception e){
            return null;
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Back-end-Web")
                    .build()
                    .verify(token)
                    .getSubject();
        }
        catch (Exception e){
            return null;
        }
    }
}
