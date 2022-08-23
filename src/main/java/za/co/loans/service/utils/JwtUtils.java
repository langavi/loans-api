package za.co.loans.service.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtils {

    public static final Key JWT_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
}
