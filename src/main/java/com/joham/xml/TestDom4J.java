package com.joham.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

public class TestDom4J {
    public static void main(String[] args) throws Exception {
        testStringXml();
    }

    /**
     * 本地xml
     */
    public void testLocalXml() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("D:/apache-tomcat-7.0.35/conf/server.xml"));
        Element element = document.getRootElement();
        System.out.println(element.getName());
        System.out.println(element.attribute("port").getValue());
        System.out.println(element.element("Listener").attribute("SSLEngine").getValue());
        System.out.println(element.element("GlobalNamingResources").element("Resource").attribute("auth").getValue());
        for (Iterator iterator = element.elementIterator(); iterator.hasNext(); ) {
            System.out.println((Element) iterator.next());
        }
    }

    public static void testStringXml() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("D:/a.xml"));
        //获取根节点元素对象
        Element node = document.getRootElement();
        //遍历所有的元素节点
        listNodes(node);
        // 获取四大名著元素节点中，子节点名称为红楼梦元素节点。
        Element element = node.element("红楼梦");
        //获取element的id属性节点对象
        Attribute attr = element.attribute("id");
        //删除属性
        element.remove(attr);
        //添加新的属性
        element.addAttribute("name", "作者");
        // 在红楼梦元素节点中添加朝代元素的节点
        Element newElement = element.addElement("朝代");
        newElement.setText("清朝");
        //获取element中的作者元素节点对象
        Element author = element.element("作者");
        //删除元素节点
        boolean flag = element.remove(author);
        //返回true代码删除成功，否则失败
        System.out.println(flag);
        //添加CDATA区域
        element.addCDATA("红楼梦，是一部爱情小说.");
        // 写入到一个新的文件中
        writer(document);
    }

    /**
     * 把document对象写入新的文件
     *
     * @param document
     * @throws Exception
     */
    public static void writer(Document document) throws Exception {
        // 紧凑的格式
        // OutputFormat format = OutputFormat.createCompactFormat();
        // 排版缩进的格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置编码
        format.setEncoding("UTF-8");
        // 创建XMLWriter对象,指定了写出文件及编码格式
        // XMLWriter writer = new XMLWriter(new FileWriter(new
        // File("src//a.xml")),format);
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(
                new FileOutputStream(new File("D:/a.xml")), "UTF-8"), format);
        // 写入
        writer.write(document);
        // 立即写入
        writer.flush();
        // 关闭操作
        writer.close();
    }

    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *
     * @param node
     */
    public static void listNodes(Element node) {
        System.out.println("当前节点的名称：：" + node.getName());
        // 获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        // 遍历属性节点
        for (Attribute attr : list) {
            System.out.println(attr.getText() + "-----" + attr.getName()
                    + "---" + attr.getValue());
        }

        if (!("".equals(node.getTextTrim()))) {
            System.out.println("文本内容：：：：" + node.getText());
        }

        // 当前节点下面子节点迭代器
        Iterator<Element> it = node.elementIterator();
        // 遍历
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element e = it.next();
            // 对子节点进行遍历
            listNodes(e);
        }
    }
}
