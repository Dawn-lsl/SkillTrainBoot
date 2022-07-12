package com.neuedu.lishuailong.skilltrain.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neuedu.lishuailong.skilltrain.model.LessonMission;
import com.neuedu.lishuailong.skilltrain.service.LessonMissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 * 课程课时/任务表 前端控制器
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-08
 */
@Api(tags = "开发任务控制器")
@CrossOrigin
@RestController
@RequestMapping("/lesson-mission")
public class LessonMissionController {
    @Autowired
    private LessonMissionService lessonMissionService;

    @PostMapping("/saveLessonMission")
    @ApiOperation("保存开发任务")
    public Boolean saveLessonMission(@ApiParam("开发任务类")@RequestBody LessonMission lessonMission){
//        lessonMission.setStartTime(LocalDateTime.parse(lessonMission.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
//        System.out.println(lessonMission.getStartTime());
        return lessonMissionService.save(lessonMission);
    }

    @GetMapping("/removeById")
    @ApiOperation("按ID开发任务")
    public Boolean removeById(@ApiParam("开发任务ID")@RequestParam("id") Long id) { return lessonMissionService.removeById(id); }

    @PostMapping("/updateById")
    @ApiOperation("按ID更新开发任务")
    public Boolean updateById(@ApiParam("开发任务类") @RequestBody LessonMission lessonMission) { return lessonMissionService.updateById(lessonMission);}

    @PostMapping("/getLessonMission")
    @ApiOperation("查询开发任务")
    public List<LessonMission> getLessonMission(@ApiParam("章节ID")@RequestParam("id") Long id) {
        LambdaQueryWrapper<LessonMission> wrapper =  new LambdaQueryWrapper<>();
        wrapper.eq(LessonMission::getChapterId,id);
        return lessonMissionService.list(wrapper);
    }
}
