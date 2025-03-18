package com.sist.spring;
import java.io.*;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ApplicationContext {
	private Map map=new HashMap();
	public ApplicationContext(String path)
	{
		try {
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();
			XMLparser xp=new XMLparser();
			sp.parse(new File(path), xp);
			map=xp.clsMap;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public Object getBean(String key) {
		return map.get(key);
	}
}
