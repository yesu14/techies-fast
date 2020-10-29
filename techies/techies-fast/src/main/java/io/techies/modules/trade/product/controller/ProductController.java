package io.techies.modules.trade.product.controller;

import java.util.Arrays;
import java.util.Map;

import io.techies.modules.sys.entity.SysUserEntity;
import io.techies.modules.trade.product.entity.ProductEntity;
import io.techies.modules.trade.product.service.ProductService;
import org.apache.shiro.SecurityUtils;
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
 * 产品库
 *
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-29 00:34:41
 */
@RestController
@RequestMapping("trade/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("trade:product:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = productService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("trade:product:info")
    public R info(@PathVariable("id") Long id){
		ProductEntity product = productService.getById(id);

        return R.ok().put("product", product);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("trade:product:save")
    public R save(@RequestBody ProductEntity product){
        String username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
        product.setUsername(username);
		productService.save(product);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("trade:product:update")
    public R update(@RequestBody ProductEntity product){
        String username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
        product.setUsername(username);
		productService.updateById(product);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("trade:product:delete")
    public R delete(@RequestBody Long[] ids){
		productService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
