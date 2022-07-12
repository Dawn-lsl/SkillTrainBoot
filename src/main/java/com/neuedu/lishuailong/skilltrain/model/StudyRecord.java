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
 * 学习记录表
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StudyRecord对象", description="学习记录表")
public class StudyRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学习记录表主键")
    @TableId(value = "study_id", type = IdType.ID_WORKER)
    private Long studyId;

    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @ApiModelProperty(value = "章节ID")
    @TableField("chapter_id")
    private Long chapterId;

    @ApiModelProperty(value = "任务ID")
    @TableField("mission_id")
    private Long missionId;

    @ApiModelProperty(value = "资源ID（成果物资源ID）")
    @TableField("res_id")
    private Long resId;

    @ApiModelProperty(value = "资源名称（成果物名）")
    @TableField("res_name")
    private String resName;

    @ApiModelProperty(value = "资源路径（成果物路径）")
    @TableField("result_path")
    private String resultPath;

    @ApiModelProperty(value = "封面图片路径")
    @TableField("pic_path")
    private String picPath;

    @ApiModelProperty(value = "成果物描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "学习开始时间")
    @TableField("study_start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime studyStartTime;

    @ApiModelProperty(value = "学习结束在时间")
    @TableField("study_end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime studyEndTime;

    @ApiModelProperty(value = "学习状态（0.未完成/开始，1.已完成，2.超时完成）")
    @TableField("study_state")
    private Integer studyState;

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
