package com.neuedu.lishuailong.skilltrain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.lishuailong.skilltrain.model.Course;
import com.neuedu.lishuailong.skilltrain.mapper.CourseMapper;
import com.neuedu.lishuailong.skilltrain.model.CourseQuery;
import com.neuedu.lishuailong.skilltrain.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Lishuailong
 * @create 2022-06-20 16:10:16
 * @describe 课程服务实现类
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>implements ICourseService {

    @Override
    public IPage<Course> getCourseByPage(CourseQuery query) {
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Course::getCourseName,query.getCourseName())
                .eq(query.getCourseType()!=null, Course::getCourseType, query.getCourseType())
                .eq(query.getCourseStatus()!=null, Course::getCourseStatus, query.getCourseStatus());
//                .eq(Course::getCourseType,query.getCourseType())
//                .eq(Course::getCourseStatus,query.getCourseStatus());
        //创建page对象，要把当前页码和分页大小参数传进去
        IPage<Course> page = new Page<Course>(query.getNo(), query.getSize());
        //调用mybatis-plus的分页方法
        return this.page(page,wrapper);
    }
}
