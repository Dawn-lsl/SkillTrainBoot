package com.neuedu.lishuailong.skilltrain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.lishuailong.skilltrain.model.Advertisement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.lishuailong.skilltrain.model.AdvertisementQuery;

/**
 * <p>
 * 广告管理 服务类
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-06
 */
public interface AdvertisementService extends IService<Advertisement> {

    public IPage<Advertisement> getAdvertisementByPage(AdvertisementQuery query);
}
