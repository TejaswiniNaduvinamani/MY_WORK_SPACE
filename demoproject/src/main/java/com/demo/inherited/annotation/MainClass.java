package com.demo.inherited.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class MainClass {
	
	
	public static void  main(String[] args){
		
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext (AppExConfig.class);
		
		C a= context.getBean(C.class);
		a.display();
		
		System.out.println(new A().getClass().getAnnotation(InheritAnnotationExampleClass.class));
		System.out.println(new B().getClass().getAnnotation(InheritAnnotationExampleClass.class));
		System.out.println(new C().getClass().getAnnotation(InheritAnnotationExampleClass.class));
		System.out.println(new B().getClass().isAnnotationPresent(Component.class));
		System.out.println(new C().getClass().isAnnotationPresent(Component.class));

		System.out.println("_________________________________");
		System.out.println(new A().getClass().getAnnotation(UnInheritedAnnotationExamplClass.class));
		System.out.println(new B().getClass().getAnnotation(UnInheritedAnnotationExamplClass.class));
		System.out.println(new C().getClass().getAnnotation(UnInheritedAnnotationExamplClass.class));
		
	}
}
