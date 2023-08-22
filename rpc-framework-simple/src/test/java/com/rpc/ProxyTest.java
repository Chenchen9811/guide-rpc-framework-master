package com.rpc;

public class ProxyTest {
    public static void main(String[] args) {
        Student student = new Student("张三");
        Person person = (Person) new PersonProxy<Person>(student).getProxy(student.getClass());
        person.giveMoney();
    }
}
