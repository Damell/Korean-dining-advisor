package kr.ac.ajou.dsd.kda.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import kr.ac.ajou.dsd.kda.KoreanDiningAdvisorApplication;

/**
 * class that configures the properties for accessing the correct DBMS automatically by considering environment variables 
 * ### Warning! ###
 * method {@link #setAutoGenerate} should be adjusted for running on anything else than running local
 * @author Torben Tietze <torben.tietze@googlemail.com>
 *
 */
@Configuration
public class DatabaseInit implements ServletContextInitializer {
	static final private Logger logger = Logger.getLogger(KoreanDiningAdvisorApplication.class);
	static final private String DATABASETYPE = "MYSQL";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		String dbHost = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_HOST");
    	String dbPort = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_PORT");
    	String dbUsername = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_USERNAME");
    	String dbPassword = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_PASSWORD");
    	String dbSocket = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_SOCKET");
    	String dbURL = System.getenv("OPENSHIFT_" + DATABASETYPE + "_DB_URL");
    	
    	if(dbHost == null || dbPort == null || dbUsername == null || dbPassword == null || dbSocket == null || dbURL == null) {
    		logger.info("Database environment variables not set. Use embedded database");
    		return;
    	}
    			
    	logger.info("set properties for database connection on server");
    	
    	System.setProperty("spring.datasource.url", "jdbc:"+ DATABASETYPE.toLowerCase() + "://"+ dbHost + ":" + 
    			dbPort + "/kda?characterEncoding=UTF-8");
    	System.setProperty("spring.datasource.username", dbUsername);
    	System.setProperty("spring.datasource.password", dbPassword);
    	System.setProperty("spring.datasource.driver", "com.mysql.jdbc.Driver");
    	System.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.MySQL5Dialect");
    	
    	// bugfix for refused connection between tomcat and mysql on openshift platform
    	System.setProperty("spring.datasource.testOnBorrow", "true");
    	System.setProperty("spring.datasource.validationQuery", "SELECT 1");
    	
    	setAutoGenerate();
		
	}
	
	/**
	 * ### Warning! ###<br/>
	 * if property is set to "create" it will drop and create new tables 
	 */
	private void setAutoGenerate() {
    	System.setProperty("spring.datasource.initialize", "true");
//    	System.setProperty("spring.jpa.hibernate.ddl-auto", "create");
    	System.setProperty("spring.jpa.hibernate.ddl-auto", "none");
	}

}
