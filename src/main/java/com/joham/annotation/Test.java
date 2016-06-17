package com.joham.annotation;

@Person(name = "joham", age = 16)
public class Test {
    public static void main(String[] args) {
        print(Test.class);
    }

    public static void print(Class c) {
        System.out.println(c.getName());

        //java.lang.Class的getAnnotation方法，如果有注解，则返回注解。否则返回null
        Person person = (Person) c.getAnnotation(Person.class);
        if (person != null) {
            System.out.println(person.name() + " " + person.age());
        } else {
            System.out.println("null");
        }
    }
}
