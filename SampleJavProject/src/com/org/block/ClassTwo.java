package com.org.block;

class ClassOne
{
    static
    {
        System.out.println(1);
    }
 
    public static void main(String[] args)
    {
        System.out.println(2);
    }
}
 
public class ClassTwo extends ClassOne
{
    {
        System.out.println(3);
    }
 
    public static void main(String[] args)
    {
//    	ClassOne obj = new ClassOne();
//        ClassOne.main(args);
    }
}