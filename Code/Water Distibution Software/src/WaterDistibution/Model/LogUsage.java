/**
 * Class: LogUsage
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 10/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class LogUsage implements Serializable {

   private String name = "";
   private String distributionArea = "";
   private LocalDate date;
   private int timeHour = 00;
   private int timeMin = 00;
   private double waterUsaged = 0.0; //Stored in litres

   public LogUsage(String name,
                   String distributionArea,
                   LocalDate date,
                   int timeHour,
                   int timeMin,
                   double waterUsaged) {
      this.name = name;
      this.distributionArea = distributionArea;
      this.date = date;
      this.timeHour = timeHour;
      this.timeMin = timeMin;
      this.waterUsaged = waterUsaged;
   }

   //===========
   //==GETTERS==
   //===========

   public String getName() {
      return name;
   }

   public String getDistributionArea() {
      return distributionArea;
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

   public double getWaterUsaged() {
      return waterUsaged;
   }


   //===========
   //==SETTERS==
   //===========

}
