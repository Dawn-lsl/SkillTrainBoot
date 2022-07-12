package com.neuedu.lishuailong.skilltrain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 系部管理
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Department对象", description="系部管理")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "department_id", type = IdType.ID_WORKER)
    private Long departmentId;

    @ApiModelProperty(value = "上级部门id")
    @TableField("p_id")
    private Long pId;

    @ApiModelProperty(value = "名称")
    @TableField("department_name")
    private String departmentName;

    @ApiModelProperty(value = "编号")
    @TableField("department_number")
    private Integer departmentNumber;

    @ApiModelProperty(value = "排序")
    @TableField("department_sort")
    private Integer departmentSort;

    @ApiModelProperty(value = "负责人")
    @TableField("department_charge")
    private String departmentCharge;

    @ApiModelProperty(value = "联系电话")
    @TableField("department_mobile")
    private String departmentMobile;

    @ApiModelProperty(value = "邮箱")
    @TableField("department_mail")
    private String departmentMail;

    @ApiModelProperty(value = "部门状态")
    @TableField("department_status")
    private Integer departmentStatus;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建用户")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty(value = "最后更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "最后更新用户")
    @TableField("update_user")
    private String updateUser;


}
