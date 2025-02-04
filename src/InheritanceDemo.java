import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        // Create an ArrayList to hold Worker and SalaryWorker objects
        ArrayList<Worker> workers = new ArrayList<>();

        // Adding 3 Worker instances
        workers.add(new Worker("Andrew", "Johnson", "012345", "Mr.", 1985, 20.0));
        workers.add(new Worker("Candy", "Janson", "234567", "Ms.", 1990, 25.0));
        workers.add(new Worker("Andrew", "Cox", "159756", "Dr.", 1988, 30.0));

        // Adding 3 SalaryWorker instances
        workers.add(new SalaryWorker("213551", "Mark", "Brown", "Mr.", 1983, 0, 52000));
        workers.add(new SalaryWorker("256485", "Olivia", "Davis", "Ms.", 1989, 0, 60000));
        workers.add(new SalaryWorker("342581", "Liam", "Wilson", "Dr.", 1992, 0, 75000));

        // Simulate 3 weekly pay periods
        int[] weeklyHours = {40, 50, 40};  // Week 1 (40h), Week 2 (50h), Week 3 (40h)

        System.out.println("                Weekly Pay Summary for Workers                 ");
        System.out.printf("%-15s %-15s %-15s %-10s\n", "Name", "ID", "Title", "Weekly Pay");
        System.out.println("---------------------------------------------------------------");

        for (int week = 0; week < weeklyHours.length; week++) {
            System.out.println("\nWeek " + (week + 1) + " (Hours Worked: " + weeklyHours[week] + ")");
            System.out.println("---------------------------------------------------------------");

            for (Worker worker : workers) {
                double weeklyPay = worker.calculateWeeklyPay(weeklyHours[week]);
                System.out.printf("%-15s %-15s %-15s $%-10.2f\n",
                        worker.getFirstName() + " " + worker.getLastName(),
                        worker.getIDNum(),
                        worker.getTitle(),
                        weeklyPay);
            }
        }

        System.out.println("===============================================================");
    }
}
