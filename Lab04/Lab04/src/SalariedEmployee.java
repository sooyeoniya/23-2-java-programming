
public class SalariedEmployee extends Employee {
	private double weeklySalary;

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	public SalariedEmployee() {
		super();
		this.weeklySalary = 0.0;
	}

	public SalariedEmployee(String fName, String lName, String sSN, double weeklySalary) {
		super(fName, lName, sSN);
		this.weeklySalary = weeklySalary;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [weeklySalary: " + weeklySalary + " , " + super.toString() + "]";
	}

	@Override
	public double earnings() {
		// Salaried employees are paid a fixed weekly salary regardless of the number of hours worked
		return weeklySalary;
	}
}
