package com.softeem.iov.auth;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.softeem.iov.entity.User;

import java.util.Date;


public class JwtUtil {
    private static final String SECRET_KEY = "tianbin"; // 请替换为您自己的密钥
    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);
    private static final long EXPIRE_TIME = 3600000*24; // token过期时间24h
    // 生成token
    public static String generateToken(User user) {
        Date expiryDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("userId", user.getId())
                .withExpiresAt(expiryDate)
                .sign(ALGORITHM);
    }

    // 从token中获取用户名
    public static String getUsername(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getSubject();
    }

    public static User getUser(String token) {
        DecodedJWT jwt = JWT.decode(token);
        User user = new User();
        user.setUsername(jwt.getSubject());
        return user;
    }

    public static Integer getUserId(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("userId").asInt();
    }

    public String getUsernameFromToken(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getSubject();
    }

    // 解码token
    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC512(SECRET_KEY)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 解码token
public static DecodedJWT decodeToken(String token) {
        try {
            return JWT.require(ALGORITHM).build().verify(token);
        } catch (Exception e) {
            return null;
        }
    }

}

