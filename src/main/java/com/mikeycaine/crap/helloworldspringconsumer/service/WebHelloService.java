package com.mikeycaine.crap.helloworldspringconsumer.service;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.mikeycaine.crap.helloworldspringconsumer.Hello;
import com.mikeycaine.crap.helloworldspringconsumer.HelloResponse;
import com.mikeycaine.crap.helloworldspringconsumer.ObjectFactory;

@Service
public class WebHelloService implements HelloService {

	//@Autowired
	//ObjectFactory objectFactory;
	
	private final ObjectFactory objectFactory = new ObjectFactory();

	@Autowired
	private WebServiceTemplate webServiceTemplate;

	@Override
	public String getHello(String name) {

		Hello hello = objectFactory.createHello();
		hello.setArg0(name);
		JAXBElement<Hello> jaxbHello = objectFactory.createHello(hello);

		JAXBElement<HelloResponse> jaxbHelloResponse =
				(JAXBElement<HelloResponse>) webServiceTemplate.marshalSendAndReceive(jaxbHello);
		
		HelloResponse helloResponse = jaxbHelloResponse.getValue();
		return helloResponse.getReturn();

	}

}
