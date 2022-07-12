package com.neuedu.lishuailong.skilltrain.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neuedu.lishuailong.skilltrain.model.LessonPeriod;
import com.neuedu.lishuailong.skilltrain.service.LessonPeriodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课时 前端控制器
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-08
 */
@Api(tags = "学习内容控制器")
@CrossOrigin
@RestController
@RequestMapping("/lesson-period")
public class LessonPeriodController {
    @Autowired
    private LessonPeriodService lessonPeriodService;

    @PostMapping("/saveLessonPeriod")
    @ApiOperation("保存学习内容")
    public Boolean saveLessonPeriod(@ApiParam("学习内容类")@RequestBody LessonPeriod lessonPeriod){ return lessonPeriodService.save(lessonPeriod); }

    @GetMapping("/removeById")
    @ApiOperation("按ID移除学习内容")
    public Boolean removeById(@ApiParam("学习内容类")@RequestParam("id") Long id) { return lessonPeriodService.removeById(id); }

    @PostMapping("/updateById")
    @ApiOperation("按ID更新学习内容")
    public Boolean updateById(@ApiParam("学习内容类") @RequestBody LessonPeriod lessonPeriod){return lessonPeriodService.updateById(lessonPeriod);}

    @PostMapping("/getLessonPeriod")
    @ApiOperation("查询学习内容")
    public List<LessonPeriod> getLessonPeriodByChapterId(@ApiParam("章节ID")@RequestParam("id") Long id){
        LambdaQueryWrapper<LessonPeriod> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LessonPeriod::getChapterId,id);
        return lessonPeriodService.list(wrapper);
    }
}

