/**
 * Class: User
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Model;

import WaterDistibution.DataStorage;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class User implements Serializable {

   private String username;
   private String password; //stores hashed password
   private byte[] salt = new byte[16]; //password hash salt
   private String firstName;
   private String lastName;

   //----------------
   //--CONSTRUCTORS--
   //----------------

   public User() {
      username = "";
      password = "";
      firstName = "";
      lastName = "";
   }

   public User(String username, String password) {
      this.username = username;
      try {
         this.salt = DataStorage.getSalt();
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      }
      this.password = DataStorage.hashPassword(password,salt);
   }

   public User(String username, String password, String firstName, String lastName) {
      this.username = username;
      try {
         this.salt = DataStorage.getSalt();
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      }
      this.password = DataStorage.hashPassword(password, salt);
      this.firstName = firstName;
      this.lastName = lastName;
   }

   //-------------
   //---GETTERS---
   //-------------

   public String getUsername() {
      return username;
   }

   public String getPassword() {
      return password;
   }

   public byte[] getSalt() {
      return salt;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getName() {
      return firstName+" "+lastName;
   }

   @Override
   public String toString() {
      return "User{" +
              "username='" + username + '\'' +
              ", password='" + password + '\'' +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              '}';
   }

   //-------------
   //---SETTERS---
   //-------------

   public void setUsername(String username) {
      this.username = username;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
