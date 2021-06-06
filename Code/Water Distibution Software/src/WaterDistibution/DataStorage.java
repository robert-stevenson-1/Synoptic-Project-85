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

import java.io.Serializable;
import java.util.Hashtable;

public class DataStorage implements Serializable {

   private Hashtable<String, User> Users = new Hashtable<String, User>();
   private User CurrentUser = new User();

   public Hashtable<String, User> getUsers() {
      return Users;
   }


}
