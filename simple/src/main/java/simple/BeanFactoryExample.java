package simple;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;


public class BeanFactoryExample {
	
	public static class Car {
		Logger logger = Logger.getLogger(Car.class);
		
		Car() {
			logger.info("Car");
		}
		
	}

	public static void main(String [] a) {
		
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("../../resources/spring/bean-definitions.xml", BeanFactoryExample.class));
        
        beanFactory.getBean(Car.class);
	}
}
