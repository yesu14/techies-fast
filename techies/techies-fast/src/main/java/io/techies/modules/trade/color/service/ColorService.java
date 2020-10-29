package io.techies.modules.trade.color.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.techies.common.utils.PageUtils;
import io.techies.modules.trade.color.entity.ColorEntity;

import java.util.Map;

/**
 * 颜色表
 *
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-29 00:29:01
 */
public interface ColorService extends IService<ColorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

