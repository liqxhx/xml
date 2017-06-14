package com.qhli.demo.xml.dom4j;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import org.junit.Test;

public class TestDom4j{
	@Test
	public void test01() throws Exception {
		SAXReader reader = new SAXReader() ;
		URI uri = TestDom4j.class.getResource("/filter.xml").toURI() ;
		File file = new File(uri);
		Document doc = reader.read(file) ;
		Element root = doc.getRootElement() ;
		List<Element> eleList = root.selectNodes("rule") ;

		for(Element ele : eleList) {
			String ruleIdstr = ele.attributeValue("id") ;
			String ruleName = ele.attributeValue("name") ;
			Integer ruleId = Integer.valueOf(ruleIdstr) ;
			System.out.print("ruleId:"+ruleId+",ruleName:"+ruleName);
//			Element conditionsEle = (Element) ele.selectNodes("conditions").get(0) ;
//			List<Element> propertyEleList = conditionsEle.selectNodes("property") ;
			Node node = ele.selectSingleNode("conditions") ;
			List<Element> propertyEleList = node.selectNodes("property") ;
			for(Element propEle : propertyEleList) {
				String pName = propEle.attributeValue("name") ;
				String pType = propEle.attributeValue("type") ;
				String pOP = propEle.attributeValue("op") ;
				String pValue = propEle.attributeValue("value") ;

				System.out.print("pName:"+pName+",type:"+pType+",pOP:"+pOP+",pValue:"+pValue);
			}


			Element opEle = (Element) ele.selectNodes("operation").get(0);
			String operation = opEle.getText() ;
			System.out.println("operation:"+operation);

			Element resultEle = (Element) ele.selectNodes("result").get(0);
			String result = resultEle.attributeValue("value") ;
			System.out.println("result:"+result) ;



		}
	}

}
