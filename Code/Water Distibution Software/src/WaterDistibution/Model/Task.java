/**
 * Class: Task
 * Author: Louis Mayne
 * Contributing Author(s):
 *
 * Date Created: 08/06/2021
 *
 * Description: Holds all the information for a single task
 *
 */

package WaterDistibution.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    static final long serialVersionUID = 101L;
    //User is not stored within class as that's within the schedule
    //Time information is stored as ints - the month and year is decided by which schedule item the task is in
    private LocalDate date;
    private int hour;
    private int minute;
    //JobType is stored as an enum
    private JobType jobType;
    public static enum JobType{WATER_LEVEL, WATER_USAGE, WATER_PRESSURE, DISTRIBUTE_WATER}
    //Status of the task
    private boolean isLogged;
    private boolean isComplete;

    public Task(LocalDate date, int hour, int minute, JobType jobType, boolean isLogged, boolean isComplete){
        this.date=date;
        this.hour=hour;
        this.minute=minute;
        this.jobType=jobType;
        this.isLogged=isLogged;
        this.isComplete=isComplete;
    }

    //Accessor methods
    public LocalDate getDate() {
        return date;
    }
    public int getHour(){return hour;}
    public int getMinute(){return minute;}
    public JobType getJobType(){return jobType;}
    public boolean getIsLogged(){return isLogged;}
    public boolean getIsComplete(){return isComplete;}
    public void setHour(int hour){this.hour=hour;}
    public void setMinute(int minute){this.minute = minute;}
    public void setJobType(JobType jobType){this.jobType = jobType;}
    public void setIsLogged(boolean isLogged){this.isLogged = isLogged;}
    public void setIsComplete(boolean isComplete){this.isComplete = isComplete;}
/*
    public String toString(){
        return date+"\t"+hour+"\t"+minute+"\t"+jobType+"\t"+isLogged+"\t"+isComplete+"\n";
    }
    */

/*    @Override
    public String toString() {
        return "Task{" +
                "date=" + date +
                ", hour=" + hour +
                ", minute=" + minute +
                ", jobType=" + jobType +
                ", isLogged=" + isLogged +
                ", isComplete=" + isComplete +
                '}';
    }*/
}
