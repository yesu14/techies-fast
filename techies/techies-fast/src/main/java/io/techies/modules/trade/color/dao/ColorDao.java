package io.techies.modules.trade.color.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.techies.modules.trade.color.entity.ColorEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 颜色表
 * 
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-29 00:29:01
 */
@Mapper
public interface ColorDao extends BaseMapper<ColorEntity> {
	
}
