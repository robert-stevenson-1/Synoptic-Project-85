/**
 * Class: ViewLogWaterLevel
 * Author: Ipek Meral
 * Contributing Author(s):
 *
 * Date Created: 09/06/2021
 *
 * Description:
 *
 */

package WaterDistibution.Scenes.DashboardView.View;

import WaterDistibution.Scenes.DashboardView.Controller.ViewLogWaterLevelController;
import WaterDistibution.Update;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ViewLogWaterLevel extends Pane implements Update {

    private BorderPane primaryBox = new BorderPane();
    //private HBox hBoxHeader = new HBox();
    //private Button btnAddArea = new Button("Add Distribution Area");
    //private Button btnRemoveArea = new Button("Remove Distribution Area");
    private GridPane grid = new GridPane();
    //private HBox hBoxAreaLayout = new HBox();
    //private Label lblArea = new Label("Distributed Area:");
    //private ComboBox cmbArea = new ComboBox();
    private HBox hBoxNamePreviewLayout = new HBox();
    private Label lblNamePreview = new Label("Log Name:");
    private TextField txtLogNamePreview = new TextField();
    private HBox hBoxDateLayout = new HBox();
    private Label lblDate = new Label("Date:");
    private DatePicker datePickerLogDate = new DatePicker();
    private HBox hBoxTimeLayout = new HBox();
    private Label lblTime = new Label("Time:");
    private TextField txtTimeHour = new TextField();
    private TextField txtTimeMinute = new TextField();
    private HBox hBoxRefillLayout = new HBox();
    private Label lblRefill = new Label("Current Water Level:");
    private Label lblRefillUnit = new Label("L");
    private TextField txtRefill = new TextField();
    private HBox hBoxSubmitLayout = new HBox();
    private Button btnSubmit = new Button("Submit Water Refill Log");

    public ViewLogWaterLevel(){
        setupLayout();
        setupEvents();
    }
    private void setupLayout() {
        //set the parent primary Box that contains the components of the view
        this.getChildren().add(primaryBox);

        //setup the primary containing box
        primaryBox.prefHeightProperty().bind(this.heightProperty());
        primaryBox.prefWidthProperty().bind(this.widthProperty());
        BorderPane.setAlignment(primaryBox, Pos.CENTER);

        //setup the header
        //hBoxHeader.setAlignment(Pos.CENTER);

        //setup name preview
        GridPane.setFillHeight(hBoxNamePreviewLayout, true);
        hBoxNamePreviewLayout.setAlignment(Pos.CENTER);
        txtLogNamePreview.setMinWidth(300);
        txtLogNamePreview.setEditable(false);
        txtLogNamePreview.prefWidthProperty().bind(hBoxNamePreviewLayout.prefWidthProperty());
        txtLogNamePreview.prefHeightProperty().bind(hBoxNamePreviewLayout.prefHeightProperty());

        //setup Date
        GridPane.setFillHeight(hBoxDateLayout, true);
        hBoxDateLayout.setAlignment(Pos.CENTER);

        //setup Time
        GridPane.setFillHeight(hBoxTimeLayout, true);
        hBoxTimeLayout.setAlignment(Pos.CENTER);

        //Setup refill
        GridPane.setFillHeight(hBoxRefillLayout, true);
        hBoxRefillLayout.setAlignment(Pos.CENTER);

        //setup the grid used to UI component alignment and positioning
        //set grid line visible (debugging only)
        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        cc.setFillWidth(true);
        cc.setMinWidth(250);
        cc.setMaxWidth(400);
        RowConstraints rc = new RowConstraints();
        rc.setVgrow(Priority.ALWAYS);
        rc.setFillHeight(true);
        rc.setMinHeight(50);
        rc.setMaxHeight(100);
        grid.getColumnConstraints().addAll(cc,cc);
        grid.getRowConstraints().addAll(rc,rc);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setGridLinesVisible(true);

        //bind the scaling of the grid to the primary parent node component
        grid.minHeightProperty().bind(primaryBox.minHeightProperty());
        grid.minWidthProperty().bind(primaryBox.minWidthProperty());
        grid.prefHeightProperty().bind(primaryBox.heightProperty());
        grid.prefWidthProperty().bind(primaryBox.widthProperty());
        grid.maxHeightProperty().bind(primaryBox.maxHeightProperty());
        grid.maxWidthProperty().bind(primaryBox.maxHeightProperty());

        //setup Submit button
        GridPane.setFillHeight(hBoxSubmitLayout, true);
        hBoxSubmitLayout.setPadding(new Insets(15));
        hBoxSubmitLayout.setAlignment(Pos.CENTER);

        //add the UI components to the primary container
        // box of the view
        //primaryBox.setTop(hBoxHeader);
        primaryBox.setCenter(grid);

        //hBoxHeader.getChildren().add(btnAddArea);
        //hBoxHeader.getChildren().add(btnRemoveArea);

        hBoxNamePreviewLayout.getChildren().add(lblNamePreview);
        hBoxNamePreviewLayout.getChildren().add(txtLogNamePreview);

        hBoxDateLayout.getChildren().add(lblDate);
        hBoxDateLayout.getChildren().add(datePickerLogDate);

        hBoxTimeLayout.getChildren().add(lblTime);
        hBoxTimeLayout.getChildren().add(txtTimeHour);
        hBoxTimeLayout.getChildren().add(new Label(" : "));
        hBoxTimeLayout.getChildren().add(txtTimeMinute);


        hBoxRefillLayout.getChildren().add(lblRefill);
        hBoxRefillLayout.getChildren().add(txtRefill);
        hBoxRefillLayout.getChildren().add(lblRefillUnit);

        //hBoxAreaLayout.getChildren().add(lblArea);
        //hBoxAreaLayout.getChildren().add(cmbArea);


        hBoxSubmitLayout.getChildren().add(btnSubmit);

        grid.add(hBoxNamePreviewLayout,0,0);
        grid.add(hBoxDateLayout,0,1);
        grid.add(hBoxTimeLayout,1,0);
        grid.add(hBoxRefillLayout,1,1);
        grid.add(hBoxSubmitLayout,1,2);
        //grid.add(hBoxAreaLayout,0,3);
    }

    private void setupEvents() {
        btnSubmit.setOnAction(ViewLogWaterLevelController::btnSubmitClicked);
        txtTimeHour.textProperty().addListener(ViewLogWaterLevelController::changedLogNameUpdate);
        txtTimeMinute.textProperty().addListener(ViewLogWaterLevelController::changedLogNameUpdate);
        datePickerLogDate.valueProperty().addListener(ViewLogWaterLevelController::changedLogNameUpdate);
    }


    public DatePicker getDatePickerLogDate() {
        return datePickerLogDate;
    }

    public TextField getTxtTimeHour() {
        return txtTimeHour;
    }

    public TextField getTxtTimeMinute() {
        return txtTimeMinute;
    }

    //public ComboBox getCmbArea(){ return cmbArea;}

    public TextField getTxtRefill(){ return txtRefill;}

    @Override
    public void update() {
        //cmbArea.getItems().clear();
        //cmbArea.getItems().addAll(DataStorage.getDistributionAreas());
    }

   public void setLogName(String logName) {
        txtLogNamePreview.setText(logName);
   }
}
