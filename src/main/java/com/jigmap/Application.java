package com.jigmap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Component
    public class EndpointsListener {

        private final Logger LOGGER = LoggerFactory.getLogger(EndpointsListener.class);

        @EventListener
        public void handleContextRefresh(ContextRefreshedEvent event) {
            ApplicationContext applicationContext = event.getApplicationContext();
            applicationContext.getBean(RequestMappingHandlerMapping.class)
                .getHandlerMethods().forEach((key, value) -> LOGGER.info("{} {}", key, value));
        }
    }
}
