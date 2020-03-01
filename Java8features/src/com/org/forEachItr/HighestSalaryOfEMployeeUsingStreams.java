package com.org.forEachItr;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

class EmployeeDTO {
	
	Integer id;
	BigDecimal salary;
	public Integer getId() {
		return id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	String name;
	
	EmployeeDTO(Integer id,	BigDecimal salary,	String name){
		this.id= id;
		this.name=name;
		this.salary=salary;
		
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id==((EmployeeDTO)obj).id ;
	}
}

class SalaryComparator implements Comparator<EmployeeDTO>{

	@Override
	public int compare(EmployeeDTO o1, EmployeeDTO o2) {
		return o1.salary.compareTo(o2.salary);
	}
	
}

public class HighestSalaryOfEMployeeUsingStreams {

	void findHighestSalary(List<EmployeeDTO> list, BiPredicate<Integer, Integer> p) {
		
//		for(EmployeeDTO dto : list){
//			dto.
//		}

	}

	public static void main(String[] args) {
		
		List<EmployeeDTO> list = new ArrayList<>();
		EmployeeDTO employee = new EmployeeDTO(1, new BigDecimal(12000), "Employee1");
		EmployeeDTO employee2 = new EmployeeDTO(2, new BigDecimal(13000), "Employee2");		
		EmployeeDTO employee3 = new EmployeeDTO(3, new BigDecimal(14000), "Employee3");
		EmployeeDTO employee4 = new EmployeeDTO(4, new BigDecimal(10000), "Employee4");
		EmployeeDTO employee5 = new EmployeeDTO(5, new BigDecimal(9000), "Employee5");
		list.add(employee5);
		list.add(employee4);
		list.add(employee3);
		list.add(employee2);
		list.add(employee);
		Optional<EmployeeDTO> op=list.stream().max((o1,o2) ->o1.salary.compareTo(o2.salary));
		
		list.stream().max((o1,o2) ->o1.salary.compareTo(o2.salary)).ifPresent(s -> System.out.print(s.getName()) );
		
		op.ifPresent((i) -> System.out.println(i.getName()));
		if(op.isPresent()){
			System.out.println(op.get().getName());
		}
		
		ToIntBiFunction<Integer,Integer> add = (a,b) -> a + b;
		System.out.println(add.applyAsInt(1, 2));
		
		Predicate<Integer> isGreaterThan10 = (i) -> i>10;
		System.out.println(isGreaterThan10.test(15));
	}
}
