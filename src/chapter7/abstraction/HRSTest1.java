package chapter7.abstraction;

abstract class Employee1 {
	String name;
	int salary;

	public abstract void calcSalary();
	public abstract void calcBonus();
}

class Salesman1 extends Employee1 {
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}
	
	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급*12*4");
	}
}

class Consultant1 extends Employee1 {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}
	
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급*12*2");
	}
}

abstract class Manager1 extends Employee1 {
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}

}

class Director1 extends Manager1 {
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급*12*6");
	}
}

public class HRSTest1 {

	public static void main(String[] args) {
		Salesman1 s = new Salesman1();
		Consultant1 c = new Consultant1();
		Director1 d = new Director1();

		s.calcBonus();
		c.calcBonus();
		d.calcBonus();
	}
}
