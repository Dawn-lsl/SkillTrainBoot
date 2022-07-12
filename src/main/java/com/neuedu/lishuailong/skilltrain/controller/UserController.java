package com.neuedu.lishuailong.skilltrain.controller;


import com.neuedu.lishuailong.skilltrain.model.User;
import com.neuedu.lishuailong.skilltrain.model.UserQuery;
import com.neuedu.lishuailong.skilltrain.model.UserQueryList;
import com.neuedu.lishuailong.skilltrain.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-12
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    @ApiOperation("保存课程")
    public Boolean saveUser(@ApiParam("user类")@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/removeByIds")
    @ApiOperation("按ID批量移除User")
    public Boolean removeByIds(@ApiParam("userID")@RequestParam("ids") List<String> ids){
        return userService.removeByIds(ids);
    }

    @PostMapping("/updateById")
    @ApiOperation("按ID更新user")
    public Boolean updateById(@ApiParam("userID")@RequestBody User user){
        return userService.updateById(user);
    }

    @PostMapping("/getUserByPage")
    @ApiOperation("分页查询User")
    public UserQueryList getUserByPage(@RequestBody UserQuery query){
        return userService.getUserByPage(query);
    }
}
