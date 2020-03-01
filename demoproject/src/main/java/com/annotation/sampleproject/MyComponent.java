package com.annotation.sampleproject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyComponent {
	
	private String componentName;
	
	public MyComponent(String componentName) {
		this.setComponentName(componentName);
		System.out.println("Creating Instance by using qualifier "+ componentName);
	}
	
	@Bean("first")
	public MyComponent first(){
		
		return new MyComponent("first");
		
	}
	
	@Bean("second")
	public MyComponent second(){
		
		return new MyComponent("second");
		
	}
	
	@Bean
	public MyComponent third(){
		
		return new MyComponent("third");
		
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

}
