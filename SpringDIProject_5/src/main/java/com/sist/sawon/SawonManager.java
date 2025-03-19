package com.sist.sawon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sa")
public class SawonManager {
	
	
	public void display() {
		System.out.println("SawonManager:display() Call..");
	}
	
}
