package com.huawei.dgy.json;

import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 测试vert.x json库
 * <p>
 * creator: dgy
 * date: 2017/4/17
 * version: 1.0
 *
 * json支持的数据类型: string、number、boolean
 * json支持null值
 */
public class Test {
    public static void main(String args[]) {
        createJsonFromString();

        createJsonFromMap();

        putEntryIntoJsonObject();

        getValueFromJsonObject();

        mapBetweenJavaObjectAndJsonObject();
    }

    private static void createJsonFromString(){
        String jsonString = "{\"foo\": \"bar\"}";
        JsonObject jsonObject = new JsonObject(jsonString);

        System.out.println(jsonObject.encodePrettily());
    }

    private static void createJsonFromMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("foo", "bar");
        map.put("xyz", 3);
        JsonObject jsonObject = new JsonObject(map);

        System.out.println(jsonObject.encodePrettily());
    }

    private static void putEntryIntoJsonObject(){
        JsonObject object = new JsonObject();
        object.put("foo", "bar").put("num", 123).put("mybool", true);

        System.out.println(object.encodePrettily());
    }

    private static void getValueFromJsonObject() {
        JsonObject object = new JsonObject();
        object.put("foo", "bar").put("num", 123).put("mybool", true);

        String val = object.getString("foo");
        int intVal = object.getInteger("num");

        System.out.println("val: " + val);
        System.out.println("intVal: " + intVal);
    }

    /**
     * <p>
     *     In the simplest case, both mapFrom and mapTo should succeed if all fields of the Java class
     *     are public (or have public getters/setters), and if there is a public default constructor
     *     (or no defined constructors)
     * </p>
     * */
    private static void mapBetweenJavaObjectAndJsonObject() {
        User user = new User();
        user.setName("mark");
        user.setAge(16);

        Person person = new Person();
        person.setName("tom");
        person.setAge(23);

        List<Person> list = new ArrayList<>();
        list.add(person);

        user.setPersons(list);

        JsonObject jsonObject = JsonObject.mapFrom(user);

        System.out.println(jsonObject.encodePrettily());

        User copyUser = jsonObject.mapTo(User.class);

        System.out.println("name: " + copyUser.getName());
        System.out.println("age: " + copyUser.getAge());
        System.out.println("persons: " + copyUser.getPersons());
    }
}
