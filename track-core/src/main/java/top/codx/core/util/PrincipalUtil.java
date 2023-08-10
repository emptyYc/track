package top.codx.core.util;

import cn.hutool.core.text.CharSequenceUtil;

import java.util.regex.Pattern;

/**
 * 正则表达式工具
 *
 * @author lch mailto:{yulwins@163.com}
 * @since 2023-04-28 10:31
 */
public class PrincipalUtil {
    public PrincipalUtil() {
    }

    /**
     * 字段名，数字字母下划线
     */
    public static final String FIELD_REGEXP = "([a-zA-Z0-9_]+)";


    /**
     * 是否符合字段规则
     *
     * @param value 输入值
     * @return 匹配结果
     */
    public static boolean isField(String value) {
        return !isMatching(FIELD_REGEXP, value);
    }


    public static boolean isMatching(String regexp, String value) {
        if (CharSequenceUtil.isBlank(value)) {
            return false;
        }
        return Pattern.matches(regexp, value);
    }

}
