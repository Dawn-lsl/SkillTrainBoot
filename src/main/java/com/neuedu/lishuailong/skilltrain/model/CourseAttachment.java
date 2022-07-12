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
 * 
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CourseAttachment对象", description="")
public class CourseAttachment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "附件主键")
    @TableId(value = "attachment_id", type = IdType.ID_WORKER)
    private Long attachmentId;

    @ApiModelProperty(value = "课程ID")
    @TableField("course_id")
    private Long courseId;

    @ApiModelProperty(value = "资源ID")
    @TableField("res_task_id")
    private Long resTaskId;

    @ApiModelProperty(value = "资源名称")
    @TableField("res_name")
    private String resName;

    @ApiModelProperty(value = "资源地址")
    @TableField("res_path")
    private String resPath;

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
