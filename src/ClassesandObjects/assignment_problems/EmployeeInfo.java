package ClassesandObjects.assignment_problems;

public class EmployeeInfo {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeInfo e1 = new EmployeeInfo("Rohan", 50000);
        EmployeeInfo e2 = new EmployeeInfo("Divya", 65000);
        EmployeeInfo e3 = new EmployeeInfo("Arjun", 30000);

        EmployeeInfo.printCompanyInfo();
    }
}
