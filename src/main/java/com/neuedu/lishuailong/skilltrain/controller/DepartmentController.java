package com.neuedu.lishuailong.skilltrain.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.neuedu.lishuailong.skilltrain.model.Department;
import com.neuedu.lishuailong.skilltrain.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系部管理 前端控制器
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-12
 */
@Api(tags = "赛项控制器")
@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    @ApiOperation("保存赛项")
    public Boolean saveDepartment(@ApiParam("赛项类")@RequestBody Department department){
        return departmentService.save(department);
    }

    @GetMapping("/removeById")
    @ApiOperation("按ID移除赛项")
    public Boolean removeById(@ApiParam("赛项ID") @RequestParam("id") Long id){
        return departmentService.removeById(id);
    }

    @PostMapping("/updateById")
    @ApiOperation("按ID更新赛项")
    public Boolean updateById(@ApiParam("赛项类")@RequestBody Department department){
        return departmentService.updateById(department);
    }

    @PostMapping("/getDepartment")
    @ApiOperation("查询赛项")
    public List<Department> getDepartment(@ApiParam("赛项类")@RequestBody Department department){
        LambdaQueryWrapper<Department> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Department::getDepartmentName,department.getDepartmentName())
                .eq(department.getDepartmentStatus()!=null,Department::getDepartmentStatus,department.getDepartmentStatus());
        return departmentService.list(wrapper);
    }

}
