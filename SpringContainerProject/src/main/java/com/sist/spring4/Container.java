package com.sist.spring4;
import java.util.*;

public class Container {
	private Map clsMap =new HashMap();
	public Container(){
		clsMap.put("a",new A());
		clsMap.put("b",new B());
		clsMap.put("b",new C());
		
	}
	
	public Object getBean(String key) {
		return clsMap.get(key);
	}
}
