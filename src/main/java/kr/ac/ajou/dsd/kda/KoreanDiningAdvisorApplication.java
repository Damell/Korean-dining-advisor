package kr.ac.ajou.dsd.kda;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class KoreanDiningAdvisorApplication extends SpringBootServletInitializer {
	static final private Logger logger = Logger.getLogger(KoreanDiningAdvisorApplication.class);
	static final private String DATABASETYPE = "MYSQL";
	
    public static void main(String[] args) {
    	initDatabaseVars();
        SpringApplication.run(KoreanDiningAdvisorApplication.class, args);

    }

    private static void initDatabaseVars() {
    	String dbHost = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_HOST");
    	String dbPort = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_PORT");
    	String dbUsername = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_USERNAME");
    	String dbPassword = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_PASSWORD");
    	String dbSocket = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_SOCKET");
    	String dbURL = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_URL");
    	
    	if(dbHost == null || dbPort == null || dbUsername == null || dbPassword == null || dbSocket == null || dbURL == null) {
    		logger.info("Database environment variables not set. Use embedded databaes");
    		return;
    	}
    			
    	logger.info("set properties for database connection on server");
    	
    	System.setProperty("spring.datasource.url", dbURL);
    	System.setProperty("spring.datasource.username", dbUsername);
    	System.setProperty("spring.datasource.password", dbPassword);
    	System.setProperty("spring.datasource.initialize", "true");
    	System.setProperty("spring.datasource.driver", "com.mysql.jdbc.Driver");
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(KoreanDiningAdvisorApplication.class);
    } 
}
