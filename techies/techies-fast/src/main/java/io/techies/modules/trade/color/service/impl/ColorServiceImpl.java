package io.techies.modules.trade.color.service.impl;

import io.techies.modules.trade.color.dao.ColorDao;
import io.techies.modules.trade.color.entity.ColorEntity;
import io.techies.modules.trade.color.service.ColorService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.techies.common.utils.PageUtils;
import io.techies.common.utils.Query;



@Service("colorService")
public class ColorServiceImpl extends ServiceImpl<ColorDao, ColorEntity> implements ColorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ColorEntity> page = this.page(
                new Query<ColorEntity>().getPage(params),
                new QueryWrapper<ColorEntity>()
        );

        return new PageUtils(page);
    }

}