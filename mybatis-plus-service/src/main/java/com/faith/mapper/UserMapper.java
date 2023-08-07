package com.faith.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faith.domain.Student;
import org.springframework.stereotype.Repository;

/**
 *@description:
 *@author:faith
 *@time:2023/5/3116:14
 */
//在对应的mapper上实现基本的接口
@Repository
public interface UserMapper extends BaseMapper<Student> {

}
