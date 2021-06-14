/**
 * Class: DataStorage
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */
package WaterDistibution;

import WaterDistibution.Exceptions.InvalidPasswordException;
import WaterDistibution.Exceptions.NoSuchUsernameExists;
import WaterDistibution.Model.LogPressure;
import WaterDistibution.Model.LogRefill;
import WaterDistibution.Model.LogUsage;
import WaterDistibution.Model.User;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public abstract class DataStorage implements Serializable {

   private static HashMap<String, User> users = new HashMap<>();
   //user is currently logged into the system
   private static User CurrentUser = new User();

   //Water usage logs
   private static ArrayList<LogUsage> waterUsageLogs = new ArrayList<>();

   //Distribution areas
   private static ArrayList<String> distributionAreas = new ArrayList<>();

   private static ArrayList<LogRefill> waterRefillLogs = new ArrayList<>();

   //water pressure
   private static ArrayList<LogPressure> waterPressureLogs = new ArrayList<>();

   //-------------
   //---SETTERS---
   //-------------

   public static void setCurrentUser(User currentUser) {
      CurrentUser = currentUser;
   }

   public static void addWaterUsageLogs(LogUsage waterUsageLog) {
      DataStorage.waterUsageLogs.add(waterUsageLog);
   }

   public static void addWaterRefillLogs(LogRefill waterRefillLogs){DataStorage.waterRefillLogs.add(waterRefillLogs);}

   public static void addWaterPressureLogs(LogPressure waterPressureLogs){DataStorage.waterPressureLogs.add(waterPressureLogs);}

   public static void addDistributionArea(String distributionArea) {
      DataStorage.distributionAreas.add(distributionArea);
   }

   //-------------
   //---GETTERS---
   //-------------
   
   public static ArrayList<String> getDistributionAreas() {
      return distributionAreas;
   }

   public static boolean userExists(String username){
      return users.containsKey(username);
   }

   //gets a user that is saved in the system
   public static User getUser(String username, String password) throws NoSuchUsernameExists, InvalidPasswordException {
      //check if a user with that username exists
      if (userExists(username)){
         //user found, check to see if the password entered is correct
         User user = users.get(username);
         if(user.getPassword().equals(hashPassword(password, user.getSalt()))){
            //password matches return the user
            return user;
         }else {
            throw new InvalidPasswordException();
         }
      }else{
         throw new NoSuchUsernameExists();
      }
   }

   public static ArrayList<LogUsage> getWaterUsageLogs() {
      return waterUsageLogs;
   }

   //refill
   public static ArrayList<LogRefill> getWaterRefillLogs(){ return waterRefillLogs;}

   //get pressure
   public static ArrayList<LogPressure> getWaterPressureLogs(){return waterPressureLogs;}

   //get the current logged in user
   public static User getCurrentUser() {
      return CurrentUser;
   }

   //-----------
   //--UTILITY--
   //-----------

   public static void saveData(){
      saveUsers();
      saveWaterUsageLogs();
      saveDistributionAreas();
   }

   public static void loadData(){

      loadUsers();
      loadWaterUsageLogs();
      loadDistributionAreas();
   }

   /**
    * Saves the programs users into a serializable file.
    * @return return true on success, false on failure to save.
    */
   public static boolean saveUsers(){
      try{
         //output file location
         FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"/data/users.ser");
         //write the user hashmap
         ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
         objOut.writeObject(users);
         objOut.close();
         return true;
      } catch (IOException e){
         e.printStackTrace();
         System.out.println("Failed to serialize users");
         return false;
      }
   }

   public static boolean saveWaterUsageLogs(){
      try{
         //output file location
         FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"/data/WaterUsageLogs.ser");
         //write the user hashmap
         ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
         objOut.writeObject(waterUsageLogs);
         objOut.close();
         return true;
      } catch (IOException e){
         e.printStackTrace();
         System.out.println("Failed to serialize WaterUsageLogs");
         return false;
      }
   }

   public static boolean saveDistributionAreas(){
      try{
         //output file location
         FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"/data/DistributionAreas.ser");
         //write the user hashmap
         ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
         objOut.writeObject(distributionAreas);
         objOut.close();
         return true;
      } catch (IOException e){
         e.printStackTrace();
         System.out.println("Failed to serialize DistributionAreas");
         return false;
      }
   }
   public static void saveWaterRefillLogs(){
      try{
         FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"/data/WaterRefillLogs.ser");
         ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
         objOut.writeObject(waterRefillLogs);
         objOut.close();
      }catch (IOException e){
         e.printStackTrace();
         System.out.println("Failed to serialize WaterRefillLogs");
      }
   }

   public static void saveWaterPressureLogs(){
      try{
         //output file location
         FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"/data/WaterPressureLogs.ser");
         //write the user hashmap
         ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
         objOut.writeObject(waterPressureLogs);
         objOut.close();
      } catch (IOException e){
         e.printStackTrace();
         System.out.println("Failed to serialize WaterPressureLogs");
      }
   }


   public static boolean loadUsers(){
      try {
         FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir")+"/data/users.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         users = (HashMap<String, User>) in.readObject();
         in.close();
         fileIn.close();
         return true;
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Failed to load users");
         return false;
      } catch (ClassNotFoundException e) {
         System.out.println("Class HashMap<String,User> users not found");
         e.printStackTrace();
         return false;
      }
   }

   public static boolean loadWaterUsageLogs(){
      try {
         FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir")+"/data/WaterUsageLogs.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         waterUsageLogs = (ArrayList<LogUsage>) in.readObject();
         in.close();
         fileIn.close();
         return true;
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Failed to load WaterUsageLogs");
         return false;
      } catch (ClassNotFoundException e) {
         System.out.println("Class ArrayList<LogUsage> waterUsageLogs not found");
         e.printStackTrace();
         return false;
      }
   }
   public static void loadWaterPressureLogs(){
      try {
         FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir")+"/data/WaterPressureLogs.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         waterPressureLogs = (ArrayList<LogPressure>) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Failed to load WaterPressureLogs");
      } catch (ClassNotFoundException e) {
         System.out.println("Class ArrayList<LogPressure> waterPressureLogs not found");
         e.printStackTrace();
      }
   }

   public static boolean loadDistributionAreas(){
      try {
         FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir")+"/data/DistributionAreas.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         distributionAreas = (ArrayList<String>) in.readObject();
         in.close();
         fileIn.close();
         return true;
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Failed to load DistributionAreas");
         return false;
      } catch (ClassNotFoundException e) {
         System.out.println("Class ArrayList<String> distributionAreas not found");
         e.printStackTrace();
         return false;
      }
   }

   public static void loadWaterRefillLogs() {
      try {
         FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "/data/WaterRefillLogs.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         waterRefillLogs = (ArrayList<LogRefill>) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("Failed to load WaterRefillLogs");
      } catch (ClassNotFoundException e) {
         System.out.println("Class ArrayList<LogRefill> waterRefillLogs not found");
         e.printStackTrace();
      }
   }

   /**
    * Hash Passwords for security when saving login account information
    * about a users using SHA-512 with some 'salt' to improve the security
    *
    * Link reference:
    * https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
    *
    * @param rawPassword the raw unencrypted password that is to be hashed
    * @return return a hashed and encrypted version of the 'rawPassword'
    */
   public static String hashPassword(String rawPassword, byte[] salt){

      String hashPassword = null;

      try {
         //create a MessageDigest instance for SHA-512
         MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

         //add salt to the password bytes to digest
         messageDigest.update(salt);

         //get the decimal formatted hash's bytes
         byte[] hashBytes = messageDigest.digest(rawPassword.getBytes());

         //convert bytes from DEC to HEX format
         StringBuilder stringBuilder = new StringBuilder();
         for (int i = 0; i < hashBytes.length; i++) {
            stringBuilder.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
         }

         //get a completed hashed password in HEX
         hashPassword = stringBuilder.toString();

      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      }

      //return the hashed password
      return hashPassword;
   }

   public static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
      // 'SHA1PRNG' is the pseudo-random number generation algorithm  based on the
      // SHA-1 message digest algorithm and supplied by the provider 'SUN'
      SecureRandom secRand = SecureRandom.getInstance("SHA1PRNG", "SUN");

      //salt array
      byte[] salt = new byte[16];
      //create the random salt
      secRand.nextBytes(salt);

      //return the salt
      return salt;
   }

   public static void main(String[] args) {
      User user = new User("tester", "Password_123", "Johnny", "Test");

      System.out.println("(On load) Users: " + DataStorage.users);
      DataStorage.users.put(user.getUsername(), user);

      System.out.println("(Saving users)");
      DataStorage.saveUsers();

      System.out.println("(After Save) Users: " + DataStorage.users);

      DataStorage.users = new HashMap<String, User>();

      System.out.println("(Cleared Hashmap) Users: " + DataStorage.users);

      DataStorage.loadUsers();
      System.out.println("(loaded in serialised users) Users: " + DataStorage.users);

   }

}
