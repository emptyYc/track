package top.codx.core.handler;

import cn.hutool.json.JSONUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import top.codx.core.result.Result;
import top.codx.core.result.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证异常处理器
 *
 * @author jiejiebiezheyang
 * @since 2023-04-03 22:36
 */
@Component
public class AuthExceptionHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // 处理异常,返回错误信息
        Result err = Result.failure(ResultCode.USER_NOT_LOGGED_IN, authException.getMessage());
        String json = JSONUtil.toJsonStr(err);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(json);
    }
}
