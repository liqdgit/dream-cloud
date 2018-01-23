package com.dream.admin.service;

import com.dream.admin.service.listener.DreamAdminServiceListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>Title:      ServerApplication. </p>
 * <p>Description 启动类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/11/16 14:06
 */
@EnableEurekaClient
@ComponentScan(basePackages = {"com.dream.core.config", "com.dream.admin.service"})
@SpringBootApplication
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AdminServiceApplication.class);
		app.addListeners(new DreamAdminServiceListener());
		app.run(args);
	}
}
