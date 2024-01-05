
public class HourlyEmployee extends Employee {
	private double wage;
	private double hours;

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public HourlyEmployee() {
		super();
		this.wage = 0.0;
		this.hours = 0.0;
	}

	public HourlyEmployee(String fName, String lName, String sSN, double wage, double hours) {
		super(fName, lName, sSN);
		this.wage = wage;
		this.hours = hours;
	}

	public HourlyEmployee(double wage, double hours) {
		super();
		this.wage = wage;
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "HourlyEmployee [Wage: " + wage + " , hours: " + hours + " , " + super.toString() + "]";
	}

	@Override
	public double earnings() {
		// Hourly employees are paid by the hour and receive overtime pay for all hours worked in excess of 40 hours
		// i.e., 1.5 times their hourly salary rate
		double ic = 0.0;
		if (hours <= 40)
			ic = hours * wage;
		else
			ic = (40 * wage) + ((hours - 40) * (wage * 1.5));
		return ic;
	}
}
