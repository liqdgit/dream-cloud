package com.dream.admin.web;

import com.dream.admin.web.listener.DreamAdminWebListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>Title:      ServerApplication. </p>
 * <p>Description 启动类 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2017/12/25 15:10
 */
@EnableFeignClients
@EnableEurekaClient
@ComponentScan(basePackages = {"com.dream.core.config", "com.dream.admin.web"})
@SpringBootApplication
public class AdminWebApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AdminWebApplication.class);
		app.addListeners(new DreamAdminWebListener());
		app.run(args);
	}

}
