package io.techies.modules.trade.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.techies.common.utils.PageUtils;
import io.techies.modules.trade.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单表
 *
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-25 22:28:52
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

