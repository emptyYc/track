package top.codx.core.exception;
/**
 * @program: fresh-master
 * @description: 生鲜系统异常码
 * @author: lch mailto:{yulwins@163.com}
 * @create: 2022-11-30 16:07
 **/
public enum TrackExceptionCode {


    UNKONWN_ERROR("999999"),

    // 100001-100100 系统异常编码
    ARGS_VALIDATION_ERROR("100001"),
    SERIALIZE_OBJECT_ERROR("100002"),
    NOT_LOGIN("100003"),
    IMPORTED_FILE_CONTENT_ERROR("100004"),
    IMPORT_LOCATION_CONNECT_ERROR("100005"),
    EXPORT_ERROR("100006"),

    NO_PERMISSION_ON_METHOD("100010"),

    GENERAL_MODEL_TYPE_NOT_EXISTED("100020"),
    GENERAL_MODEL_NOT_EXISTED("100021"),
    GENERAL_MODEL_ALREADY_EXISTED("100022"),

    ATTACHMENT_NOT_EXISTED("100100"),
    DATA_NOT_EXIT("100040"),





    ;

    private String code;
    private TrackExceptionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }



    /**
     *
     * @param msg
     * @return
     */
    public TrackRuntimeException runtimeException(String msg) {
        return new TrackRuntimeException(this.getCode(), msg);
    }


}
