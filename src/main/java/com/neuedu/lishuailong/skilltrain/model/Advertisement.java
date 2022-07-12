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
 * 广告管理
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Advertisement对象", description="广告管理")
public class Advertisement implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "advertisement_id", type = IdType.ID_WORKER)
    private Long advertisementId;

    @ApiModelProperty(value = "标题")
    @TableField("advertisement_name")
    private String advertisementName;

    @ApiModelProperty(value = "编号")
    @TableField("advertisement_number")
    private Integer advertisementNumber;

    @ApiModelProperty(value = "排序")
    @TableField("advertisement_sort")
    private Integer advertisementSort;

    @ApiModelProperty(value = "图片")
    @TableField("pic")
    private String pic;

    @ApiModelProperty(value = "链接")
    @TableField("link")
    private String link;

    @ApiModelProperty(value = "记录创建时间")
    @TableField("create_time")
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
