package com.neuedu.lishuailong.skilltrain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.neuedu.lishuailong.skilltrain.model.StudyRecord;
import com.neuedu.lishuailong.skilltrain.mapper.StudyRecordMapper;
import com.neuedu.lishuailong.skilltrain.model.StudyRecordQuery;
import com.neuedu.lishuailong.skilltrain.model.StudyRecordQueryList;
import com.neuedu.lishuailong.skilltrain.service.StudyRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 学习记录表 服务实现类
 * </p>
 *
 * @author lishuailong
 * @since 2022-07-07
 */
@Service
public class StudyRecordServiceImpl extends ServiceImpl<StudyRecordMapper, StudyRecord> implements StudyRecordService {
    private final StudyRecordMapper studyRecordMapper;
    public StudyRecordServiceImpl(StudyRecordMapper studyRecordMapper) {
        this.studyRecordMapper = studyRecordMapper;
    }

    @Override
    public StudyRecordQueryList getStudyRecordByPage(StudyRecordQuery query) {
        Integer size = query.getSize();
        Integer no = query.getNo();
        if (null == no || 0 >= no || null == size || 0 >= size) return null;

        List<StudyRecordQuery> studyRecordByPage = studyRecordMapper.getStudyRecordByPage(query);

        int count = studyRecordByPage.size();
        int current = no;
        int pageSize = size;

        int rawPageSum = count / pageSize;
        int pageSum = count % pageSize == 0 ? rawPageSum : rawPageSum + 1;

        List<StudyRecordQuery> copy = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int start = (current - 1) * pageSize;
            int end = current * pageSize;

            if (i >= start && i < end)
                copy.add(studyRecordByPage.get(i));
        }



        return new StudyRecordQueryList().setStudyRecordQueryList(copy).setPages(pageSum).setTotal(count).setSize(size).setCurrent(current);
    }
}
