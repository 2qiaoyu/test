package com.joham.clone;

/**
 * @author joham
 */
public class Resume2 implements Cloneable {
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
    private Experience experience;

    public Resume2(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.experience = new Experience();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(String educationBackground, String skills) {
        experience.setExperience(educationBackground, skills);
    }

    public void displayResume() {
        System.out.println("姓名：" + name + " 性别：" + sex + " 年龄:" + age);
        System.out.println("工作经历：" + experience.toString());
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