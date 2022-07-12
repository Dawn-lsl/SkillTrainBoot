package com.neuedu.lishuailong.skilltrain.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.lishuailong.skilltrain.model.StudyRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.lishuailong.skilltrain.model.StudyRecordQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 学习记录表 Mapper 接口
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-07
 */
@Mapper
public interface StudyRecordMapper extends BaseMapper<StudyRecord> {
    List<StudyRecordQuery> getStudyRecordByPage(StudyRecordQuery query);
}
