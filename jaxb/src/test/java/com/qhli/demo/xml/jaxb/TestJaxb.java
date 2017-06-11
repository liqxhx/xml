
package com.qhli.demo.xml.jaxb;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class TestJaxb {

	@Test
	public void testMarshal() {
		try {
			JAXBContext ctx = JAXBContext.newInstance(Student.class);
			Marshaller marshaller = ctx.createMarshaller();
			Student stu = new Student(1,"张三",21,new Classroom(1,"10计算机应用技术",2010));
			marshaller.marshal(stu, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUnmarshal() {
		try {
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>21</age><classroom><grade>2010</grade><id>1</id><name>10计算机应用技术</name></classroom><id>1</id><name>张三</name></student>";
			JAXBContext ctx = JAXBContext.newInstance(Student.class);
			Unmarshaller um = ctx.createUnmarshaller();
			Student stu = (Student)um.unmarshal(new StringReader(xml));
			System.out.println(stu.getName()+","+stu.getClassroom().getName());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
