package com.neuedu.lishuailong.skilltrain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserQuery extends User{
    private String departmentName;
    @ApiModelProperty("分页页码")
    private Integer no;
    @ApiModelProperty("分页大小")
    private Integer size;
}
