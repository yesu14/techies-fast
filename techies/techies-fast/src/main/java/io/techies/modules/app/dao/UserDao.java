/**
 * Copyright (c) 2016-2100 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.techies.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Techies-RG
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
