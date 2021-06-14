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

import WaterDistibution.SceneManager;
import javafx.event.ActionEvent;

import javax.swing.*;

public class CreateAccountController {
    public static void btnBackClicked(ActionEvent event){
        SceneManager.switchScene(SceneManager.getLoginScene());
    }

}
