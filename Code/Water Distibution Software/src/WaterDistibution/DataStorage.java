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

   private Hashtable<String, String> Users = new Hashtable<String, String>();

   public Hashtable<String, String> getUsers() {
      return Users;
   }


}
