package kr.ac.ajou.dsd.kda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

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
