package com.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@org.springframework.stereotype.Service
public class Service {
	@Autowired RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "downGrade")
	public String getHelloContent() {
        return restTemplate.getForObject("http://config-client/index.html",String.class);
    }
	
	@HystrixCommand(fallbackMethod="breaker")
	public String downGrade() {
		return restTemplate.getForObject("http://ribbon-server/index.html",String.class);
	}
	
	public String breaker() {
		return "NOT AVAILABLE!!!";
	}
}
