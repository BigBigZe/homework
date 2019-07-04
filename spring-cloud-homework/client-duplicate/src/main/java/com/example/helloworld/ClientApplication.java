package com.example.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableDiscoveryClient
@RestController
@RefreshScope
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
    @Value("${name}")
    String name;
    
    @Value("${age}")
    String age;
    @RequestMapping(value = "/hi")
    public String hi(){
        return "我是"+name+",今年"+age+"岁";
    }
    @Value("${server.port}")
    String port;
    @RequestMapping("/")
    public String test() {
    	return "this is "+port;
    }
}
