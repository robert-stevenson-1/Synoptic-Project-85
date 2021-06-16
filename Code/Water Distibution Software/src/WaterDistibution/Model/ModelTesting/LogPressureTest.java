/**
 *
 * Class:LogPressureTest#
 * Author: Elie Harris#
 * Date Created 15/6/21
 *
 * Description: JUNIT 5 Tests
 *
 * Progress: Passes all basic assertEqualsTests.
 */
package WaterDistibution.Model.ModelTesting;

import WaterDistibution.Model.LogPressure;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LogPressureTest {

    @Test
    void getName() {
        LogPressure l = new LogPressure("Test1", "Lobitos",
                LocalDate.now(), 17, 38, 5.6);
        assertEquals("Test1", l.getName());
    }

    @Test
    void getDistributionArea() {
        LogPressure l = new LogPressure("Test1", "Lobitos",
                LocalDate.now(), 17, 38, 5.6);
        assertEquals("Lobitos", l.getDistributionArea());
    }

    @Test
    void getDate() {
        LogPressure l = new LogPressure("Test1", "Lobitos",
                LocalDate.now(), 17, 38, 5.6);
        assertEquals(LocalDate.now(), l.getDate());
    }

    @Test
    void getStrTime() {
        LogPressure l = new LogPressure("Test1", "Lobitos",
                LocalDate.now(), 17, 38, 5.6);
        assertEquals("17:38", l.getStrTime());
    }

    @Test
    void getTimeHour() {
        LogPressure l = new LogPressure("Test1", "Lobitos",
                LocalDate.now(), 17, 38, 5.6);
        assertEquals(17, l.getTimeHour());
    }

    @Test
    void getTimeMin() {
        LogPressure l = new LogPressure("Test1", "Lobitos",
                LocalDate.now(), 17, 38, 5.6);
        assertEquals(38, l.getTimeMin());
    }

    @Test
    void getWaterPressure() {
        LogPressure l = new LogPressure("Test1", "Lobitos",
                LocalDate.now(), 17, 38, 5.6);
        assertEquals(5.6, l.getWaterPressure());
    }
}