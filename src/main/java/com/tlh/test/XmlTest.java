package com.tlh.test;

import java.lang.reflect.Field;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tlh.entity.User;

public class XmlTest {

	public static void main(String[] args) {
//		SAXReader reader = new SAXReader();
//		try {
//			Document doc = reader.read("src/main/resources/beans.xml");
//			Element rootElement = doc.getRootElement();
//			System.out.println(rootElement.getName());
//			Iterator<Element> elementIterator = rootElement.elementIterator();
//			while(elementIterator.hasNext()){
//				System.out.println("name:"+elementIterator.next().getName());
//				System.out.println("idValue:"+elementIterator.next().attributeValue("id"));
////				System.out.println("text:"+elementIterator.next().getData());
//			}
//			
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
		
		try {
			Class<?> clazz = Class.forName("com.tlh.entity.User");
			System.out.println("XMLTest.Class:"+clazz);
			Object instance = clazz.newInstance();
			System.out.println(instance);
			Field field = clazz.getDeclaredField("userName");
			User user = new User();
//			User.class;
			Object obj = new Object();
			field.setAccessible(true);
			field.set(instance,2);
			System.out.println(instance);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
