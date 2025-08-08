package workshop.oop.flexible;

public class FlexibleCompanyDemo {
	public static void main(String[] args) {

		MereClerk mereClerk1 = new MereClerk("ö��", 100);
		MereClerk mereClerk2 = new MereClerk("����", 100);
		Manager manager = new Manager("ȫ�浿", 200);

		// Employee manager2 = new Manager("")

		Manager hrMgr = new Manager("�Ѹ�", 200, "HR");
		System.out.println(hrMgr.getName());
		System.out.println(hrMgr.getSalary());
		System.out.println(hrMgr.getDept());

		// ������(polymorphism)
		Employee itMgr = new Manager("�Ѹ�", 200, "IT");
		System.out.println(itMgr.getName());
		System.out.println(itMgr.getSalary());
		// System.out.println(itMgr.getDept()); �θ� Ŭ����(Employee)�� ��� ����
		// Manager�� ���� getdept�Լ� ȣ��
		Manager itMgr2 = (Manager) itMgr;
		System.out.println(itMgr2.getDept());

		Employee[] emps = new Employee[4];
		emps[0] = new Manager("�浿", 250, "IT");
		emps[1] = new MereClerk("ö��", 100);
		emps[2] = new MereClerk("����", 100);
		emps[3] = new Manager("�Ѹ�", 200, "HR");

		System.out.println("���� �����Դϴ�.");

		printEmployeeInfo(emps);

		System.out.println("");

		System.out.println("�ø� ���� �����Դϴ�.");

		for (Employee employee : emps) {
			employee.manageSalary(10);
		}

		printEmployeeInfo(emps);

	}

	public static void printEmployeeInfo(Employee[] emps) {
		// manager�� dept�� ������ �־
		for (Employee employee : emps) {
			if (employee instanceof Manager) {
				System.out.print("�������� �μ��� = " + ((Manager) employee).getDept() + " ");
				System.out.println(employee.getName() + "�� ���� ������ " + employee.getSalary() + " ���� �Դϴ�.");
			} else {
				System.out.println(employee.getName() + "�� ���� ������ " + employee.getSalary() + " ���� �Դϴ�.");
			}

		}
	}
}
