/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.bll;

import chat.be.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class MCLogicFacade implements IMechaChatLogicFacade 
{
    static MCLogicFacade INSTANCE;
    
    
    private int id = 1;
    ArrayList<Message> msgs;
    
    private MCLogicFacade()
    {
        
    }
    
    public static MCLogicFacade getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new MCLogicFacade();
        }
        return INSTANCE;
    }

    @Override
    public Message logMessage(String msg) 
    {
        if(msgs == null)
        {
          msgs = new ArrayList();
        }
        Message message = new Message();
        message.setId(id++);
        message.setMessage(msg);
        getAllMessages().add(message);
        return message;
    }

    @Override
    public List<Message> getAllMessages() 
    {
        return msgs;
    }

    
}
