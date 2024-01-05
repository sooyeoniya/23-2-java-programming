
public class CommissionEmployee extends Employee {
	private double grossSales;
	private double cRate;

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getcRate() {
		return cRate;
	}

	public void setcRate(double cRate) {
		this.cRate = cRate;
	}

	public CommissionEmployee() {
		super();
		this.grossSales = 0.0;
		this.cRate = 0.0;
	}

	public CommissionEmployee(double grossSales, double cRate) {
		super();
		this.grossSales = grossSales;
		this.cRate = cRate;
	}

	public CommissionEmployee(String fName, String lName, String sSN, double grossSales, double cRate) {
		super(fName, lName, sSN);
		this.grossSales = grossSales;
		this.cRate = cRate;
	}

	@Override
	public String toString() {
		return "CommissionEmployee [grossSales: " + grossSales + " , cRate: " + cRate + " , " + super.toString() + "]";
	}

	@Override
	public double earnings() {
		// Commission employees are paid a percentage of their sales
		return grossSales * cRate;
	}
}