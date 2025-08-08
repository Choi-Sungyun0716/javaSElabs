package workshop.oop.flexible;

public abstract class Employee {

	private String name;
	protected double salary;

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
	
	}

	//Concrete Method
	public String getName() {
	    return this.name;
	}

	public double getSalary() {
	    return this.salary;
	}
	
	//abstract Method
	public abstract void manageSalary(double rate);

}