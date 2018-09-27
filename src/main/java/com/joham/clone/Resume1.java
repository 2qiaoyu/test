package com.joham.clone;

/**
 * @author joham
 */
public class Resume1 implements Cloneable {
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private int age;

    /**
     * 工作经历
     */
    private String experience;

    public Resume1(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperience() {
        return experience;
    }

    public void displayResume() {
        System.out.println("姓名：" + name + " 性别：" + sex + " 年龄:" + age);
        System.out.println("工作经历：" + experience);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}