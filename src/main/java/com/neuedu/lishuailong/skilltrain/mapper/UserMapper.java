package com.neuedu.lishuailong.skilltrain.mapper;

import com.neuedu.lishuailong.skilltrain.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.lishuailong.skilltrain.model.UserQuery;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-12
 */
public interface UserMapper extends BaseMapper<User> {

    List<UserQuery> getUserByPage(UserQuery query);
}
