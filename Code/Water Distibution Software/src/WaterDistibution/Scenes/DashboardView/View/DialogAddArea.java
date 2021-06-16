package WaterDistibution.Scenes.DashboardView.View;

import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class DialogAddArea extends Dialog<String> {

   private GridPane grid = new GridPane();
   private HBox hBoxAreaLayout = new HBox();
   private Label lblArea = new Label("Area: ");
   private TextField txtArea = new TextField();
   private ButtonType btnSubmit = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);

   public DialogAddArea(String title) {
      this.setTitle(title);
      setupLayout();
      setupEvents();
   }

   private void setupLayout() {
      //setup dialog box size
      this.getDialogPane().setMinWidth(220);

      //add the grid to dialog box
      this.getDialogPane().setContent(grid);

      //setup area label
      lblArea.setMinWidth(40);

      //setup area textField
      txtArea.maxWidthProperty().bind(grid.widthProperty());

      //setup the grid
      ColumnConstraints cc = new ColumnConstraints();
      cc.setHgrow(Priority.ALWAYS);
      cc.setFillWidth(true);
      grid.getColumnConstraints().add(cc);

      grid.add(hBoxAreaLayout,0,0);

      hBoxAreaLayout.getChildren().add(lblArea);
      hBoxAreaLayout.getChildren().add(txtArea);

      this.getDialogPane().getButtonTypes().add(btnSubmit);
   }

   private void setupEvents() {
      this.setResultConverter(buttonType -> {
         if (buttonType == btnSubmit) {
            if (validInput()){
               return txtArea.getText();
            }
         }
         return null;
      });
   }

   private boolean validInput(){
      //Error message content
      String errorMsg = "";

      //presence check
      if (txtArea.getText() == null || txtArea.getText().equals("")){
         errorMsg+=("No Area entered\n");
      }

      //no errors in the submitted inputs
      if (errorMsg.equals("")){
         return true;
      }

      //there is an error in the inputs
      new Alert(Alert.AlertType.ERROR, "FAILED TO ADD AREA\n\n"+errorMsg).show();
      return false;
   }
}
