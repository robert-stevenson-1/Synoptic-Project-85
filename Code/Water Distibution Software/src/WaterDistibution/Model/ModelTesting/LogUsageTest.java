/**
 *
 * Class:LogUsageTest#
 * Author: Elie Harris#
 * Date Created 15/6/21
 *
 * Description: JUNIT 5 Tests
 *
 * Progress: Passes all basic assertEqualsTests.
 */
package WaterDistibution.Model.ModelTesting;

import WaterDistibution.Model.LogUsage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LogUsageTest {

    @Test
    void getName() {
        LogUsage l = new LogUsage("Test1", "Lobitos", LocalDate.now(),
                12, 30, 0.8);
        assertEquals("Test1", l.getName());
    }

    @Test
    void getDistributionArea() {
        LogUsage l = new LogUsage("Test1", "Lobitos", LocalDate.now(),
                12, 30, 0.8);
        assertEquals("Lobitos", l.getDistributionArea());
    }

    @Test
    void getDate() {
        LogUsage l = new LogUsage("Test1", "Lobitos", LocalDate.now(),
                12, 30, 0.8);
        assertEquals(LocalDate.now(), l.getDate());
    }

    @Test
    void getStrTime() {
        LogUsage l = new LogUsage("Test1", "Lobitos", LocalDate.now(),
                12, 30, 0.8);
        assertEquals("12:30", l.getStrTime());
    }

    @Test
    void getTimeHour() {
        LogUsage l = new LogUsage("Test1", "Lobitos", LocalDate.now(),
                12, 30, 0.8);
        assertEquals(12, l.getTimeHour());
    }

    @Test
    void getTimeMin() {
        LogUsage l = new LogUsage("Test1", "Lobitos", LocalDate.now(),
                12, 30, 0.8);
        assertEquals(30, l.getTimeMin());
    }

    @Test
    void getWaterUsaged() {
        LogUsage l = new LogUsage("Test1", "Lobitos", LocalDate.now(),
                12, 30, 0.8);
        assertEquals(0.8, l.getWaterUsaged());
    }
}