package top.codx.core.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.RegisteredPayload;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import top.codx.core.exception.TrackException;

import java.util.Date;
import java.util.HashMap;

/**
 * jwt工具类
 *
 * @author jiejiebiezheyang
 * @author liuch
 * @since 2023-04-03 16:29
 */
public class JWTUtils {
    private JWTUtils() {
    }

    protected static final byte[] TOKEN_SIGNER = "what-little-team".getBytes();

    public static final JWTSigner SIGNER = JWTSignerUtil.hs256(TOKEN_SIGNER);

    /**
     * 创建token<br>
     * 根据用户id创建token
     *
     * @param key     {@link String}
     * @param value   {@link String}
     * @param seconds {@link Integer}
     * @return {@link String}
     */
    public static String createToken(String key, String value, int seconds) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("current", System.currentTimeMillis());

        DateTime now = DateTime.now();
        DateTime newTime = now.offsetNew(DateField.SECOND, seconds);

        return JWT.create()
                .setIssuedAt(now) // 签发时间
                .setExpiresAt(newTime) // 过期时间
                .setNotBefore(now) // 生效时间
                .setPayload("random", JWTUtil.createToken(map, TOKEN_SIGNER))
                .setPayload(key, value)
                .setSigner(SIGNER)
                .sign();
    }

    /**
     * 解析token<br>
     * 根据传入的key的获取值
     *
     * @param token {@link String}
     * @param key   {@link String}
     * @return {@link String}
     * @throw {@link RuntimeException}
     */
    public static String parseToken(String token, String key) throws TrackException {
        try {
            if (!JWTUtil.verify(token, SIGNER)) {
                throw new TrackException(40010, "token非法");
            }
        } catch (Exception e) {
            throw new TrackException(40010, "token非法");
        }
        JWT jwt = JWT.create().parse(token);
        JWTPayload payload = jwt.getPayload();
        // 获取当前时间
        long nowTime = new Date().getTime() / 1000;
        // 获取过期时间
        long exTime = Long.parseLong(payload.getClaim(RegisteredPayload.EXPIRES_AT).toString());
        if (exTime - nowTime <= 0) {
            throw new TrackException(40011, "token过期");
        }

        return (String) payload.getClaim(key);
    }
}
