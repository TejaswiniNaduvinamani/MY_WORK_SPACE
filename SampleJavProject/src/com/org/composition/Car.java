package com.org.composition;

public class Car {
	
	private  String color;
	private  int noTyres;
	
	private  Engine engine;
	
	
	Car(String color, int noTyres, String engineName, String engineType, String enginePower ){
		engine= new Engine();
		engine.setEngineName(engineName);
		engine.setEnginePower(enginePower);
		engine.setEngineType(engineType);
		this.color= color;
		this.noTyres = noTyres;
	}
	
	public String getEngineName(){
		return engine.getEngineName();
	}
	
	public String getEngineType(){
		return engine.getEngineType();
	}
	
	public String getEnginePower(){
		return engine.getEnginePower();
	}
	
	
	public static void main(String[] args){
		
		Car car = new Car("Black", 4, "Chevvy", "v8", "300 BHP");
		
		System.out.println(car.getEngineName());
		System.out.println(car.getEnginePower());
		System.out.println(car.getEngineType());
		
	}

}
