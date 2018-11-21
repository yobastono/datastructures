package list;

public class Employee_Company_A {

	private static int id = 0;
	private String name;
	private int idEmp;

	public static int getId() {
		return id;
	}

	public Employee_Company_A(String name) {
		this.name = name;
		id++;
		this.idEmp = id;
	}

	public static void setId(int id) {
		Employee_Company_A.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee_Company_A [name=" + name + ", idEmp=" + idEmp + "]";
	}

	

}
