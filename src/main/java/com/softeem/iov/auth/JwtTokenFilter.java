package com.softeem.iov.auth;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softeem.iov.utils.ResponseData;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    private static final String SECRET = "tianbin"; // 替换为实际的密钥
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";

    private AuthenticationService authenticationService = new AuthenticationService();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = extractToken(request);
        if(request.getRequestURI().equals("/user/login")||request.getRequestURI().equals("/user/register")||request.getRequestURI().equals("/user/resetPwd")) {
            filterChain.doFilter(request, response);
        }else if(token!=null&&validateToken(token)){
            logger.info("token验证成功");
            Authentication auth = authenticationService.buildAuthenticationFromToken(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            filterChain.doFilter(request, response);
        }else{
            logger.info("token验证失败");
            writeErrorResponse(response, ResponseData.error(403, "Unauthorized token"));
        }
    }

    /**
     * 从请求中提取JWT令牌
     */
    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader(HEADER_STRING);
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            return header.replace(TOKEN_PREFIX, "");
        }
        return null;
    }

    /**
     * 验证JWT令牌的有效性
     */
    private boolean validateToken(String token) {
        try {
            Boolean result = authenticationService.validateJwtToken(token);
            if(result){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


    private void writeErrorResponse(HttpServletResponse response, ResponseData responseData) throws IOException {
        response.setStatus(responseData.getCode());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseData));
        response.getWriter().flush();
    }
}
