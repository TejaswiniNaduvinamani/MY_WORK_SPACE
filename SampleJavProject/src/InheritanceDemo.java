
class SuperClass{
	
	void methodOne(){
		System.out.println("from super class");
	}
	
}

class SubClass extends SuperClass{
	void methodOne(){
		super.methodOne();
		System.out.println("from sub class");
	}
}

public class InheritanceDemo {
	
	public static void main(String[] args){
		
		SuperClass supObj = new SuperClass();
//		SubClass subObj = (SubClass)supObj; -- Runtime Exception -- ClassCastException
		SubClass subObj = new SubClass();
		SuperClass supObj1 = subObj;
		subObj.methodOne();
		supObj.methodOne();
		supObj1.methodOne();
	}

}
