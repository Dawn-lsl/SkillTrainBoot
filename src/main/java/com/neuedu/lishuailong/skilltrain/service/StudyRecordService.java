package com.neuedu.lishuailong.skilltrain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.lishuailong.skilltrain.model.StudyRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.lishuailong.skilltrain.model.StudyRecordQuery;
import com.neuedu.lishuailong.skilltrain.model.StudyRecordQueryList;

import java.util.List;

/**
 * <p>
 * 学习记录表 服务类
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-07
 */
public interface StudyRecordService extends IService<StudyRecord> {

    StudyRecordQueryList getStudyRecordByPage(StudyRecordQuery query);
}
