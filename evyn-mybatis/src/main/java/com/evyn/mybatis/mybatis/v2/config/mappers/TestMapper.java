package com.evyn.mybatis.mybatis.v2.config.mappers;

import com.evyn.mybatis.mybatis.v2.beans.LTest;;

/**
 * @ClassName TestMapper
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 10:15
 * @Version 1.0
 */
public interface TestMapper {
    LTest selectByPrimaryKey(Integer userid);
}
