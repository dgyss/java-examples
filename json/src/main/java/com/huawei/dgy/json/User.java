package com.huawei.dgy.json;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * creator: dgy
 * date: 2017/4/17
 * version: 1.0
 */
public class User {

    private String name;

    private int age;

    private List<Person> persons = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
