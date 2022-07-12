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
 * 课程课时/任务表
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LessonMission对象", description="课程课时/任务表")
public class LessonMission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务表主键")
    @TableId(value = "mission_id", type = IdType.ID_WORKER)
    private Long missionId;

    @ApiModelProperty(value = "任务标题")
    @TableField("mission_title")
    private String missionTitle;

    @ApiModelProperty(value = "任务类型（1.普通任务，2.竞赛任务）")
    @TableField("mission_type")
    private Integer missionType;

    @ApiModelProperty(value = "任务排序")
    @TableField("mission_order")
    private Integer missionOrder;

    @ApiModelProperty(value = "任务内容")
    @TableField("mission_content")
    private String missionContent;

    @ApiModelProperty(value = "作业时间，任务时限（单位：分）")
    @TableField("mission_limit")
    private Integer missionLimit;

    @ApiModelProperty(value = "任务开始时间")

    @TableField("start_time")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "任务状态（0.未启用，1.已启用）")
    @TableField("mission_state")
    private Integer missionState;

    @ApiModelProperty(value = "完成状态（0.开始/未完成，1.已完成，2.超时完成）;")
    @TableField("finish_state")
    private Integer finishState;

    @ApiModelProperty(value = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @ApiModelProperty(value = "章节ID")
    @TableField("chapter_id")
    private Long chapterId;

    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "分类（1.课时，2.任务）")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "创建人")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("update_user")
    private String updateUser;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
