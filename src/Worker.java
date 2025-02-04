public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(ID, firstName, lastName, title, YOB);
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
        return "<Worker>" + super.toXMLRecord() + "<hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate></Worker>";
    }

    @Override
    public String toJSONRecord() {
        String baseJson = super.toJSONRecord();
        // Remove the final closing brace to append additional data
        baseJson = baseJson.substring(0, baseJson.length() - 1);
        return baseJson + ",\"hourlyPayRate\":" + hourlyPayRate + "}";
    }
}

