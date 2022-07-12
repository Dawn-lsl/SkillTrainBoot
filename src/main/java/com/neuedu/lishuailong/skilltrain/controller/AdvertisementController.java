package com.neuedu.lishuailong.skilltrain.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.lishuailong.skilltrain.model.Advertisement;
import com.neuedu.lishuailong.skilltrain.model.AdvertisementQuery;
import com.neuedu.lishuailong.skilltrain.service.AdvertisementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 广告管理 前端控制器
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-06
 */
@Api(tags = "信息控制器")
@CrossOrigin
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping("/getAdvertisementByPage")
    @ApiOperation("分页查询信息")
    public IPage<Advertisement> getAdvertisementByPage(@RequestBody AdvertisementQuery query){
        return advertisementService.getAdvertisementByPage(query);
    }

    @GetMapping("/removeByIds")
    @ApiOperation("按ID批量移除信息")
    public Boolean removeByIds( @ApiParam("信息ID") @RequestParam("ids") List<Long> ids){
        return advertisementService.removeByIds(ids);
    }

    @PostMapping("/saveAdvertisement")
    @ApiOperation("保存信息")
    public Boolean saveAdvertisement( @ApiParam("信息类")@RequestBody Advertisement advertisement){
        return advertisementService.save(advertisement);
    }

    @PostMapping("/updateById")
    @ApiOperation("按ID更新信息")
    public Boolean updateById(@ApiParam("信息类") @RequestBody Advertisement advertisement){
        return advertisementService.updateById(advertisement);
    }
}
