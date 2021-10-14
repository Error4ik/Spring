package org.example.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.beans.replace_method.BeanE;
import org.example.beans.singleton_prototype.BeanC;
import org.example.beans.singleton_prototype.BeanD;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        BeanC singletonBeanC = context.getBean(BeanC.class);
        BeanC singletonBeanC2 = context.getBean(BeanC.class);

        BeanD firstPrototype = singletonBeanC.createBeanD();
        BeanD secondPrototype = singletonBeanC.createBeanD();

        logger.info(String.format("Is Bean (C) a Singleton? - %s", singletonBeanC == singletonBeanC2));
        logger.info(String.format("Are 2 instances of bin Bean (D) equal? - %s", firstPrototype == secondPrototype));

        BeanE beanE = context.getBean(BeanE.class);
        beanE.printName();

        BeanF beanF = context.getBean(BeanF.class);
        context.close();
    }
}
