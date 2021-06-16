/**
 *
 * Class:ScheduleTest#
 * Author: Elie Harris#
 * Date Created 15/6/21
 *
 * Description: JUNIT 5 Tests
 *
 * Progress: few methods pass basic test
 */
package WaterDistibution.Model.ModelTesting;

import WaterDistibution.Model.Schedule;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {

    @Test
    void setTasks() {
    }

    @Test
    void getMonth() {
        Schedule s = new Schedule("Tester1", LocalDate.now());
        assertEquals(LocalDate.now().getMonthValue(), s.getMonth());
    }

    @Test
    void getYear() {
        Schedule s = new Schedule("Tester1", LocalDate.now());
        assertEquals(LocalDate.now().getYear(), s.getYear());
    }

    @Test
    void addTask() {
    }

    @Test
    void testAddTask() {
    }

    @Test
    void testAddTask1() {
    }

    @Test
    void removeTask() {
    }

    @Test
    void getTasks() {
    }

    @Test
    void testGetTasks() {
    }

    @Test
    void testToString() {
    }
}