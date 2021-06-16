/**
 *
 * Class:LogLevelTest#
 * Author: Elie Harris#
 * Date Created 15/6/21
 *
 * Description: JUNIT 5 Tests
 *
 * Progress: Passes all basic assertEqualsTests.
 */

package WaterDistibution.Model.ModelTesting;

import WaterDistibution.Model.LogLevel;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LogLevelTest {

    @Test
    void getName() {
        LogLevel l = new LogLevel("Test1", LocalDate.now(), 17, 15, 3.2);
        assertEquals("Test1", l.getName());
    }

    @Test
    void getDate() {
        LogLevel l = new LogLevel("Test1", LocalDate.now(), 17, 15, 3.2);
        assertEquals(LocalDate.now(), l.getDate());
    }

    @Test
    void getStrTime() {
        LogLevel l = new LogLevel("Test1", LocalDate.now(), 17, 15, 3.2);
        assertEquals("17:15", l.getStrTime());
    }

    @Test
    void getTimeHour() {
        LogLevel l = new LogLevel("Test1", LocalDate.now(), 17, 15, 3.2);
        assertEquals(17, l.getTimeHour());
    }

    @Test
    void getTimeMin() {
        LogLevel l = new LogLevel("Test1", LocalDate.now(), 17, 15, 3.2);
        assertEquals(15, l.getTimeMin());
    }

    @Test
    void getWaterLevel() {
        LogLevel l = new LogLevel("Test1", LocalDate.now(), 17, 15, 3.2);
        assertEquals(3.2, l.getWaterLevel(), 0.1);
    }
}