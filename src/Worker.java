public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyPayRate;
        } else {
            double overtime = (hoursWorked - 40) * (hourlyPayRate * 1.5);
            return (40 * hourlyPayRate) + overtime;
        }
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        double totalPay = calculateWeeklyPay(hoursWorked);

        System.out.println("Regular Hours: " + regularHours + " | Overtime Hours: " + overtimeHours);
        System.out.println("Total Pay: $" + totalPay);
    }

    @Override
    public String toCSVRecord() {
        return super.toCSVRecord() + "," + hourlyPayRate;
    }

    @Override
    public String toXMLRecord() {
        return "<Worker>" + super.toXMLRecord() + "<HourlyPayRate>" + hourlyPayRate + "</HourlyPayRate></Worker>";
    }

    @Override
    public String toJSONRecord() {
        return "{" + super.toJSONRecord() + ", \"hourlyPayRate\": " + hourlyPayRate + "}";
    }
}

