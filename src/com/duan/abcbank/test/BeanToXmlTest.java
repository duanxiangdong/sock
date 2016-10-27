package com.duan.abcbank.test;

import java.util.HashMap;
import java.util.Map;

import com.duan.abcbank.bean.collection.Cmp;
import com.duan.abcbank.bean.collection.Collection;
import com.duan.abcbank.bean.collection.Corp;
import com.duan.abcbank.bean.common.CommonMessage;
import com.duan.abcbank.xml.utils.AbcBeanConverter;
import com.thoughtworks.xstream.XStream;

public class BeanToXmlTest {
	public static void main(String[] args) {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		HashMap<Class<?>, String> map = new HashMap<Class<?>, String>();
		map.put(Corp.class, "Corp");
		map.put(Cmp.class, "Cmp");
		map.put(CommonMessage.class, "");
		AbcBeanConverter nullConverter = new AbcBeanConverter(map);
//		nullConverter.regAttribute(Collection.class, "Amt");
		xstream.registerConverter(nullConverter);
		try {
			Corp corp = new Corp("11","121","","");
			Cmp cmp = new Cmp("11","","31200101040010880");
			CommonMessage commonMessage = new CommonMessage("CFRB18","","","","","","");
			Collection Collection = new Collection(commonMessage, cmp, corp, "11");
			String comMesXml = xstream.toXML(Collection);
			System.out.println(comMesXml);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
