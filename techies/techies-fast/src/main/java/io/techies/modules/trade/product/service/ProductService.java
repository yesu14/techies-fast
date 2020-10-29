package io.techies.modules.trade.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.techies.common.utils.PageUtils;
import io.techies.modules.trade.product.entity.ProductEntity;

import java.util.Map;

/**
 * 产品库
 *
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-29 00:34:41
 */
public interface ProductService extends IService<ProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

