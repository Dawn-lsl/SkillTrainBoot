package com.neuedu.lishuailong.skilltrain.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neuedu.lishuailong.skilltrain.model.Chapter;
import com.neuedu.lishuailong.skilltrain.model.LessonPeriod;
import com.neuedu.lishuailong.skilltrain.service.ChapterService;
import com.neuedu.lishuailong.skilltrain.service.LessonPeriodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 章节 前端控制器
 * </p>
 *
 * @author lishuailong
 * @since 2022-06-21
 */
@Api(tags = "章节控制器")
@CrossOrigin
@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private LessonPeriodService lessonPeriodService;

    @PostMapping("/saveChapter")
    @ApiOperation("保存章节")
    public Boolean saveChapter(@ApiParam("章节类")@RequestBody Chapter chapter){ return chapterService.save(chapter); }

    @GetMapping("/removeById")
    @ApiOperation("按ID移除章节")
    public Boolean removeById(@ApiParam("章节ID")@RequestParam("id") Long id){
        LambdaQueryWrapper<LessonPeriod> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LessonPeriod::getChapterId,id);
        lessonPeriodService.remove(wrapper);
        return chapterService.removeById(id);
    }

    @PostMapping("/updateById")
    @ApiOperation("按ID更新章节")
    public Boolean updateById(@ApiParam("章节类") @RequestBody Chapter chapter){ return chapterService.updateById(chapter); }

    @PostMapping("/getChapter")
    @ApiOperation("查询章节")
    public List<Chapter> getChapter(@RequestParam("id") Long id){
        LambdaQueryWrapper<Chapter> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Chapter::getCourseId, id);
    //                .eq(Course::getCourseType,query.getCourseType())
        return chapterService.list(wrapper); }
}
