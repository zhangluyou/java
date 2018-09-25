package com.myelastic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;

@SpringBootApplication
@EnableWebSocket
@Slf4j
public class Pro01Application {

	public static void main(String[] args) {
		SpringApplication.run(Pro01Application.class, args);
		log.info("pro01启动");
	}
//	@Bean public ServerEndpointExporter serverEndpointExporter(){
//		return new ServerEndpointExporter();
//	}
}
