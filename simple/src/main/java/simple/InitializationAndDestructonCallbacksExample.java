package simple;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitializationAndDestructonCallbacksExample {
	
	public static class Team implements InitializingBean, DisposableBean{
		Logger logger = Logger.getLogger(Team.class);
		
		void initialize() {
			logger.info("CUSTOM: initialize");
		}
		
		void destruction() {
			logger.info("CUSTOM: destruction");
		}

		@PostConstruct
		void setup() {
			logger.info("ANNOTATION: setup");
		}

		@PreDestroy
		void teardown() {
			logger.info("ANNOTATION: teardown");
		}

		public void destroy() throws Exception {
			logger.info("INTERFACE: destroy");
		}

		public void afterPropertiesSet() throws Exception {
			logger.info("INTERFACE: afterPropertiesSet");
		}
	}
	
	
	public static void main(String []a) {
		
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/InitializationAndDestructonCallbacksExample.xml");
		
		applicationContext.registerShutdownHook();
		
		applicationContext.getBean(Team.class);
	}

}
