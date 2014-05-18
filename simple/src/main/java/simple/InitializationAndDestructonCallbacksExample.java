package simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitializationAndDestructonCallbacksExample {
	
	public static void main(String []a) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/InitializationAndDestructonCallbacksExample.xml");
	}

}
