package com.empmanagment.domain.test;

public class Student extends Person {
    int age = 10;
    @Override
    boolean printAge() {
        System.out.println("Student");
        return false;
    }
}

class Person {
    int age = 20;

    boolean printAge(){
        System.out.println("Person");
        return false;
    }
}

class Main{
    public static void main(String[] args) {
        Person person = new Student();
        System.out.println(person.age);
        System.out.println(person.printAge());
    }
}
