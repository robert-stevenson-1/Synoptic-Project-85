/**
 * Class: CreateUserLoginController
 * Author: Sweena Jeyagugan
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

public class CreateUserLoginController {
    public static void btnSubmitClicked(ActionEvent event){

        if (validateInput()){
            DataStorage.addUser(new User(
                    SceneManager.getCreateUserLoginScene().getUsernameValue(),
                    SceneManager.getCreateUserLoginScene().getPasswordValue(),
                    SceneManager.getCreateUserLoginScene().getFirstNameValue(),
                    SceneManager.getCreateUserLoginScene().getLastNameValue()
            ));
            System.out.println("New user made");
            SceneManager.switchScene(SceneManager.getLoginScene());
        }
        System.out.println("Create User: btnSubmitClicked");
    }

    public static void btnBackClicked(ActionEvent event){
        SceneManager.switchScene(SceneManager.getLoginScene());
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
        String usernameValue = SceneManager.getCreateUserLoginScene().getUsernameValue();
        String passwordValue = SceneManager.getCreateUserLoginScene().getPasswordValue();
        String passwordConfirmValue = SceneManager.getCreateUserLoginScene().getPasswordConfirmationValue();
        String firstNameValue = SceneManager.getCreateUserLoginScene().getFirstNameValue();
        String lastNameValue = SceneManager.getCreateUserLoginScene().getLastNameValue();

        //presence check
        if (usernameValue == null || usernameValue.equals("")){
            errorMsg+=("No Username entered\n");
        }

        if (DataStorage.usernameExist(usernameValue)){
            errorMsg+=("Username already exists. Choose a different one.\n");
        }

        if (passwordValue == null || passwordValue.equals("")){
            errorMsg+=("No Password Entered\n");
        }else{
            if (passwordConfirmValue == null || passwordConfirmValue.equals("")){
                errorMsg+=("No Password Confirmation Entered\n");
            } else {
                if (passwordValue.equals(passwordConfirmValue)){
                    //length check
                    if (passwordValue.length() < 8){
                        errorMsg+=("Password must be of length 8 or more\n");
                    }

                    //check if the Password is regex compatible (no invalid characters)
                    if (passwordValue.matches(passRegex)){
                        errorMsg+=("Password must contain at least one Uppercase " +
                                "letter, one Lowercase letter, one Special Character, and one Number without" +
                                " any whitespaces\n");
                    }
                }else{
                    errorMsg+=("Passwords don't match.\n" +
                            "Password must contain at least one Uppercase " +
                            "letter, one Lowercase letter, one Special Character, and one Number without" +
                            " any whitespaces\n");
                }
            }
        }

        //length check
        if (passwordValue.length() < 8){
            errorMsg+=("Password must be of length 8 or more\n");
        }

        //check if the Password is regex compatible (no invalid characters)
        if (passwordValue.matches(passRegex)){
            errorMsg+=("Password must contain at least one Uppercase " +
                    "letter, one Lowercase letter, one Special Character, and one Number without" +
                    " any whitespaces\n");
        }

        //presence check
        if (firstNameValue == null || firstNameValue.equals("")){
            errorMsg+=("No first name entered\n");
        }

        //presence check
        if (lastNameValue == null || lastNameValue.equals("")){
            errorMsg+=("No last name entered\n");
        }

        //no errors in the submitted inputs
        if (errorMsg.equals("")){
            return true;
        }
        //there is an error in the inputs
        new Alert(Alert.AlertType.ERROR, errorMsg).show();
        return false;
    }
}
