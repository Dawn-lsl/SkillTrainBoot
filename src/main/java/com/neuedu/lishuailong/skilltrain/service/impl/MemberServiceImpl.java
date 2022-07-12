package com.neuedu.lishuailong.skilltrain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.lishuailong.skilltrain.mapper.MemberDao;
import com.neuedu.lishuailong.skilltrain.model.Member;
import com.neuedu.lishuailong.skilltrain.model.MemberQuery;
import com.neuedu.lishuailong.skilltrain.service.MemberService;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao, Member> implements MemberService {


    @Override
    public IPage<Member> getMemberByPage(MemberQuery query) {
        LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Member::getPhone,query.getPhone());
        wrapper.likeRight(Member::getName, query.getName());
        //创建page对象，要把当前页码和分页大小参数传进去
        IPage<Member> page = new Page<Member>(query.getNo(), query.getSize());
        //调用mybatis-plus的分页方法
        return this.page(page,wrapper);
    }
//
//    @Autowired
//    private MemberDao memberDao;
//
//    @Override
//    public Boolean saveMember(Member m){
//        return memberDao.saveMember(m);
//    }
//
//    @Override
//    public Member getMemberById(Long id) {
//        return memberDao.getMemberById(id);
//    }
//
//    @Override
//    public Boolean removeById(Long id) {
//        return memberDao.removeById(id);
//    }
//
//    @Override
//    public Boolean updateById(Member m) {
//        return memberDao.updateById(m);
//    }
}
