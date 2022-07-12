package com.neuedu.lishuailong.skilltrain.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "user_id", type = IdType.ID_WORKER)
    @ExcelIgnore
    private Long userId;

    @ApiModelProperty(value = "编号")
    @TableField("user_number")
    @ExcelProperty(value = "userNumber")
    private Integer userNumber;

    @ApiModelProperty(value = "类型(1学生 2教师 3超级管理员)")
    @TableField("type_id")
    @ExcelProperty(value = "typeId")
    private Integer typeId;

    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    @ExcelProperty(value = "userName")
    private String userName;

    @ApiModelProperty(value = "所属系部")
    @TableField("department_id")
    @ExcelProperty(value = "departmentId")
    private Long departmentId;

    @ApiModelProperty(value = "真实姓名")
    @TableField("real_name")
    @ExcelProperty(value = "realName")
    private String realName;

    @ApiModelProperty(value = "昵称")
    @TableField("nick_name")
    @ExcelProperty(value = "nickName")
    private String nickName;

    @ExcelProperty(value = "password")
    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "手机号")
    @TableField("mobile")
    @ExcelProperty(value = "mobile")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    @ExcelProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "性别（1男2女）")
    @TableField("sex")
    @ExcelProperty(value = "sex")
    private Integer sex;

    @ApiModelProperty(value = "状态（0停用1正常）")
    @TableField("state")
    @ExcelProperty(value = "state")
    private Integer state;

    @ApiModelProperty(value = "备注")
    @TableField("description")
    @ExcelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty(value = "岗位")
    @TableField("station")
    @ExcelProperty(value = "station")
    private String station;

    @ApiModelProperty(value = "记录创建时间")
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "记录创建用户")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty(value = "最后更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "最后更新用户")
    @TableField("update_user")
    private String updateUser;


}
