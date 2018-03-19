/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.bll;

import chat.be.Message;
import chat.dal.DalException;
import chat.dal.IMechaChatDalFacade;
import chat.dal.MechaChatDalFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hussain
 */
public class MCLogicFacade implements IMechaChatLogicFacade 
{
    static MCLogicFacade INSTANCE;
    private IMechaChatDalFacade dalFacade;
    
    
    private int id = 1;
    
    private MCLogicFacade()
    {
        this.dalFacade = new MechaChatDalFacade();
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
    public Message logMessage(String msg) throws BllException 
    {
        try 
        {
            return dalFacade.createMessage(msg);
        } 
        catch (DalException ex) 
        {
            throw new BllException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Message> getAllMessages() throws BllException
    {
        try 
        {
            return dalFacade.readAllMessages();
        } 
        catch (DalException ex) 
        {
            throw new BllException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public void deleteMessage(Message message) throws BllException
    {
        try 
        {
            dalFacade.deleteMessage(message);
        } catch (DalException ex) 
        {
            throw new BllException(ex.getMessage(), ex);
        }
    }
    

    
}
