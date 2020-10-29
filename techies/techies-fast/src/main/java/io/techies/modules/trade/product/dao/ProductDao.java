package io.techies.modules.trade.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.techies.modules.trade.product.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品库
 * 
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-29 00:34:41
 */
@Mapper
public interface ProductDao extends BaseMapper<ProductEntity> {
	
}
