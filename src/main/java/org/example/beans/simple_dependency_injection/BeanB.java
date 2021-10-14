package org.example.beans.simple_dependency_injection;

public class BeanB {

    private final BeanA beanA;
    private String name;

    public BeanA getBeanA() {
        return beanA;
    }

    public BeanB(BeanA beanA) {
        this.beanA = beanA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                '}';
    }
}
