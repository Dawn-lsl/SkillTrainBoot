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
 * 章节
 * </p>
 *
 * @author lishuailong
 * @since 2022-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Chapter对象", description="章节")
public class Chapter implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "chapter_id", type = IdType.ID_WORKER)
    private Long chapterId;

    @ApiModelProperty(value = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @ApiModelProperty(value = "名称")
    @TableField("chapter_name")
    private String chapterName;

    @ApiModelProperty(value = "排序")
    @TableField("chapter_sort")
    private Integer chapterSort;

    @ApiModelProperty(value = "描述")
    @TableField("chapter_introduce")
    private String chapterIntroduce;

    @ApiModelProperty(value = "状态(0:停用1:启用)")
    @TableField("chapter_status")
    private Integer chapterStatus;

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
