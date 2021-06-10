package WaterDistibution;

import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CreateUserLogin {
    String firstName;
    String lastName;
    String email;
    String password;
    int age;
    //should username be static? double check with robert.
    String username;
    String gender;
    String location;

    public CreateUserLogin(){}
    public CreateUserLogin(String firstName,String lastName, String email,String username,String password,int age,String gender, String location){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.username = username;
        this.gender = gender;
        this.location = location;
    }




}
