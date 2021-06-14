/**
 * Class: CreateAccountController
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

public class CreateAccountController {
    public static void btnSubmitClicked(ActionEvent event){
        //TODO: validate and verify

        DataStorage.addUser(new User(
                SceneManager.getCreateAccountScene().getUsername(),
                SceneManager.getCreateAccountScene().getPassword(),
                SceneManager.getCreateAccountScene().getFirstName(),
                SceneManager.getCreateAccountScene().getLastName()
        ));

        SceneManager.switchScene(SceneManager.getLoginScene());
    }

    public static void btnBackClicked(ActionEvent event){
        SceneManager.switchScene(SceneManager.getLoginScene());
    }
}
