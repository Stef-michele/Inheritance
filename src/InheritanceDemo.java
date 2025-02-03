public class InheritanceDemo {
    public static void main(String[] args) {
        SalaryWorker sw = new SalaryWorker("00001234", "John", "Doe", "Mr.", 1985, 0, 52000);

        sw.displayWeeklyPay(40);  // Displays weekly salary-based pay
        System.out.println(sw.toCSVRecord());
        System.out.println(sw.toXMLRecord());
        System.out.println(sw.toJSONRecord());
    }
}