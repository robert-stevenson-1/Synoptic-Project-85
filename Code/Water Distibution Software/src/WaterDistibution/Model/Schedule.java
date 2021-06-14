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

package WaterDistibution.Model;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Schedule implements Serializable{

    ArrayList<Task> tasks;

    private String username;
    private LocalDate date;

    //Constructor attempts to find a serialised file with the correct username, month and year. If one is not available
    // it creates a new task list
    public Schedule(String username, LocalDate date){
        this.username=username;
        this.date = date;
        this.tasks = new ArrayList<>();
    }

    public Schedule(){
        this.username="";
        this.date = LocalDate.now();
        this.tasks = new ArrayList<>();
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public int getMonth() {
        return date.getMonthValue();
    }

    public int getYear() {
        return date.getYear();
    }

    //Add task functions
    public void addTask(LocalDate date, int hour, int minute, Task.JobType jobType, boolean isLogged, boolean isComplete){
        tasks.add(new Task(date, hour, minute, jobType, isLogged, isComplete));
    }
    public void addTask(LocalDate date, int hour, int minute, Task.JobType jobType){
        tasks.add(new Task(date, hour, minute, jobType, false, false));
    }
    public void addTask(Task task){
        tasks.add(task);
    }

    //Remove task functions
    public void removeTask(Task task){
        tasks.remove(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    //Gets a list of tasks corresponding with the date passed in
    public ArrayList<Task> getTasks(LocalDate date){
        ArrayList<Task> tasksToReturn = new ArrayList<>();
        for(int i = 0; i< tasks.size(); i++){
            if(tasks.get(i).getDate().isEqual(date)){
                tasksToReturn.add(tasks.get(i));
            }
        }
        return tasksToReturn;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("day\thour\tminute\tjobType\tisLogged\tisComplete\n");
        tasks.forEach((n) -> stringBuilder.append(n.toString()));
        return(stringBuilder.toString());
    }

}
