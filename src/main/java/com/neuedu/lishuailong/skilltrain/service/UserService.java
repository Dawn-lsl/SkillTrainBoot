package com.neuedu.lishuailong.skilltrain.service;

import com.neuedu.lishuailong.skilltrain.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.lishuailong.skilltrain.model.UserQuery;
import com.neuedu.lishuailong.skilltrain.model.UserQueryList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-12
 */
public interface UserService extends IService<User> {
    UserQueryList getUserByPage(UserQuery query);
}
