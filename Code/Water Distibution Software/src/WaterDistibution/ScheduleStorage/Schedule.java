/**
 * Class: Schedule
 * Author: Louis Mayne
 * Contributing Author(s):
 *
 * Date Created: 08/06/2021
 *
 * Description: Holds an ArrayList of Tasks - the ArrayList is serialised instead of the entire class
 *              Creates new lists of Tasks when a user attempts to open one which doesn't exists
 *
 */

package WaterDistibution.ScheduleStorage;

import java.io.*;
import java.util.ArrayList;

public class Schedule {

    ArrayList<Task> schedule;

    private String username;
    private int month;
    private int year;

    public Schedule(String username, int month, int year){
        this.username=username;
        this.month=month;
        this.year=year;
        try{
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+
                    "/data/schedule_"+username+"_"+month+"_"+year+".ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            schedule= (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        }
        //if this schedule hasn't been made before
        catch(FileNotFoundException e){
            schedule = new ArrayList<Task>();
            //schedule.add(new Task(10,10,10,Task.JobType.REFILLRATE,false,false)); Debug add task
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveSchedule(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir")+
                    "/data/schedule_"+username+"_"+month+"_"+year+".ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(schedule);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Add task functions
    public void addTask(int day, int hour, int minute, Task.JobType jobType, boolean isLogged, boolean isComplete){
        schedule.add(new Task(day, hour, minute, jobType, isLogged, isComplete));
    }
    public void addTask(int day, int hour, int minute, Task.JobType jobType){
        schedule.add(new Task(day, hour, minute, jobType, false, false));
    }
    public void addTask(Task task){
        schedule.add(task);
    }

    public void removeTask(Task task){
        schedule.remove(task);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("day\thour\tminute\tjobType\tisLogged\tisComplete\n");
        schedule.forEach((n) -> stringBuilder.append(n.toString()));
        return(stringBuilder.toString());
    }

}
