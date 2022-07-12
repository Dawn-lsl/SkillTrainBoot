package com.neuedu.lishuailong.skilltrain.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Accessors(chain = true)
public class StudyRecordQueryList {


    List<StudyRecordQuery> studyRecordQueryList;

    //  "total": 9,
    //  "size": 2,
    //  "current": 2,
    //  "searchCount": true,
    //  "pages": 5
    int total;
    Integer size;
    Integer current;
    Integer pages;
}
