package com.joham.clone;

/**
 * @author joham
 */
public class TestClone {

    public static void main(String[] args) {
        test4();
    }

    /**
     * 对象赋值
     */
    private static void test1() {
        Resume zhangsan = new Resume("zhangsan", "男", 24);
        zhangsan.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等代码复制");
        zhangsan.displayResume();
        Resume zhangsan1 = zhangsan;
        zhangsan1.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等");
        zhangsan.displayResume();
        zhangsan1.displayResume();
    }

    /**
     * 浅拷贝
     */
    private static void test2() {
        Resume1 zhangsan = new Resume1("zhangsan", "男", 24);
        zhangsan.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等代码拷贝和粘贴");
        zhangsan.displayResume();
        Resume1 zhangsan1 = (Resume1) zhangsan.clone();
        zhangsan1.setAge(23);
        zhangsan1.displayResume();
        Resume1 zhangsan2 = (Resume1) zhangsan.clone();
        zhangsan2.setExperience("2009-2013就读于家里蹲大学，精通JAVA,C,C++,C#等代码");
        zhangsan2.displayResume();
        zhangsan.displayResume();
    }

    /**
     * 浅拷贝
     */
    private static void test3() {
        Resume2 zhangsan = new Resume2("zhangsan", "男", 24);
        zhangsan.setExperience("2009-2013就读于家里蹲大学", "精通JAVA,C,C++,C#等代码拷贝和粘贴");
        zhangsan.displayResume();

        Resume2 zhangsan2 = (Resume2) zhangsan.clone();
        zhangsan2.setExperience("2009-2013就读于家里蹲大学", "精通JAVA,C,C++,C#等");
        zhangsan2.displayResume();
        zhangsan.displayResume();
        zhangsan2.displayResume();
    }

    /**
     * 深拷贝
     */
    private static void test4() {
        //写封邮件
        Email email = new Email("请与今天12:30到二会议室参加会议...");

        Person person1 = new Person("张三", email);

        Person person2 = CloneUtils.clone(person1);
        person2.setName("李四");
        Person person3 = CloneUtils.clone(person1);
        person3.setName("王五");
        person1.getEmail().setContent("请与今天12:00到二会议室参加会议...");

        System.out.println(person1.getName() + "的邮件内容是：" + person1.getEmail().getContent());
        System.out.println(person2.getName() + "的邮件内容是：" + person2.getEmail().getContent());
        System.out.println(person3.getName() + "的邮件内容是：" + person3.getEmail().getContent());
    }
}
