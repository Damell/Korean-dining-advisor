package kr.ac.ajou.dsd.kda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * super class for all testing classes to have same configuration for all of them
 * @author Torben Tietze <torben.tietze@googlemail.com>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KoreanDiningAdvisorApplication.class)
@WebAppConfiguration
public class KoreanDiningAdvisorApplicationTests {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void contextLoads() {
	}

}
