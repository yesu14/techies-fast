/**
 * Copyright (c) 2016-2100 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.modules.sys.form;

import lombok.Data;

/**
 * 登录表单
 *
 * @author Techies-RG
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;


}
