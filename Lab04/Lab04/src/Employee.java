
public class Employee {
	private String fName;
	private String lName;
	private String SSN;

	public Employee() {
		this.fName = "";
		this.lName = "";
		SSN = "";
	}

	public Employee(String fName, String lName, String sSN) {
		this.fName = fName;
		this.lName = lName;
		SSN = sSN;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	@Override
	public String toString() {
		return "Fisrt Name: " + fName + " , Last Name: " + lName + " , SSN: " + SSN;
	}

	public double earnings() {
		double ic = 0.0;
		return ic;
	}
}
