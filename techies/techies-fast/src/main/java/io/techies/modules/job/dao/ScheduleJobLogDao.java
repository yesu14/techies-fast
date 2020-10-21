/**
 * Copyright (c) 2016-2100 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.modules.job.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.techies.modules.job.entity.ScheduleJobLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 * @author Techies-RG
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
	
}
