package workshop.oop.flexible;

public class FlexibleCompanyDemo {
	public static void main(String[] args) {

		MereClerk mereClerk1 = new MereClerk("철수", 100);
		MereClerk mereClerk2 = new MereClerk("영희", 100);
		Manager manager = new Manager("홍길동", 200);

		// Employee manager2 = new Manager("")

		Manager hrMgr = new Manager("둘리", 200, "HR");
		System.out.println(hrMgr.getName());
		System.out.println(hrMgr.getSalary());
		System.out.println(hrMgr.getDept());

		// 다형성(polymorphism)
		Employee itMgr = new Manager("둘리", 200, "IT");
		System.out.println(itMgr.getName());
		System.out.println(itMgr.getSalary());
		// System.out.println(itMgr.getDept()); 부모 클래스(Employee)에 없어서 오류
		// Manager가 가진 getdept함수 호출
		Manager itMgr2 = (Manager) itMgr;
		System.out.println(itMgr2.getDept());

		Employee[] emps = new Employee[4];
		emps[0] = new Manager("길동", 250, "IT");
		emps[1] = new MereClerk("철수", 100);
		emps[2] = new MereClerk("영희", 100);
		emps[3] = new Manager("둘리", 200, "HR");

		System.out.println("현재 월급입니다.");

		printEmployeeInfo(emps);

		System.out.println("");

		System.out.println("올린 후의 월급입니다.");

		for (Employee employee : emps) {
			employee.manageSalary(10);
		}

		printEmployeeInfo(emps);

	}

	public static void printEmployeeInfo(Employee[] emps) {
		// manager만 dept를 가지고 있어서
		for (Employee employee : emps) {
			if (employee instanceof Manager) {
				System.out.print("관리자의 부서명 = " + ((Manager) employee).getDept() + " ");
				System.out.println(employee.getName() + "의 현재 월급은 " + employee.getSalary() + " 만원 입니다.");
			} else {
				System.out.println(employee.getName() + "의 현재 월급은 " + employee.getSalary() + " 만원 입니다.");
			}

		}
	}
}
