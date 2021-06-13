/**
 * Class: LogUsage
 * Author: Ipek
 * Contributing Author(s):
 *
 * Date Created: 13/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Model;
import java.io.Serializable;
import java.time.LocalDate;

public class LogRefill implements Serializable{
    private String name = "";
    private LocalDate date;
    private int timeHour = 00;
    private int timeMin = 00;
    private double waterLevel = 0.0; //Stored in ?
    //private double refillRate

    public LogRefill(String name,
                     LocalDate date,
                     int timeHour,
                     int timeMin) {
        this.name = name;
        this.date = date;
        this.timeHour = timeHour;
        this.timeMin = timeMin;
        this.waterLevel = waterLevel;
    }

    //===========
    //==GETTERS==
    //===========

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStrTime() {
        return timeHour + ":" + timeMin ;
    }

    public int getTimeHour() {
        return timeHour;
    }

    public int getTimeMin() {
        return timeMin;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

}

