package org.example.beans.singleton_prototype;

public abstract class BeanC {

    private BeanD beanD;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                '}';
    }

    public abstract BeanD createBeanD();

    public void setBeanD(BeanD beanD) {
        this.beanD = beanD;
    }
}
