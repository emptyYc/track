package top.codx.core.constant;

/**
 * fresh-master
 * @description: 系统常量类
 * @author : lch mailTo:{yulwins@163.com}
 * @since : 2022-11-25 10:53
 **/
public interface SysConstant {
    /**
     * 后台管理url前缀
     */
    String SYSTEM_ADMIN_API_URL_PREFIX = "/api/fresh/admin/";
    /**
     * 小程序端url前缀
     */
    String SYSTEM_WX_API_URL_PREFIX = "/api/fresh/wx/";

    /**
     * 上传
     */
    String ATTACHMENT_URL_PREFIX = "/api/fresh/attachment/";

    /**
     * 50兆
     */
    int FILE_MAX_SIZE = 50 * 1024 * 1024;
}
