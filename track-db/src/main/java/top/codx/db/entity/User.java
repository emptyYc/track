package top.codx.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表;
 *
 * @author : liuch
 * @date : 2022-12-1
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "用户表", description = "用户表")
public class User implements Serializable {
    private static final long serialVersionUID = -5991016882034773319L;
    /**
     * 主键
     */
    @ApiModelProperty(name = "主键", notes = "主键")
    private String id;
    /**
     * 用户名
     */
    @NotBlank(message = "userCode[用户名]不能为空！")
    @ApiModelProperty(name = "用户名", notes = "用户名")
    private String userCode;
    /**
     * 用户实名
     */
    @NotBlank(message = "userName[用户实名]不能为空！")
    @ApiModelProperty(name = "用户实名", notes = "用户实名")
    private String userName;
    /**
     * 密码
     */
    @NotBlank(message = "userPasswd[密码]不能为空！")
    @ApiModelProperty(name = "密码", notes = "密码")
    private String userPasswd;
    /**
     * 用户性别
     */
    @NotBlank(message = "userSex[用户性别]不能为空！")
    @Range(min = 0, max = 1, message = "userSex[用户性别]只能时0(未知),1(男),2(女)")
    @ApiModelProperty(name = "用户性别", notes = "用户性别")
    private String userSex;
    /**
     * 角色ID
     */
    @NotBlank(message = "roleId[角色ID]不能为空！")
    @ApiModelProperty(name = "角色ID", notes = "角色ID")
    private String roleId;
    /**
     * 用户头像
     */
    @ApiModelProperty(name = "用户头像", notes = "用户头像")
    private String userAvatar;
    /**
     * 用户手机号
     */
    @NotBlank(message = "userPhone[用户手机号]不能为空！")
    @ApiModelProperty(name = "用户手机号", notes = "用户手机号")
    private String userPhone;
    /**
     * 用户邮箱
     */
    @Email(message = "请检查用户邮箱格式！")
    @ApiModelProperty(name = "用户邮箱", notes = "用户邮箱")
    private String userEmail;
    /**
     * 用户身份认证（0未认证，1已认证）
     */
    @ApiModelProperty(name = "用户身份认证（0未认证，1已认证）", notes = "用户身份认证（0未认证，1已认证）")
    private String userAutonym;
    /**
     * 用户地址
     */
    @ApiModelProperty(name = "用户地址", notes = "用户地址")
    private String userSite;
    /**
     * 用户出生日期
     */
    @NotNull(message = "userDateBirth[用户出生日期]不能为空！")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "用户出生日期", notes = "用户出生日期")
    private Date userDateBirth;
    /**
     * 绑定微信号
     */
    @ApiModelProperty(name = "绑定微信号", notes = "绑定微信号")
    private String wxOpenid;
    /**
     * 用户注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "用户注册时间", notes = "用户注册时间")
    private Date createdTime;
    /**
     * 创建人
     */
    @ApiModelProperty(name = "创建人", notes = "创建人")
    private String createdBy;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "更新时间", notes = "更新时间")
    private Date updatedTime;
    /**
     * 更新人
     */
    @ApiModelProperty(name = "更新人", notes = "更新人")
    private String updatedBy;
    /**
     * 是否删除（0否 1是）
     */
    @NotBlank(message = "isDel[是否删除] 不能为空!")
    @Range(min = 0, max = 1, message = "isDel[是否删除] 只能是（0否 1是）")
    @ApiModelProperty(name = "是否删除（0否 1是）", notes = "是否删除（0否 1是）")
    private String isDel;
    /**
     * 是否启用（0禁用 1启用）
     */
    @NotBlank(message = "isEnable[是否启用] 不能为空!")
    @Range(min = 0, max = 1, message = "isEnable[是否启用] 只能是（0禁用 1启用）")
    @ApiModelProperty(name = "是否启用（0禁用 1启用）", notes = "是否启用（0禁用 1启用）")
    private String isEnable;
    /**
     * 用户个性签名
     */
    @ApiModelProperty(name = "用户个性签名", notes = "用户个性签名")
    private String userSignature;

}