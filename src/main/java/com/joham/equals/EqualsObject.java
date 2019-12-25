package com.joham.equals;

/**
 * @author joham
 */
public class EqualsObject {

    private int id;
    private String name;

    public EqualsObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        //如果为null，或者并非同类，则直接返回false，getClass()用来比较较两个对象是否是同一个类的实例（第一处）
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        //如果引用指向同一个对象，则返回true，==判断的是引用指向的地址是否相同
        if (this == obj) {
            return true;
        }

        //需要强制转换来获取EqualsObject的方法
        EqualsObject temp = (EqualsObject) obj;

        //本示例判断标准是两个属性值相等，逻辑随业务场景不同而不同
        if (temp.getId() == this.id && name.equals(temp.getName())) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }
}
