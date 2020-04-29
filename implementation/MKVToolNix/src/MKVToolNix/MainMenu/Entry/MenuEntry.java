/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MKVToolNix.MainMenu.Entry;

import MKVToolNix.Utils;
import java.util.Arrays;
import java.util.List;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author student
 */
public abstract class MenuEntry
{
    private String name;
    private ToggleButton btn;
    private AnchorPane pane;
    private Menu menu;
    private List<MenuItem> menuItems;

    private AnchorPane content;


    public MenuEntry(String name, ToggleButton btn, AnchorPane pane, Menu menu, AnchorPane content)
    {
        this.name = name;
        this.btn = btn;
        this.pane = pane;
        this.menu = menu;
        this.content = content;

        AnchorPane.setTopAnchor(this.content, 0.0);
        AnchorPane.setBottomAnchor(this.content, 0.0);
        AnchorPane.setLeftAnchor(this.content, 0.0);
        AnchorPane.setRightAnchor(this.content, 0.0);
    }


    public ToggleButton getBtn()
    {
        return btn;
    }


    public void setBtn(ToggleButton btn)
    {
        this.btn = btn;
    }


    public AnchorPane getPane()
    {
        return pane;
    }


    public void setPane(AnchorPane pane)
    {
        this.pane = pane;
    }


    public Menu getMenu()
    {
        return menu;
    }


    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }


    public List<MenuItem> getMenuItems()
    {
        return menuItems;
    }


    public void setMenuItems(List<MenuItem> menuItems)
    {
        this.menuItems = menuItems;
    }


    public AnchorPane getContent()
    {
        return content;
    }


    public void setContent(AnchorPane content)
    {
        this.content = content;
    }


    public void activate()
    {
        btn.setStyle("-fx-background-color: #0093ff");
        pane.getChildren().add(content);
        menu.getItems().addAll(menuItems);
        menu.setText(name);
    }


    public void deactivate()
    {
        btn.setStyle("-fx-background-color: black");
        pane.getChildren().clear();
        menu.getItems().clear();
    }


    protected MenuItem makeMenuItem()
    {
        return new SeparatorMenuItem();
    }


    protected MenuItem makeMenuItem(String text)
    {
        return new MenuItem(text);
    }


    protected MenuItem makeMenuItem(String text, String imgPath)
    {
        return new MenuItem(text, Utils.makeImageView(imgPath));
    }


    protected Menu makeMenuItem(String text, String imgPath, MenuItem... subItems)
    {
        Menu item = new Menu(text, Utils.makeImageView(imgPath));
        item.getItems().addAll(Arrays.<MenuItem>asList(subItems));
        return item;
    }


    protected Menu makeMenuItem(String text, MenuItem... subItems)
    {
        Menu item = new Menu(text);
        item.getItems().addAll(Arrays.<MenuItem>asList(subItems));
        return item;
    }
}
