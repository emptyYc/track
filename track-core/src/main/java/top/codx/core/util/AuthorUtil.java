package top.codx.core.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import top.codx.db.entity.LoginUser;

/**
 * 登录用户信息
 *
 * @author lch mailto:{yulwins@163.com}
 * @since 2023-04-28 10:31
 */
public class AuthorUtil {
    /**
     * 获取当前用户名称
     *
     * @return {@link String}
     */
    public static String getUserCode() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        } else {
            return "anonymousUser";
        }
    }

    /**
     * 获取当前用户
     *
     * @return {@link LoginUser}
     */
    public static LoginUser getUserContext() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return (LoginUser) authentication.getPrincipal();
    }

}

