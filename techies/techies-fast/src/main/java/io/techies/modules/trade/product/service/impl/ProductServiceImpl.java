package io.techies.modules.trade.product.service.impl;

import io.techies.modules.trade.product.dao.ProductDao;
import io.techies.modules.trade.product.entity.ProductEntity;
import io.techies.modules.trade.product.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.techies.common.utils.PageUtils;
import io.techies.common.utils.Query;



@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, ProductEntity> implements ProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductEntity> page = this.page(
                new Query<ProductEntity>().getPage(params),
                new QueryWrapper<ProductEntity>()
        );

        return new PageUtils(page);
    }

}