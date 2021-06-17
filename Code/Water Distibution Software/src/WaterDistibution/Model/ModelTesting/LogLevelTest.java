/**
 *
 * Class:LogLevelTest#
 * Author: Elie Harris#
 * Date Created 14/6/21
 *
 * Description: JUNIT 5 Tests
 *
 * Progress: Passes all basic assertEqualsTests.
 * Object creation works great
 * Incorrect time values can be stored in hrs - Awaiting fix
 *
 * **IMPORTANT Boundaries need to be added to this class to avoid incorrect
 * data being put into the system.
 */

package WaterDistibution.Model.ModelTesting;

import WaterDistibution.Model.LogLevel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LogLevelTest {

    @Test
    void testObjectCreation() {
        LogLevel l = new LogLevel("Test1", LocalDate.now(), 17, 15, 3.2);
        assertAll("Test Building a LogLevelTest",
                () -> assertEquals("Test1", l.getName()),
                () -> assertEquals(LocalDate.now(), l.getDate()),
                () -> assertEquals(17, l.getTimeHour()),
                () -> assertEquals(15, l.getTimeMin()),
                () -> assertEquals(3.2, l.getWaterLevel(), 0.1)
    );
    }
    @Disabled("A Log Level will take 35 & -1 as an hour value.")
    @Test
    void testHourExtremes(){
        LogLevel l = new LogLevel("Test1", LocalDate.now(), -1, 15, 3.2);
        assertThrows(IllegalArgumentException.class,
                () -> System.out.print(l.getTimeHour())
                );
    }
    @Disabled("A Log Level will take 75 as a minute value.")
    @Test
    void testMinsExtremes(){
        LogLevel l = new LogLevel("Test1", LocalDate.now(), 17, -3, 7.2);
        assertThrows(IllegalArgumentException.class,
                () -> System.out.println(l.getTimeMin())
                );
    }

    @Disabled("Works as expected fix needed for timeHour and timeMin values")
    @Test
    void testGetStrTime(){
        LogLevel l = new LogLevel("Test1", LocalDate.now(), 1024, -3, 7.2);
        assertEquals("1024:-3", l.getStrTime());
    }
}