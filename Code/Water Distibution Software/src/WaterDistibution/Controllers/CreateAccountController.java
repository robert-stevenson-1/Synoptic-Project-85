/**
 * Class: CreateAccountController
 * Author:
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

import javax.swing.*;

public class CreateAccountController {
    public static void btnSubmitClicked(ActionEvent event){
        //TODO: validate and verify

        DataStorage.addUser(new User(
                SceneManager.getCreateUserLogin().getUsername(),
                SceneManager.getCreateUserLogin().getPassword(),
                SceneManager.getCreateUserLogin().getFirstName(),
                SceneManager.getCreateUserLogin().getLastName()
        ));

        SceneManager.switchScene(SceneManager.getLoginScene());
    }

    public static void btnBackClicked(ActionEvent event){
        SceneManager.switchScene(SceneManager.getLoginScene());
    }
}
