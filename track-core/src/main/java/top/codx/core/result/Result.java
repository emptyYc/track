package top.codx.core.result;


import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用返回结果格式
 *
 * @author Ray。
 * Date: 2018-06-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "返回体")
public class Result implements Serializable {
    private static final long serialVersionUID = 874200365941306385L;

    private Integer code;

    private String msg;

    private Object data;


    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Result setmsg(String msg) {
        this.msg = msg;
        return this;
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static Result failure(String msg) {
        Result result = new Result();
        result.setCode(ResultCode.PARAM_IS_INVALID.code());
        result.setmsg(msg);
        return result;
    }

    public static Result failure() {
        Result result = new Result();
        result.setCode(500);
        result.setmsg("未知异常！");
        return result;
    }

    public static Result failure(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setmsg(msg);
        return result;
    }

    private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.msg();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static Result badArgument() {
        return failure(401, "参数不对");
    }

    public static Result badArgumentValue() {
        return failure(402, "参数值不对");
    }

    public static Result unlogin() {
        return failure(501, "请登录");
    }

    public static Result serious(Object data) {
        return failure(502, "系统内部错误:::" + data);
    }

    public static Result unsupport() {
        return failure(503, "业务不支持");
    }

    public static Result updatedDateExpired() {
        return failure(504, "更新数据已经失效");
    }

    public static Result updatedDataFailed() {
        return failure(505, "更新数据失败");
    }

    public static Result unauthz() {
        return failure(506, "无操作权限");
    }
}
