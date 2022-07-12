package com.neuedu.lishuailong.skilltrain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课时
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LessonPeriod对象", description="课时")
public class LessonPeriod implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "lesson_period_id", type = IdType.ID_WORKER)
    private Long lessonPeriodId;

    @ApiModelProperty(value = "章节id")
    @TableField("chapter_id")
    private Long chapterId;

    @ApiModelProperty(value = "名称")
    @TableField("lesson_period_name")
    private String lessonPeriodName;

    @ApiModelProperty(value = "状态(0:停用1:启用)")
    @TableField("lesson_period_status")
    private Integer lessonPeriodStatus;

    @ApiModelProperty(value = "排序")
    @TableField("lesson_period_sort")
    private Integer lessonPeriodSort;

    @ApiModelProperty(value = "描述")
    @TableField("chapter_introduce")
    private String chapterIntroduce;

    @ApiModelProperty(value = "创建时间")
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
