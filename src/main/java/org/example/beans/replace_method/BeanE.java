package org.example.beans.replace_method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BeanE {

    private static final Logger logger = LogManager.getLogger();

    private String name;

    public void printName() {
        logger.info("Real method!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                '}';
    }
}
