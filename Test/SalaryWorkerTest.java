import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {
    private SalaryWorker salaryWorker;

    @BeforeEach
    void setUp() {
        // Create a SalaryWorker instance for testing
        salaryWorker = new SalaryWorker("00005678", "Alex", "Johnson", "Mr.", 1985, 0, 52000);
    }

    @Test
    void calculateWeeklyPay() {
        double expectedWeeklyPay = 52000 / 52.0;  // $1000 per week
        assertEquals(expectedWeeklyPay, salaryWorker.calculateWeeklyPay(40), 0.01);
        assertEquals(expectedWeeklyPay, salaryWorker.calculateWeeklyPay(50), 0.01);  // Should be the same for any hours
    }

    @Test
    void displayWeeklyPay() {
        // We are testing that it runs without errors (prints to console)
        assertDoesNotThrow(() -> salaryWorker.displayWeeklyPay(40));
        assertDoesNotThrow(() -> salaryWorker.displayWeeklyPay(50));
    }

    @Test
    void toCSVRecord() {
        String expectedCSV = "00005678,Alex,Johnson,Mr.,1985,0.0,52000.0";
        assertEquals(expectedCSV, salaryWorker.toCSVRecord());
    }

    @Test
    void toXMLRecord() {
        String expectedXML = "<SalaryWorker><Worker><Person>00005678</IDNum><firstName>Alex</firstName><lastName>Johnson</lastName><title>Mr.</title><YOB>1985</YOB></Person><hourlyPayRate>0.0</hourlyPayRate></Worker><annualSalary>52000.0</annualSalary></SalaryWorker>";
        assertEquals(expectedXML, salaryWorker.toXMLRecord());
    }

    @Test
    void toJSONRecord() {
        String expectedJSON = "{\"IDNum\":\"00005678\",\"firstName\":\"Alex\",\"lastName\":\"Johnson\",\"title\":\"Mr.\",\"YOB\":1985,\"hourlyPayRate\":0.0,\"annualSalary\":52000.0}";
        assertEquals(expectedJSON,salaryWorker.toJSONRecord());
    }
}
