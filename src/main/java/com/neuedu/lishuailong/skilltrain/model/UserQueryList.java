package com.neuedu.lishuailong.skilltrain.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Accessors(chain = true)
public class UserQueryList {
    List<UserQuery> userQueryList;
    int total;
    Integer size;
    Integer current;
    Integer pages;
}
