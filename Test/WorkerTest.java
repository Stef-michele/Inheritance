import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    private Worker worker;

    @BeforeEach
    void setUp() {
        // Initialize the Worker object before each test
        worker = new Worker("00001234", "Jane", "Doe", "Ms.", 1990, 20.0);
    }

    @Test
    void calculateWeeklyPay_regularHours() {
        double hoursWorked = 40; // Regular hours
        double expectedPay = 40 * 20.0; // $800
        assertEquals(expectedPay, worker.calculateWeeklyPay(hoursWorked), 0.01);
    }

    @Test
    void calculateWeeklyPay_overtimeHours() {
        double hoursWorked = 50; // 10 hours of overtime
        double expectedPay = (40 * 20.0) + (10 * 20.0 * 1.5); // $800 + $300 = $1100
        assertEquals(expectedPay, worker.calculateWeeklyPay(hoursWorked), 0.01);
    }

    @Test
    void displayWeeklyPay() {
        // This method prints output, which is tricky to test directly.
        // You can redirect System.out if needed, but for simplicity, we'll just ensure no exceptions are thrown.
        assertDoesNotThrow(() -> worker.displayWeeklyPay(40));
        assertDoesNotThrow(() -> worker.displayWeeklyPay(50));
    }

    @Test
    void toCSVRecord() {
        String expectedCSV = "00001234,Jane,Doe,Ms.,1990,20.0";
        assertEquals(expectedCSV, worker.toCSVRecord());
    }

    @Test
    void toXMLRecord() {
        String expectedXML = "<Worker><Person>00001234</IDNum><firstName>Jane</firstName><lastName>Doe</lastName><title>Ms.</title><YOB>1990</YOB></Person><hourlyPayRate>20.0</hourlyPayRate></Worker>";
        assertEquals(expectedXML, worker.toXMLRecord());
    }

    @Test
    void toJSONRecord() {
        String expectedJSON = "{\"IDNum\":\"00001234\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"title\":\"Ms.\",\"YOB\":1990, \"hourlyPayRate\": 20.0}";
        assertEquals(expectedJSON, worker.toJSONRecord());
    }
}