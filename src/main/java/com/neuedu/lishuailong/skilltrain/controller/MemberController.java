package com.neuedu.lishuailong.skilltrain.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.lishuailong.skilltrain.model.Member;
import com.neuedu.lishuailong.skilltrain.model.MemberQuery;
import com.neuedu.lishuailong.skilltrain.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "成员控制器")
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/saveMember")
    @ApiOperation("保存成员")
    public Boolean saveMember(@ApiParam("成员类")@RequestBody Member m){
//        return memberService.saveMember(m);
        return memberService.save(m);
    }

    @GetMapping("/getMemberById")
    @ApiOperation("按ID查询成员")
    public Member getMemberById(@ApiParam("主键ID") @RequestParam("id") Long id){
//        return memberService.getMemberById(id);
        return memberService.getById(id);
    }

    @GetMapping("/removeById")
    @ApiOperation("按ID移除成员")
    public Boolean removeById(@ApiParam("主键ID") @RequestParam("id") Long id){
        return memberService.removeById(id);
    }

    @PostMapping("/updateById")
    @ApiOperation("按ID更新成员")
    public Boolean updateById(@ApiParam("成员类") @RequestBody Member m){
        return memberService.updateById(m);
    }

    @PostMapping("/getMemberByPage")
    @ApiOperation("分页查询成员")
    public IPage<Member> getMemberByPage(@RequestBody MemberQuery query){
        return memberService.getMemberByPage(query);
    }
}
