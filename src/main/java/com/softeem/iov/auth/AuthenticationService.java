package com.softeem.iov.auth;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService {
    /**
     * 从JWT令牌构建身份验证对象
     */
    public Authentication buildAuthenticationFromToken(String token) {
        String username = JwtUtil.getUsername(token);
        return new UsernamePasswordAuthenticationToken(username, null, null);
    }
    // 生成 JWT 令牌
    public String generateJwtToken(String username) {
        return JwtUtil.generateToken(username);
    }

    // 验证 JWT 令牌
    public Boolean validateJwtToken(String token) {
        if(token == null || token.equals("")){
            return false;
        }
        try {
            DecodedJWT decodedJWT = JwtUtil.decodeToken(token);
            if(decodedJWT!=null) {
                //判断token是否过期
                Date expiresAt = decodedJWT.getExpiresAt();
                if (expiresAt.before(new Date())) {
                    System.out.println("token过期");
                    return false;//过期
                } else {
                    return true;
                }
            }else{
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }
}
