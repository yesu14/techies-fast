package io.techies.modules.trade.color.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 颜色表
 * 
 * @author RG
 * @email 396390583@qq.com
 * @date 2020-10-29 00:29:01
 */
@Data
@TableName("t_color")
public class ColorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 颜色ID
	 */
	@TableId
	private Long id;
	/**
	 * 颜色韩文名称
	 */
	private String koreanName;
	/**
	 * 颜色中文名称
	 */
	private String chineseName;
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
