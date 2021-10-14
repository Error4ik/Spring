package org.example.beans.replace_method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class BeanMethodReplacer implements MethodReplacer {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        logger.info("Replaced method!");
        return o;
    }
}
