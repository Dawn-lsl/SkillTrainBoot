package com.neuedu.lishuailong.skilltrain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.lishuailong.skilltrain.model.Member;
import com.neuedu.lishuailong.skilltrain.model.MemberQuery;
import org.apache.ibatis.annotations.Param;

public interface MemberService extends IService<Member> {

    public IPage<Member> getMemberByPage(MemberQuery query);

//    public Boolean saveMember(Member m);
//    public Member getMemberById(Long id);
//    public Boolean removeById(Long id);
//    public Boolean updateById(Member m);
}
