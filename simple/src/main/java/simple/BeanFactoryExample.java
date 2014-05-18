package simple;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


public class BeanFactoryExample {
	
	public static class Car {
		Logger logger = Logger.getLogger(Car.class);
		
		private Engine engine;
		
		Car(Engine engine) {
			logger.info("Car");
			this.engine = engine;
		}
	}

	public static class Engine {
		Logger logger = Logger.getLogger(Engine.class);
		
		Engine() {
			logger.info("Engine");
		}
	}
	
	public static void main(String [] a) {
		
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("../../resources/spring/BeanFactoryExample.xml", BeanFactoryExample.class));
        
        beanFactory.getBean(Car.class);
	}
}
