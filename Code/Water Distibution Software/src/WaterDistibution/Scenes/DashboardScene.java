/**
 * Class: DashboardScene
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */
package WaterDistibution.Scenes;

import WaterDistibution.Controllers.DashBoardController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DashboardScene extends Pane {

   private VBox primaryBox = new VBox();
   private final Button btnLogout = new Button("Logout");


   public DashboardScene() {
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {

      //set the parent primary Box that contains the components of the scene
      this.getChildren().add(primaryBox);

      //bind the scaling of the primary parent node component to the Login scenes current dimensions
      primaryBox.prefHeightProperty().bind(this.heightProperty());
      primaryBox.prefWidthProperty().bind(this.widthProperty());

      //setup the primary container box
      primaryBox.setAlignment(Pos.CENTER);

      //add the UI components to the primary container box of the dashboard page
      primaryBox.getChildren().add(btnLogout);

   }

   private void setupEvents() {
      btnLogout.setOnAction(DashBoardController::btnLogoutClicked);
   }
}
