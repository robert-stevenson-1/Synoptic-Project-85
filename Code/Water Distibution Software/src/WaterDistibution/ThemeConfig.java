/**
 * Class: ThemeConfig
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 07/06/2021
 *
 * Description:
 *
 */
package WaterDistibution;

import javafx.scene.layout.Pane;

public abstract class ThemeConfig {

   public static final String PANEL_COLOUR_1 =  "-fx-background-color: rgb(189,189,189);";
   public static final String PANEL_COLOUR_2 =  "-fx-background-color: rgb(213,213,213);";

   public static final String BORDER_COLOUR = "-fx-border-color: rgb(163,163,163);" +
                                              "-fx-padding: 2px;";
   public static final String BORDER = "-fx-border-width: 4px;";


   public static final String BUTTON_THEME = "-fx-border-radius: 8px;";

   private Pane tester = new Pane();

   private void tester(){
      tester.setStyle(BUTTON_THEME + PANEL_COLOUR_2);
   }
}
