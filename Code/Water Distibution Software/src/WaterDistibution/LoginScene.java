package WaterDistibution;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class LoginScene extends Pane {

   private VBox primaryBox = new VBox();
   private Label lblTitle = new Label("Hello World");
   private final Button btnClicker = new Button("This is a button");

   public LoginScene() {
      setupLayout();
      setupEvents();
   }

   //setup the login windows layout
   private void setupLayout() {
      this.setWidth(200);
      this.setHeight(200);

      this.getChildren().add(primaryBox);

      primaryBox.prefHeightProperty().bind(this.heightProperty());
      primaryBox.prefWidthProperty().bind(this.widthProperty());

      primaryBox.getChildren().add(lblTitle);
      primaryBox.getChildren().add(btnClicker);

   }

   //setup the events that are assigned to components in the layout
   private void setupEvents() {

      btnClicker.setOnAction(new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent actionEvent) {
            System.out.println("btnClicker clicked!");
         }
      });

   }

}
