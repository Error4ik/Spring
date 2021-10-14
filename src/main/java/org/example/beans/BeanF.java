package org.example.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BeanF {

    private static final Logger logger = LogManager.getLogger();

    private String name;

    public BeanF() {
        logger.info("Creating bean (F)");
    }

    public void init() {
        logger.info("Init method bean (F)");
    }

    public void destroy() {
        logger.info("Destroy method bean (F)");
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
