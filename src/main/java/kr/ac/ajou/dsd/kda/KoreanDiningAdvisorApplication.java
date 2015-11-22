package kr.ac.ajou.dsd.kda;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;

import kr.ac.ajou.dsd.kda.util.DatabaseInit;

@SpringBootApplication
public class KoreanDiningAdvisorApplication extends SpringBootServletInitializer {
	
    public static void main(String[] args) {
        SpringApplication.run(KoreanDiningAdvisorApplication.class, args);

    }

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(KoreanDiningAdvisorApplication.class);
    } 
}
