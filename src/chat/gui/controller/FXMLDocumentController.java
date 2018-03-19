/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.gui.controller;

import chat.be.Message;
import chat.gui.model.CreateMessageCommand;
import chat.gui.model.ICommand;
import chat.gui.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.util.Callback;

/**
 *
 * @author B
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private ListView<Message> listView;
    @FXML
    private TextField textField;
    
    Model model;
    
    private Stack<ICommand> undos;
    private Stack<ICommand> redos;
    
    private KeyCombination keysUndo;
    private KeyCombination keysRedo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        model = new Model();
        
        undos = new Stack<>();
        redos = new Stack<>();
        
        keysUndo = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);
        keysRedo = new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN);
        
        listView.setCellFactory(new Callback<ListView<Message>, ListCell<Message>>() {

            @Override
            public ListCell<Message> call(ListView<Message> param) {
                ListCell<Message> cell = new ListCell<Message>() {

                    @Override
                    protected void updateItem(Message item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getMessage());
                        } else 
                        {
                            setText("");
                        }
                    }
                };
                return cell;
            }
        });
        
        listView.setItems(model.getMessages());
    }    

    @FXML
    private void sendMessage(ActionEvent event) 
    {
        String text = textField.getText();
        ICommand createCmd = new CreateMessageCommand(model, text);
    }
    

}
