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

public class Schedule implements Serializable{

    ArrayList<Task> tasks;

    private String username;
    private int month;
    private int year;

    //Constructor attempts to find a serialised file with the correct username, month and year. If one is not available
    // it creates a new task list
    public Schedule(String username, int month, int year){
        this.username=username;
        this.month=month;
        this.year=year;
        this.tasks = new ArrayList<>();
    }

    public Schedule(){
        this.username="";
        this.month=1;
        this.year=0000;
        this.tasks = new ArrayList<>();
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    //Add task functions
    public void addTask(int day, int hour, int minute, Task.JobType jobType, boolean isLogged, boolean isComplete){
        tasks.add(new Task(day, hour, minute, jobType, isLogged, isComplete));
    }
    public void addTask(int day, int hour, int minute, Task.JobType jobType){
        tasks.add(new Task(day, hour, minute, jobType, false, false));
    }
    public void addTask(Task task){
        tasks.add(task);
    }

    //Remove task functions
    public void removeTask(Task task){
        tasks.remove(task);
    }

    //Gets a list of tasks corresponding in values to the ones passed in
    public ArrayList<Task> getTasks(int day, int hour){
        ArrayList<Task> tasksToReturn = new ArrayList<>();
        for(int i = 0; i< tasks.size(); i++){
            if(tasks.get(i).getDay()==day && (hour==-1 || tasks.get(i).getHour()==hour)){
                tasksToReturn.add(tasks.get(i));
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
        tasks.forEach((n) -> stringBuilder.append(n.toString()));
        return(stringBuilder.toString());
    }

}
