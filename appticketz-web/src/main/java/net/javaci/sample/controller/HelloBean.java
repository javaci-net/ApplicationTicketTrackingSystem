package net.javaci.sample.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller(value = "helloBean")
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 4085285875380136779L;
	
	private String message = "Hello from Javaci.net";

	private static final Logger log = LoggerFactory.getLogger(HelloBean.class);

	@PostConstruct
	public void init() {
		System.out.println("Hello bean init calisti.");
	}

	
	public void clickHelloWorldButton() {
		
		log.info("Merhaba Dünya Tıklandı !");
		
	}
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	
}
