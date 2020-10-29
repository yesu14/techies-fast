package io.techies.modules.trade.color.controller;

import java.util.Arrays;
import java.util.Map;

import io.techies.modules.trade.color.entity.ColorEntity;
import io.techies.modules.trade.color.service.ColorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.techies.common.utils.PageUtils;
import io.techies.common.utils.R;



/**
 * 颜色表
 *
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-29 00:29:01
 */
@RestController
@RequestMapping("trade/color")
public class ColorController {
    @Autowired
    private ColorService colorService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("trade:color:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = colorService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("trade:color:info")
    public R info(@PathVariable("id") Long id){
		ColorEntity color = colorService.getById(id);

        return R.ok().put("color", color);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("trade:color:save")
    public R save(@RequestBody ColorEntity color){
		colorService.save(color);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("trade:color:update")
    public R update(@RequestBody ColorEntity color){
		colorService.updateById(color);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("trade:color:delete")
    public R delete(@RequestBody Long[] ids){
		colorService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
