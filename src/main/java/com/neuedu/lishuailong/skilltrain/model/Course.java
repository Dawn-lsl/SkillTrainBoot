package com.neuedu.lishuailong.skilltrain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Lishuailong
 * @create 2022-06-20 16:10:16
 * @describe 课程实体类
 */
@TableName("course")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "Course对象", description = "课程")
public class Course implements Serializable{

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "课程ID")
    @TableId(value = "course_id", type = IdType.ID_WORKER)
    private Long courseId;

    @ApiModelProperty(value = "课程名称")
    @TableField("course_name")
    private String courseName;

    @ApiModelProperty(value = "课程封面")
    @TableField("course_cover")
    private String courseCover;

    @ApiModelProperty(value = "课程介绍")
    @TableField("course_introduce")
    private String courseIntroduce;

    @ApiModelProperty(value = "类型（1普通课程2实训课程）")
    @TableField("course_type")
    private Integer courseType;

    @ApiModelProperty(value = "排序")
    @TableField("course_sort")
    private Integer courseSort;

    @ApiModelProperty(value = "状态(0:停用1:启用)")
    @TableField("course_status")
    private Integer courseStatus;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "创建用户")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty(value = "最后更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty(value = "最后更新用户")
    @TableField("update_user")
    private String updateUser;

                    
    public Long getCourseId(){
            return courseId;
            }

    public Course setCourseId(Long courseId){
        this.courseId = courseId;
        return this;
    }
                    
    public String getCourseName(){
            return courseName;
            }

    public Course setCourseName(String courseName){
        this.courseName = courseName;
            return this;
    }
                    
    public String getCourseCover(){
            return courseCover;
            }

    public Course setCourseCover(String courseCover){
        this.courseCover = courseCover;
        return this;
    }
                    
    public String getCourseIntroduce(){
            return courseIntroduce;
            }

    public Course setCourseIntroduce(String courseIntroduce){
        this.courseIntroduce = courseIntroduce;
        return this;
    }
                    
    public Integer getCourseType(){
            return courseType;
            }

    public Course setCourseType(Integer courseType){
        this.courseType = courseType;
        return this;
    }
                    
    public Integer getCourseSort(){
            return courseSort;
            }

    public Course setCourseSort(Integer courseSort){
        this.courseSort = courseSort;
        return this;
    }
                    
    public Integer getCourseStatus(){
            return courseStatus;
            }

    public Course setCourseStatus(Integer courseStatus){
        this.courseStatus = courseStatus;
        return this;
    }
                    
    public Date getCreateTime(){
            return createTime;
            }

    public Course setCreateTime(Date createTime){
        this.createTime = createTime;
        return this;
    }
                    
    public String getCreateUser(){
            return createUser;
            }

    public Course setCreateUser(String createUser){
        this.createUser = createUser;
        return this;
    }
                    
    public Date getUpdateTime(){
            return updateTime;
            }

    public Course setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
        return this;
    }
                    
    public String getUpdateUser(){
            return updateUser;
            }

    public Course setUpdateUser(String updateUser){
        this.updateUser = updateUser;
        return this;
    }
    
@Override
public String toString() {
        return "Course{" +
                            "courseId=" + courseId +
                                    ", courseName=" + courseName +
                                    ", courseCover=" + courseCover +
                                    ", courseIntroduce=" + courseIntroduce +
                                    ", courseType=" + courseType +
                                    ", courseSort=" + courseSort +
                                    ", courseStatus=" + courseStatus +
                                    ", createTime=" + createTime +
                                    ", createUser=" + createUser +
                                    ", updateTime=" + updateTime +
                                    ", updateUser=" + updateUser +
                    "}";
        }
        }