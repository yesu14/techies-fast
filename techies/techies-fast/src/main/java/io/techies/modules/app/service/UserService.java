/**
 * Copyright (c) 2016-2100 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.modules.app.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.techies.modules.app.entity.UserEntity;
import io.techies.modules.app.form.LoginForm;

/**
 * 用户
 *
 * @author Techies-RG
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	long login(LoginForm form);
}
