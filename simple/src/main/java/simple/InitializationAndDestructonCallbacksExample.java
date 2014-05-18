package simple;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitializationAndDestructonCallbacksExample {
	
	public static class Team implements InitializingBean, DisposableBean{
		Logger logger = Logger.getLogger(Team.class);
		
		void initialize() {
			logger.info("initialize");
		}
		
		void destruction() {
			logger.info("destruction");
		}

		void setup() {
			logger.info("setup");
		}

		void teardown() {
			logger.info("teardown");
		}

		public void destroy() throws Exception {
			logger.info("destroy");
		}

		public void afterPropertiesSet() throws Exception {
			logger.info("afterPropertiesSet");
		}
	}
	
	
	public static void main(String []a) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/InitializationAndDestructonCallbacksExample.xml");
		
		applicationContext.getBean(Team.class);
	}

}
