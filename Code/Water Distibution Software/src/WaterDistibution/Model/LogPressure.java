package WaterDistibution.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class LogPressure implements Serializable{

        private String name = "";
        private String distributionArea = "";
        private LocalDate date;
        private int timeHour = 00;
        private int timeMin = 00;
        private double waterPressure = 0.0; //Stored in Pa

        public LogPressure(String name,
                        String distributionArea,
                        LocalDate date,
                        int timeHour,
                        int timeMin,
                        double waterPressure) {
            this.name = name;
            this.distributionArea = distributionArea;
            this.date = date;
            this.timeHour = timeHour;
            this.timeMin = timeMin;
            this.waterPressure = waterPressure;
        }


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

        public double getWaterPressure() {
            return waterPressure;
        }


        //===========
        //==SETTERS==
        //===========

    }


