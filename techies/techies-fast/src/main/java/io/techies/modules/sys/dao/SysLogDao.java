/**
 * Copyright (c) 2016-2100 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.modules.sys.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.techies.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 *
 * @author Techies-RG
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
