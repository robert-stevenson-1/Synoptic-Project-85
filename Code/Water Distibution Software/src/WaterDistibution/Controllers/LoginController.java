/**
 * Class: LoginController
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Controllers;

import WaterDistibution.DataStorage;
import WaterDistibution.Model.User;
import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class LoginController {

   public static void btnLoginClicked(ActionEvent event) {
      System.out.println("btnLogin clicked!");
      //use the scene manager to change the scene of the program
      if (validateInput() || true) { //by pass login
         if (attemptLogin() || true) { //by pass login
            SceneManager.switchScene(SceneManager.getDashboardScene());
         }
      }
   }
   private static boolean validateInput(){

      //password regex
      String passRegex = "^(?=.*[0-9])(?=.*[a-z])"+
                         "(?=.*[A-Z])"+
                         "(?=.*_[@#$%^&-+=()])"+
                         "(?=\\S+$).{8,}$";
      //Error message content
      String errorMsg = "";

      //get the login field values to check
      String usernameValue = SceneManager.getLoginScene().getUsernameValue();
      String passwordValue = SceneManager.getLoginScene().getPasswordValue();

      //presence check
      if (usernameValue == null || usernameValue.equals("")){
         errorMsg.concat("No Username entered\n");
      }

      if (passwordValue == null || passwordValue.equals("")){
         errorMsg.concat("No Password Entered\n");
      }

      //length check
      if (passwordValue.length() < 8){
         errorMsg.concat("Password must be of length 8 or more\n");
      }

      //check if the Password is regex compatible (no invalid characters)
      if (passwordValue.matches(passRegex)){
         errorMsg.concat("Password must contain at least one Uppercase " +
                 "letter, one Lowercase letter, one Special Character, and one Number without" +
                 " any whitespaces\n");
      }

      //no errors in the submitted inputs
      if (errorMsg.equals("")){
         return true;
      }

      //there is an error in the inputs
      new Alert(Alert.AlertType.ERROR, errorMsg).show();
      return false;
   }

   private static boolean attemptLogin(){

      //get the login field values to check
      String usernameValue = SceneManager.getLoginScene().getUsernameValue();
      String passwordValue = SceneManager.getLoginScene().getPasswordValue();

      try {
         //try to get the user stored in the system. Throws exception if the
         // Username or password doesn't match any saved users meaning this user doesn't
         // exist with these credentials.
         User user = DataStorage.getUser(usernameValue, passwordValue);
         //store the delivered user as the current user that's logged into the program.
         DataStorage.setCurrentUser(user);
      } catch (Exception e){
         //failed at logging in
         e.printStackTrace();
         new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
         return false;
      }
      //login successfully
      return true;
   }


}
