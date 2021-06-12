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

    //Constructor attempts to find a serialised file with the correct username, month and year. If one is not available
    // it creates a new task list
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

    //Saves the ArrayList so it can be accessed again by any new Schedule object on the next run
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

    //Remove task functions
    public void removeTask(Task task){
        schedule.remove(task);
    }

    //Gets a list of tasks corresponding in values to the ones passed in
    public ArrayList<Task> getTasks(int day, int hour){
        ArrayList<Task> tasksToReturn = new ArrayList<>();
        for(int i=0;i<schedule.size();i++){
            if(schedule.get(i).getDay()==day && (hour==-1 || schedule.get(i).getHour()==hour)){
                tasksToReturn.add(schedule.get(i));
            }
        }
        return tasksToReturn;
    }
    public ArrayList<Task> getTasks(int day){
        return getTasks(day,-1);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("day\thour\tminute\tjobType\tisLogged\tisComplete\n");
        schedule.forEach((n) -> stringBuilder.append(n.toString()));
        return(stringBuilder.toString());
    }

}
