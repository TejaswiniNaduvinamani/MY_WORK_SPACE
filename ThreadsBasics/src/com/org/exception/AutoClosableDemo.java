package com.org.exception;

class TestAutoClosable implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("Closing the resoureces");
	}
	
}

public class AutoClosableDemo {
	
	public static void main(String[] args) throws Exception{
		
		try(TestAutoClosable autoClosable = new TestAutoClosable()){
			System.out.println("Entered into try with resources block");
		}
	}
	

}
