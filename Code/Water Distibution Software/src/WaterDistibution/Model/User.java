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

public class User {

   private String username;
   private String password;

   //----------------
   //--CONSTRUCTORS--
   //----------------

   public User() {
      username = "";
      password = "";
   }

   public User(String username, String password) {
      this.username = username;
      this.password = password;
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
