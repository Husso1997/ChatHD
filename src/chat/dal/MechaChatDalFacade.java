/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.dal;

import chat.be.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class MechaChatDalFacade implements IMechaChatDalFacade
{
    List<Message> msgs;

    @Override
    public Message createMessage(String msg) throws DalException 
    {
       Message message = new Message();
       message.setMessage(msg);
       message.setId(1);
       readAllMessages().add(message);
       return message;
    }

    @Override
    public void deleteMessage(Message message) throws DalException 
    {
        for(Message msg : readAllMessages())
        {
            if(msg.equals(message))
            {
                readAllMessages().remove(msg);
            }
        }
    }

    @Override
    public List<Message> readAllMessages() throws DalException 
    {
        if(msgs == null)
        {
            msgs = new ArrayList();
        }
       return msgs;
    }
    
}
