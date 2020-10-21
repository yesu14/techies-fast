/**
 * Copyright (c) 2016-2100 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.techies.common.utils.R;
import io.techies.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 *
 * @author Techies-RG
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
