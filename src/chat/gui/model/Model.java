/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.gui.model;

import chat.be.Message;
import chat.bll.IMechaChatLogicFacade;
import chat.bll.MCLogicFacade;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author B
 */
public class Model {
    private IMechaChatLogicFacade Facade;
    private ObservableList<Message> messages;
    
    public Model()
    {
        messages = FXCollections.observableArrayList();
        Facade = MCLogicFacade.getInstance();
    }
    
    public ObservableList<Message> getMessages()
    {
        return messages;
    }
    
    public Message logMessage(String msg)
    {
        Message message = Facade.logMessage(msg);
        messages.addAll(Facade.getAllMessages());
        return message;
    }
}
