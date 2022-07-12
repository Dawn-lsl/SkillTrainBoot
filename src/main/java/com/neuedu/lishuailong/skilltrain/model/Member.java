package com.neuedu.lishuailong.skilltrain.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel("成员类")
@TableName("member")
public class Member{

    @ApiModelProperty("主键ID")
    @TableId(type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ExcelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty("名称")
    @TableField("name")
    @ExcelProperty(value = "名称")
    private String name;

    @ApiModelProperty("地址")
    @ExcelProperty(value = "地址")
    private String address;

    @ApiModelProperty("电话")
    @ExcelProperty(value = "电话")
    private String phone;

    @ApiModelProperty("性别(1.男,2.女)")
    @ExcelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty("创建人")
    @TableField("create_user")
    @ExcelIgnore
    private String createUser;

    @ApiModelProperty("创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    @ExcelIgnore
    private Date createTime;

    @ApiModelProperty("修改人")
    @TableField("update_user")
    @ExcelIgnore
    private String updateUser;

    @ApiModelProperty("修改日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    @ExcelIgnore
    private Date updateTime;
}