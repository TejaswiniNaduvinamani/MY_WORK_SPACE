package com.org.thread;

class Building  
{ 
    Building()  
    { 
        System.out.println("Geek-Buiding"); 
    } 
    Building(String name)  
    { 
        this(); 
        System.out.println("Geek-building: String Constructor" + name); 
    } 
} 
public class House extends Building  
{ 
    House()  
    { 
        System.out.println("Geek-House "); 
    } 
    House(String name)  
    { 
        this(); 
        System.out.println("Geek-house: String Constructor" + name); 
    } 
    public static void main(String[] args)  
    { 
        new House("Geek"); 
    } 
} 
