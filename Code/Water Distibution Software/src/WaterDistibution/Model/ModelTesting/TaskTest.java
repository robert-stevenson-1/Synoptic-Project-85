/**
 *
 * Class:TaskTest#
 * Author: Elie Harris#
 * Date Created 16/6/21
 *
 * Description: JUNIT 5 Tests
 *
 * Progress:All Basic tests Passed
 */
package WaterDistibution.Model.ModelTesting;

import WaterDistibution.Model.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    void getDate() {
        Task t = new Task(LocalDate.now(), 20,21,
                Task.JobType.WATER_LEVEL, true, false);
        assertEquals(LocalDate.now(), t.getDate());
    }
    @Test
    void setHour() {
        Task t = new Task(LocalDate.now(), 20,21,
                Task.JobType.WATER_LEVEL, true, false);
        assertEquals(20, t.getHour());
        t.setHour(99);
        assertEquals(99, t.getHour());
    }

    @Test
    void setMinute() {
        Task t = new Task(LocalDate.now(), 20,21,
                Task.JobType.WATER_LEVEL, true, false);
        assertEquals(21, t.getMinute());
        t.setMinute(24);
        assertEquals(24, t.getMinute());
    }

    @Test
    void setJobType() {
        Task t = new Task(LocalDate.now(), 20,21,
                Task.JobType.WATER_LEVEL, true, false);
        assertEquals(Task.JobType.WATER_LEVEL, t.getJobType());
        t.setJobType(Task.JobType.WATER_PRESSURE);
        assertEquals(Task.JobType.WATER_PRESSURE, t.getJobType());
    }

    @Test
    void setIsLogged() {
        Task t = new Task(LocalDate.now(), 20,21,
                Task.JobType.WATER_LEVEL, true, false);
        assertEquals(true, t.getIsLogged());
        t.setIsLogged(false);
        assertEquals(false, t.getIsLogged());
    }

    @Test
    void setIsComplete() {
        Task t = new Task(LocalDate.now(), 20,21,
                Task.JobType.WATER_LEVEL, true, false);
        assertEquals(false, t.getIsComplete());
        t.setIsComplete(true);
        assertEquals(true, t.getIsComplete());
    }
}