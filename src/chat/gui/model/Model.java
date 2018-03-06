/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.gui.model;

import chat.be.Message;
import chat.bll.IMechaChatLogicFacade;
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
    
    public Model(){
        messages = FXCollections.observableArrayList();
        
        Facade = new IMechaChatLogicFacade() 
        {
            @Override
            public Message logMessage(String msg) {
                Message m = new Message();
                m.setId(0);
                m.setMessage(msg);
                return m;
            }

            @Override
            public List<Message> getAllMessages() 
            {
               return messages;
            }
        };
    }
    
    public List<Message> getMessages()
    {
        return Facade.getAllMessages();
    }
    
    public void logMessage(String msg)
    {
        Message message = Facade.logMessage(msg);
        messages.add(message);
    }
}
