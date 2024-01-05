
public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public BasePlusCommissionEmployee(String fName, String lName, String sSN, double grossSales, double cRate,
			double baseSalary) {
		super(fName, lName, sSN, grossSales, cRate);
		this.baseSalary = baseSalary;
	}

	public BasePlusCommissionEmployee(double baseSalary) {
		super();
		this.baseSalary = baseSalary;
	}

	@Override
	public String toString() {
		return "BasePlusCommissionEmployee [baseSalary = " + baseSalary + " , " + super.toString() + "]";
	}

	@Override
	public double earnings() {
		// Base-salaried commission employees receive a base salary plus a percentage of their sales
		return baseSalary + super.earnings();
	}
}