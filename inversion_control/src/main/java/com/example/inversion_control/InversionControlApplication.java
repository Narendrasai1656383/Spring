package com.example.inversion_control;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class InversionControlApplication {

	public static void main(String[] args) {
		//spring bean container
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MobilesConfig.class);
		Mobiles obj=context.getBean("getOnePlusObject",Mobiles.class);
		obj.getModelAndColor();
	}
}
