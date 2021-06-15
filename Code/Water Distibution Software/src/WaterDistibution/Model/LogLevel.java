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

public class LogLevel implements Serializable{

    //private String area = "";
    private String name = "";
    private LocalDate date;
    private int timeHour = 00;
    private int timeMin = 00;
    private double waterLevel = 0.0; //Stored in ?

    public LogLevel(String name,
                    LocalDate date,
                    int timeHour,
                    int timeMin,
                    double waterLevel) {
        this.name = name;
        this.date = date;
        this.timeHour = timeHour;
        this.timeMin = timeMin;
        this.waterLevel = waterLevel;
    }


    /*    public LogLevel(String name,
                     LocalDate date,
                     int timeHour,
                     int timeMin,
                     String area,
                     double waterLevel) {
        this.name = name;
        this.date = date;
        this.timeHour = timeHour;
        this.timeMin = timeMin;
        this.area=area;
        this.waterLevel = waterLevel;
    }*/


    //===========
    //==GETTERS==
    //===========

    //public String getArea(){ return area;}

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

