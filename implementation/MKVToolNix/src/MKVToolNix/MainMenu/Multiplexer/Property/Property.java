/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Multiplexer.Property;

import MKVToolNix.Misc.Pair;
import MKVToolNix.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;


/**
 *
 * @author student
 */
public abstract class Property extends GridPane
{
    private static class Entry
    {
        private Node left;
        private Node right;


        public Entry(Node left, Node right)
        {
            this.left = left;
            this.right = right;
        }


        public Node getLeft()
        {
            return left;
        }


        public Node getRight()
        {
            return right;
        }
    }

    private List<Entry> options;


    public Property()
    {
        super();

        ColumnConstraints col;
        setPadding(new Insets(8.0));
        setHgap(8.0);
        setVgap(8.0);

        col = new ColumnConstraints(USE_COMPUTED_SIZE);
        getColumnConstraints().add(col);
        col = new ColumnConstraints();
        col.setHgrow(Priority.ALWAYS);
        getColumnConstraints().add(col);

        options = new ArrayList<>();
    }


    protected void addDropdownMenu(String label, String... items)
    {
        Label labelNode;
        MenuButton menuNode = new MenuButton(items[0]);

        menuNode.getItems().addAll(makeMenuItems(menuNode, items));

        labelNode = new Label(label + ":");
        Utils.fillAnchorPane(menuNode);
        options.add(new Entry(labelNode, menuNode));
    }


    protected void addDropdownMenu(String label, int select, String... items)
    {
        Label labelNode;
        MenuButton menuNode = new MenuButton(items[select]);

        menuNode.getItems().addAll(makeMenuItems(menuNode, items));

        labelNode = new Label(label + ":");
        Utils.fillAnchorPane(menuNode);
        options.add(new Entry(labelNode, menuNode));
    }


    protected void addTextFieldDropdownMenu(String label, String... items)
    {
        Label labelNode;
        ComboBox menuNode = new ComboBox();

        menuNode.setEditable(true);
        menuNode.getItems().addAll(Arrays.<String>asList(items));

        labelNode = new Label(label + ":");
        Utils.fillAnchorPane(menuNode);
        options.add(new Entry(labelNode, menuNode));
    }


    protected void addTextField(String label)
    {
        Label labelNode;
        TextField textNode;

        textNode = new TextField();
        labelNode = new Label(label + ":");
        Utils.fillAnchorPane(textNode);
        options.add(new Entry(labelNode, textNode));
    }


    protected void addFileSelector(String label)
    {
        Label labelNode;
        AnchorPane contentNode;

        labelNode = new Label(label + ":");
        contentNode = new FileSelector();
        Utils.fillAnchorPane(contentNode);
        options.add(new Entry(labelNode, contentNode));
    }


    protected void addCheckbox(String label)
    {
        CheckBox checkNode;
        checkNode = new CheckBox(label);
        options.add(new Entry(null, checkNode));
    }


    protected void addRadioChoice(Pair<String, Node>... items)
    {
        ToggleGroup group = new ToggleGroup();
        for (Pair<String, Node> i : items)
        {
            RadioButton btn = new RadioButton(i.getItem1());
            btn.setToggleGroup(group);
            Utils.fillAnchorPane(i.getItem2());
            options.add(new Entry(btn, i.getItem2()));
        }

    }


    protected void init()
    {
        AnchorPane l;
        AnchorPane n;
        int count = 0;

        for (Entry e : options)
        {
            if (e.getLeft() == null)
            {
                n = new AnchorPane(e.getRight());
                GridPane.setConstraints(n, 0, count);
                GridPane.setValignment(n, VPos.CENTER);
                GridPane.setHalignment(n, HPos.LEFT);
                add(n, 0, count, 2, 1);
            }
            else
            {
                l = new AnchorPane(e.getLeft());
                n = new AnchorPane(e.getRight());

                GridPane.setValignment(l, VPos.CENTER);
                GridPane.setValignment(n, VPos.CENTER);

                add(l, 0, count);
                add(n, 1, count);
            }

            count++;
        }
    }


    private List<MenuItem> makeMenuItems(ButtonBase menuNode, String[] items)
    {
        List<MenuItem> menuItems = new ArrayList<>();
        Arrays.<String>asList(items).forEach(i ->
        {
            MenuItem item = new MenuItem(i);
            item.setOnAction(e -> menuNode.setText(item.getText()));
            menuItems.add(item);
        });

        return menuItems;
    }
}
