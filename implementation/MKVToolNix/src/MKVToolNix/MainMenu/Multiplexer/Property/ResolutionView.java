/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer.Property;

import MKVToolNix.CustomAnchorPane;
import MKVToolNix.Utils;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;


/**
 *
 * @author student
 */
public class ResolutionView extends CustomAnchorPane
{
    @FXML
    private AnchorPane anchorPane;


    public ResolutionView()
    {
        super("MainMenu/Multiplexer/Property/ResolutionView.fxml");

        GridPane grid = new GridPane();
        ColumnConstraints col;
        int count = 0;

        col = new ColumnConstraints();
        col.setPercentWidth(47.5);
        col.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().add(col);

        col = new ColumnConstraints();
        col.setPercentWidth(5.0);
        grid.getColumnConstraints().add(col);

        col = new ColumnConstraints();
        col.setPercentWidth(47.5);
        col.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().add(col);

        for (Node n : Arrays.<Node>asList(new TextField(), new Label("x"), new TextField()))
        {
            GridPane.setFillHeight(n, true);
            GridPane.setFillWidth(n, true);
            GridPane.setHgrow(n, n instanceof Label ? Priority.NEVER : Priority.ALWAYS);
            GridPane.setHalignment(n, HPos.CENTER);
            grid.add(n, count++, 0);
        }

        Utils.fillAnchorPane(grid);

        anchorPane.getChildren().add(grid);
    }
}
