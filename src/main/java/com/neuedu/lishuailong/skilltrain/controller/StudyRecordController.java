package com.neuedu.lishuailong.skilltrain.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.lishuailong.skilltrain.model.StudyRecord;
import com.neuedu.lishuailong.skilltrain.model.StudyRecordQuery;
import com.neuedu.lishuailong.skilltrain.model.StudyRecordQueryList;
import com.neuedu.lishuailong.skilltrain.service.StudyRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 学习记录表 前端控制器
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-07
 */
@Api(tags = "学习记录控制器")
@CrossOrigin
@RestController
@RequestMapping("/study-record")
public class StudyRecordController {
    @Autowired
    private StudyRecordService studyRecordService;

    @PostMapping("/getStudyRecordByPage")
    @ApiOperation("分页查询学习记录")
    public StudyRecordQueryList getStudyRecordByPage(@RequestBody StudyRecordQuery query) {
        return studyRecordService.getStudyRecordByPage(query);
    }
}
