package com.joham.xml;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.List;

public class TestJdomXml {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><PAY><BODY><EC>00</EC><SID>6110200117</SID><SO>20150829130806</SO><ZO>4154131084192439</ZO><ZODT>20150829130926</ZODT><ZA>0.01</ZA><ZS>3</ZS><ZUDT>20150829131008</ZUDT><OP>03</OP><SIGN>6ba3a581c9b61a0c44af0c5c9dec7f84</SIGN><ZSIGN>c4799821f9bf1055fc873ea470fbfeac</ZSIGN><CC>05819b3655e6ad0a67ff6368d688f51a</CC></BODY></PAY>";
        StringReader read = new StringReader(xml);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        try {
            //通过输入源构造一个Document
            Document doc = sb.build(source);
            //取的根元素
            Element root = doc.getRootElement();
            System.out.println(root.getName());//输出根元素的名称
            List node = root.getChildren();
            Element et = null;
            et = (Element) node.get(0);//循环依次得到子元素
            Element EC = et.getChild("EC");
            System.out.println(et.getName());
            System.out.println(EC.getValue());
        } catch (Exception e) {

        }
    }
}
