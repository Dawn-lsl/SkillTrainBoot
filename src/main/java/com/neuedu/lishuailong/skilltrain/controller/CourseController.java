package com.neuedu.lishuailong.skilltrain.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.lishuailong.skilltrain.model.Course;
import com.neuedu.lishuailong.skilltrain.model.CourseQuery;
import com.neuedu.lishuailong.skilltrain.service.ICourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lishuailong
 * @create 2022-06-20 16:10:16
 * @describe 课程前端控制器
 */
@Api(tags = "课程控制器")

@CrossOrigin(originPatterns = "*",allowCredentials="true",allowedHeaders = "*",methods = {})
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping("/saveCourse")
    @ApiOperation("保存课程")
    public Boolean saveCourse(@ApiParam("课程类")@RequestBody Course course){
            return courseService.save(course);
    }

    @GetMapping("/removeById")
    @ApiOperation("按ID移除课程")
    public Boolean removeById( @ApiParam("课程ID") @RequestParam("id") Long id){ return courseService.removeById(id); }

    @GetMapping("/removeByIds")
    @ApiOperation("按ID批量移除课程")
    public Boolean removeByIds( @ApiParam("课程ID") @RequestParam("ids") List<Long> ids){ return courseService.removeByIds(ids); }

    @PostMapping("/updateById")
    @ApiOperation("按ID更新课程")
    public Boolean updateById(@ApiParam("课程类") @RequestBody Course course){ return courseService.updateById(course);}

    @PostMapping("/getCourseByPage")
    @ApiOperation("分页查询课程")
    public IPage<Course> getCourseByPage(@RequestBody CourseQuery query) {
        return courseService.getCourseByPage(query);
    }

    @PostMapping("/getCourseById")
    @ApiOperation("按ID查询课程")
    public Course getCourseById(@RequestParam("id") Long id) { return courseService.getById(id); }
}

