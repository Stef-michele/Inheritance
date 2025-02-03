public class SalaryWorker extends Worker {
    private double annualSalary;

    // Constructor using super() to call Worker
    public SalaryWorker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(IDNum, firstName, lastName, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    // Overriding calculateWeeklyPay
    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;  // Fixed weekly pay
    }

    // Overriding displayWeeklyPay
    @Override
    public void displayWeeklyPay(double hoursWorked) {
        System.out.println("Weekly Pay: $" + calculateWeeklyPay(hoursWorked) + " (Based on annual salary)");
    }

    // Overriding toCSVRecord
    @Override
    public String toCSVRecord() {
        return super.toCSVRecord() + "," + annualSalary;
    }

    // Overriding toXMLRecord
    @Override
    public String toXMLRecord() {
        return "<SalaryWorker>" + super.toXMLRecord() + "<annualSalary>" + annualSalary + "</annualSalary></SalaryWorker>";
    }

    // Overriding toJSONRecord
    @Override
    public String toJSONRecord() {
        return "{" + super.toJSONRecord().replace("}", "") + ", \"annualSalary\": " + annualSalary + "}";
    }
}
