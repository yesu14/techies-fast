/**
 * Copyright (c) 2016-2100 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.modules.oss.controller;

import com.google.gson.Gson;
import io.techies.common.exception.RRException;
import io.techies.common.utils.*;
import io.techies.common.validator.ValidatorUtils;
import io.techies.common.validator.group.AliyunGroup;
import io.techies.common.validator.group.QcloudGroup;
import io.techies.common.validator.group.QiniuGroup;
import io.techies.modules.oss.cloud.CloudStorageConfig;
import io.techies.modules.oss.cloud.OSSFactory;
import io.techies.modules.oss.entity.SysOssEntity;
import io.techies.modules.oss.service.SysOssService;
import io.techies.modules.sys.service.SysConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 文件上传
 *
 * @author Techies-RG
 */
@Slf4j
@RestController
@RequestMapping("sys/oss")
public class SysOssController {

	@Value("${upload.product}")
	private String uploadpath;

	@Autowired
	private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:oss:all")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = sysOssService.queryPage(params);

		return R.ok().put("page", page);
	}


    /**
     * 云存储配置信息
     */
    @GetMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public R config(){
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


	/**
	 * 保存云存储配置信息
	 */
	@PostMapping("/saveConfig")
	@RequiresPermissions("sys:oss:all")
	public R saveConfig(@RequestBody CloudStorageConfig config){
		//校验类型
		ValidatorUtils.validateEntity(config);

		if(config.getType() == Constant.CloudService.QINIU.getValue()){
			//校验七牛数据
			ValidatorUtils.validateEntity(config, QiniuGroup.class);
		}else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
			//校验阿里云数据
			ValidatorUtils.validateEntity(config, AliyunGroup.class);
		}else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
			//校验腾讯云数据
			ValidatorUtils.validateEntity(config, QcloudGroup.class);
		}

        sysConfigService.updateValueByKey(KEY, new Gson().toJson(config));

		return R.ok();
	}
	

	/**
	 * 上传文件
	 */
	@PostMapping("/upload")
	@RequiresPermissions("sys:oss:all")
	public R upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file == null || file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}

		String path = ResourceUtils.getURL("classpath:").getPath()+uploadpath;
//		String realPath = path.replace('/', '\\').substring(1,path.length());
		//用于查看路径是否正确
		log.debug(path);

		//获取文件的名称
		final String fileName = StringUtils.getUUID();
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

		//限制文件上传的类型
		String contentType = file.getContentType();
		if("image/jpeg".equals(contentType) || "image/jpg".equals(contentType) || "image/gif".equals(contentType) || "image/png".equals(contentType) ){

			File filePath= new File(path);
			if(!filePath.exists()){
				filePath.mkdirs();
			}

			File newFile = new File(path,fileName+suffix);

			//完成文件的上传
			file.transferTo(newFile);
			log.debug("图片上传成功!");
		}else {
			throw new RRException("无法上传"+contentType+"格式");
		}


		//保存文件信息
//		SysOssEntity ossEntity = new SysOssEntity();
//		ossEntity.setUrl(url);
//		ossEntity.setCreateDate(new Date());
//		sysOssService.save(ossEntity);

		log.debug(fileName);
		return R.ok().put("fileName",fileName+suffix);
	}


	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@RequiresPermissions("sys:oss:all")
	public R delete(@RequestBody Long[] ids){
		sysOssService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}

}
