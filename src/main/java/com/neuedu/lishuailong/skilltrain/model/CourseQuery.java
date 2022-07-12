package com.neuedu.lishuailong.skilltrain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CourseQuery extends Course{

    @ApiModelProperty("分页页码")
    private Integer no;
    @ApiModelProperty("分页大小")
    private Integer size;
}
