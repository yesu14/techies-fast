package io.techies.modules.trade.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.techies.modules.trade.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表
 * 
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-25 22:28:52
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
