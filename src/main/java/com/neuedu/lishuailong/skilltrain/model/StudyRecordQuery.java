package com.neuedu.lishuailong.skilltrain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudyRecordQuery extends StudyRecord{
    private String realName;
    private String courseName;
    private String chapterName;
    private String missionTitle;

    @ApiModelProperty("分页页码")
    private Integer no;
    @ApiModelProperty("分页大小")
    private Integer size;
}
