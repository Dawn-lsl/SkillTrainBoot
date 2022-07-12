package com.neuedu.lishuailong.skilltrain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.lishuailong.skilltrain.model.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.lishuailong.skilltrain.model.CourseQuery;

/**
 * @author Lishuailong
 * @create 2022-06-20 16:10:16
 * @describe 课程服务类
 */
public interface ICourseService extends IService<Course> {
    public IPage<Course> getCourseByPage(CourseQuery query);
}
