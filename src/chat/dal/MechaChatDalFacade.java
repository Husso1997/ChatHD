/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.dal;

import chat.be.Message;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hussain
 */
public class MechaChatDalFacade implements IMechaChatDalFacade
{
    List<Message> msgs;
    MessageDAO mDAO;

    public MechaChatDalFacade() {
        mDAO = new MessageDAO();
    }
    

    @Override
    public Message createMessage(String msg) throws DalException 
    {
       Message message;
        try {
            message = mDAO.createMessage(msg);
        } catch (SQLException ex) {
            throw new DalException(ex.getMessage(), ex);
        }
       return message;
    }

    @Override
    public void deleteMessage(Message message) throws DalException 
    {
        try {
            mDAO.deleteMessage(message.getId());
        } catch (SQLException ex) {
            throw new DalException(ex.getMessage(), ex);
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
