package com.joham.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class Test {


    public static void init(Map map) {
        if (map != null) {
            String key = null;
            for (int i = 5; i > 0; i--) {
                key = new Integer(i).toString() + ".0";
                map.put(key, key.toString());
                //Map中的键是不重复的，如果插入两个键值一样的记录，
                //那么后插入的记录会覆盖先插入的记录
                map.put(key, key.toString() + "0");
            }
        }
    }

    /**
     * 循环取出Map里面的值
     *
     * @param map
     */
    public static void output(Map map) {
        if (map != null) {
            Object key = null;
            Object value = null;
            //使用迭代器遍历Map的键，根据键取值
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                key = it.next();
                value = map.get(key);
                System.out.println("key: " + key + "; value: " + value);
            }
            //或者使用迭代器遍历Map的记录Map.Entry
            Map.Entry entry = null;
            it = map.entrySet().iterator();
            while (it.hasNext()) {
                //一个Map.Entry代表一条记录
                entry = (Map.Entry) it.next();
                //通过entry可以获得记录的键和值
                //System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
            }
        }
    }

    public static boolean containsKey(Map map, Object key) {
        if (map != null) {
            return map.containsKey(key);
        }
        return false;
    }

    public static boolean containsValue(Map map, Object value) {
        if (map != null) {
            return map.containsValue(value);
        }
        return false;
    }

    public static void testHashMap() {
        Map myMap = new HashMap();
        init(myMap);
        //HashMap的键可以为null
        myMap.put(null, "ddd");
        //HashMap的值可以为null
        myMap.put("aaa", null);
        output(myMap);
    }

    public static void testHashtable() {
        Map myMap = new Hashtable();
        init(myMap);
        //Hashtable的键不能为null
        //myMap.put(null,"ddd");
        //Hashtable的值不能为null
        //myMap.put("aaa", null);
        output(myMap);
    }

    public static void testLinkedHashMap() {
        Map myMap = new LinkedHashMap();
        init(myMap);
        //LinkedHashMap的键可以为null
        myMap.put(null, "ddd");
        myMap.put(null, "aaa");
        //LinkedHashMap的值可以为null
        myMap.put("aaa", null);
        output(myMap);
    }

    public static void testTreeMap() {
        Map myMap = new TreeMap();
        init(myMap);
        //TreeMap的键不能为null
        //myMap.put(null,"ddd");
        //TreeMap的值不能为null
        //myMap.put("aaa", null);
        output(myMap);
    }

    public static void main(String[] args) {
        System.out.println("采用HashMap");
        Test.testHashMap();
        System.out.println("采用Hashtable");
        Test.testHashtable();
        System.out.println("采用LinkedHashMap");
        Test.testLinkedHashMap();
        System.out.println("采用TreeMap");
        Test.testTreeMap();

        Map myMap = new HashMap();
        Test.init(myMap);
        System.out.println("新初始化一个Map: myMap");
        Test.output(myMap);
        //清空Map
        myMap.clear();
        System.out.println("将myMap clear后，myMap空了么?  " + myMap.isEmpty());
        Test.output(myMap);
        myMap.put("aaa", "aaaa");
        myMap.put("bbb", "bbbb");
        //判断Map是否包含某键或者某值
        System.out.println("myMap包含键aaa?  " + Test.containsKey(myMap, "aaa"));
        System.out.println("myMap包含值aaaa?  " + Test.containsValue(myMap, "aaaa"));
        //根据键删除Map中的记录
        myMap.remove("aaa");
        System.out.println("删除键aaa后，myMap包含键aaa?  " + Test.containsKey(myMap, "aaa"));
        //获取Map的记录数
        System.out.println("myMap包含的记录数:  " + myMap.size());
    }
}

/*输出结果：
        采用HashMap
        key: null; value: ddd
        key: 3.0; value: 3.00
        key: aaa; value: null
        key: 4.0; value: 4.00
        key: 1.0; value: 1.00
        key: 5.0; value: 5.00
        key: 2.0; value: 2.00
        采用Hashtable
        key: 4.0; value: 4.00
        key: 1.0; value: 1.00
        key: 3.0; value: 3.00
        key: 5.0; value: 5.00
        key: 2.0; value: 2.00
        采用LinkedHashMap
        key: 5.0; value: 5.00
        key: 4.0; value: 4.00
        key: 3.0; value: 3.00
        key: 2.0; value: 2.00
        key: 1.0; value: 1.00
        key: null; value: aaa
        key: aaa; value: null
        采用TreeMap
        key: 1.0; value: 1.00
        key: 2.0; value: 2.00
        key: 3.0; value: 3.00
        key: 4.0; value: 4.00
        key: 5.0; value: 5.00
        新初始化一个Map: myMap
        key: 3.0; value: 3.00
        key: 4.0; value: 4.00
        key: 1.0; value: 1.00
        key: 5.0; value: 5.00
        key: 2.0; value: 2.00
        将myMap clear后，myMap空了么?  true
        myMap包含键aaa?  true
        myMap包含值aaaa?  true
        删除键aaa后，myMap包含键aaa?  false
        myMap包含的记录数:  1

        源码分析：
        遍历Map有两种方法：
        （1）map的keySet()方法获得键的集合，再调用键集合的iterator方法获得键的迭代器，以此迭代地取出Map中的键，用get方法获得键对应的值，便完成了Map的遍历。代码如下所示：
        //使用迭代器遍历Map的键，根据键取值
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
        key = it.next();
        value = map.get(key);
        System.out.println("key: " + key + "; value: " + value );
        }
        （2）使用Map的entrySet方法获得Map中记录的集合，每条对象都是一个Map.Entry对象，使用其getKey方法获得记录的键，使用其getValue方法获得记录的值。代码如下所示：
        //或者使用迭代器遍历Map的记录Map.Entry
        Map.Entry entry = null;
        it = map.entrySet().iterator();
        while (it.hasNext()){
        //一个Map.Entry代表一条记录
        entry = (Map.Entry)it.next();
//通过entry可以获得记录的键和值
//System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());*/
