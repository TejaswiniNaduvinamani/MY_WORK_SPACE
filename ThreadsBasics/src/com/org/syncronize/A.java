package com.org.syncronize;

class B{
	public String twice(String s){
		return s+s;
	}
}

interface C{
	void test();
}

public class A implements C{
	
	
	public static void main(String[] args) {
		int mark = 50;
		int total=100;
		float per = (float)(mark/total)*100;
		System.out.println(per);
		
		float f[] = new float[5];
		Object obj = f;
		System.out.println(f[0]);
		
		final char ch = 'A';
		
		switch(65){
		case ch:
		System.out.println("65");
		case 66:
			System.out.println("66");
		}
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
