package com.neuedu.lishuailong.skilltrain.service.impl;

import com.neuedu.lishuailong.skilltrain.model.User;
import com.neuedu.lishuailong.skilltrain.mapper.UserMapper;
import com.neuedu.lishuailong.skilltrain.model.UserQuery;
import com.neuedu.lishuailong.skilltrain.model.UserQueryList;
import com.neuedu.lishuailong.skilltrain.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;
    public UserServiceImpl(UserMapper userMapper) {this.userMapper = userMapper;}

    @Override
    public UserQueryList getUserByPage(UserQuery query){
        System.out.println(query.getState());
        Integer size = query.getSize();
        Integer no = query.getNo();
        if (null == no || 0 >= no || null == size || 0 >= size) return null;

        List<UserQuery> queryList = userMapper.getUserByPage(query);

        int count = queryList.size();
        int current = no;
        int pageSize = size;

        int rawPageSum = count / pageSize;
        int pageSum = count % pageSize == 0 ? rawPageSum : rawPageSum + 1;

        List<UserQuery> copy = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int start = (current - 1) * pageSize;
            int end = current * pageSize;

            if (i >= start && i < end)
                copy.add(queryList.get(i));
        }
        return new UserQueryList().setUserQueryList(copy).setPages(pageSum).setTotal(count).setSize(size).setCurrent(current);
    }
}
