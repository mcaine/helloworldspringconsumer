package com.mikeycaine.crap.helloworldspringconsumer.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mikeycaine.crap.helloworldspringconsumer.service.WebHelloService;

public class Main {
	
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Main.class);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		WebHelloService helloService = (WebHelloService)ctx.getBean(WebHelloService.class);
		String reply = helloService.getHello("mikey caine");
		
		log.info(String.format("Got reply: %s", reply));
	}
}
