package com.neuedu.lishuailong.skilltrain.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.lishuailong.skilltrain.model.Advertisement;
import com.neuedu.lishuailong.skilltrain.mapper.AdvertisementMapper;
import com.neuedu.lishuailong.skilltrain.model.AdvertisementQuery;
import com.neuedu.lishuailong.skilltrain.service.AdvertisementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告管理 服务实现类
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-06
 */
@Service
public class AdvertisementServiceImpl extends ServiceImpl<AdvertisementMapper, Advertisement> implements AdvertisementService {

    @Override
    public IPage<Advertisement> getAdvertisementByPage(AdvertisementQuery query) {
        //创建page对象，要把当前页码和分页大小参数传进去
        IPage<Advertisement> page = new Page<Advertisement>(query.getNo(), query.getSize());
        //调用mybatis-plus的分页方法
        return this.page(page);
    }
}
