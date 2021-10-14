package org.example.beans.singleton_prototype;

public class BeanD {

    private String name;

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
