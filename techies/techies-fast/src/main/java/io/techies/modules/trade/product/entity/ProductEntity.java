package io.techies.modules.trade.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 产品库
 * 
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-29 00:34:41
 */
@Data
@TableName("t_product")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 产品编号
	 */
	@TableId
	private Long id;
	/**
	 * 品名
	 */
	private String productName;
	/**
	 * 商品编号
	 */
	private String productCode;
	/**
	 * 韩国链接
	 */
	private String koreanLink;
	/**
	 * 中国链接
	 */
	private String chineseLink;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 图片地址
	 */
	private String picture;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 操作用户
	 */
	private String username;

}
