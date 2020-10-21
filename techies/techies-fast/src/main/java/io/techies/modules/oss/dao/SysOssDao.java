/**
 * Copyright (c) 2016-2100 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.modules.oss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.techies.modules.oss.entity.SysOssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 * @author Techies-RG
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
	
}
