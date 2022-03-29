package com.lcy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcy.entry.User;
import org.springframework.stereotype.Repository;

/**
 * @author liuweijin
 * @desc
 * @date 2021-12-21 15:10
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User selectByPrimaryKey();
}
