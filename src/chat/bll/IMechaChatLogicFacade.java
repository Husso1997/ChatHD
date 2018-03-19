/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.bll;

import chat.be.Message;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface IMechaChatLogicFacade 
{
    public Message logMessage(String msg)throws BllException;
            
    public List<Message> getAllMessages() throws BllException; 
    
    public void deleteMessage(Message message) throws BllException;

}
