package top.codx.core.filter;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import top.codx.core.exception.TrackException;
import top.codx.core.result.Result;
import top.codx.core.util.JWTUtils;
import top.codx.core.util.RedisUtils;
import top.codx.db.entity.LoginUser;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token认证过滤器
 *
 * @author liuch
 * @since 2023-04-03 14:05
 */
@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        // 获取token
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token) || "/api/fresh/admin/auth/login".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        // 解析token,获取userId
        String userId = null;
        try {
            userId = JWTUtils.parseToken(token.substring(7), "userId");
        } catch (Exception e) {
            if (e instanceof TrackException) {
                response.getWriter().println(JSONUtil.toJsonStr(Result.failure(((TrackException) e).getCode(), e.getMessage())));
            } else {
                response.getWriter().println(JSONUtil.toJsonStr(Result.failure()));
            }
            return;
        }
        // 从redis中获取用户信息
        LoginUser loginUser = redisUtils.getBean("login:" + userId, LoginUser.class);
        if (loginUser == null || loginUser.getUser() == null) {
            response.getWriter().println(JSONUtil.toJsonStr(Result.failure(40012, "未登录")));
            return;
        }
        // 将用户信息存入SecurityContext
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
