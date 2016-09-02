package com.erolkaftanoglu.firebaseonandroiddemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by erol on 2.09.2016.
 */
public class Person {
    String name;
    String surname;
    String age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("surname", this.surname);
        map.put("age",this.age);
        return map;
    }
}
