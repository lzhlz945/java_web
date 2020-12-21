package com.zhang;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhang.proj.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang
 * @date:2020/12/21
 */
public class TestJson {

    //json字符和javabean互转
    @Test
    public void test01(){

        Person person = new Person(1,"星儿");
        Gson gson=new Gson();
        String s = gson.toJson(person);
        System.out.println(s);
        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);
    }

    //json字符和list互转
    @Test
    public void test02(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1, "123"));
        personList.add(new Person(2, "1234"));
        Gson gson=new Gson();
        String json = gson.toJson(personList);
        System.out.println(json);

        List<Person> listPerson = gson.fromJson(json, new TypeToken<ArrayList<Person>>() {
        }.getType());
        System.out.println(listPerson);
    }
    @Test
    public void test03(){

    }
}
