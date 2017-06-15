package com.qhli.demo.xml.jdom;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class TestJdom{

	/**
	 * @param args
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws JDOMException
	 */
    	@org.junit.Test
	public void test01() throws Exception {
		URL url = TestJdom.class.getResource("/opDetail.xml");
		File file = new File(url.toURI());
		String xml = org.apache.commons.io.FileUtils.readFileToString(file, "UTF-8") ;

		System.out.println(xml);

		// 创建一个新的字符串
//		StringReader read = new StringReader(xml);
//		// 创建一个新的SAXBuilder
		SAXBuilder sb = new SAXBuilder();
		// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
//		InputSource source = new InputSource(read);

		// 通过输入源构造一个Document
		Document doc = sb.build(file);
		Element rootElement = doc.getRootElement();
		List<Element> childList = rootElement.getChildren();
		if (childList != null && childList.size() > 0) {
			Element recordInfo = childList.get(0);
			List<Element> fieldList = recordInfo.getChildren();
			if (fieldList != null && fieldList.size() > 0) {
				for (Element field : fieldList) {
					List<Element> lastList = field.getChildren();
					if (lastList != null && lastList.size() > 0) {
						for (Element e : lastList) {
							System.out.println(e.getName()+" = "+e.getText());
						}
					}
				}
			}
		}


	}

}
