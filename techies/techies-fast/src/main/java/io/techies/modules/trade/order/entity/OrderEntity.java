package io.techies.modules.trade.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * 
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-25 22:28:52
 */
@Data
@TableName("t_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	@TableId
	private Long id;
	/**
	 * 订单号
	 */
	private String orderNo;
	/**
	 * 下单日期
	 */
	private Date orderCreate;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品编号
	 */
	private String productCode;
	/**
	 * 中国链接
	 */
	private String chineseLink;
	/**
	 * 韩国链接
	 */
	private String koreanLink;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 图片地址
	 */
	private String picture;
	/**
	 * 颜色中文名称
	 */
	private String colorChinese;
	/**
	 * 颜色韩文名称
	 */
	private String colorKorean;
	/**
	 * 大小
	 */
	private String size;
	/**
	 * 数量
	 */
	private Integer qty;
	/**
	 * 运费
	 */
	private Double fare;
	/**
	 * 现况
	 */
	private Boolean status;
	/**
	 * 备注
	 */
	private String remark;
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
