/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.gui.model;

import chat.be.Message;
import chat.bll.BllException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hussain
 */
public class CreateMessageCommand implements ICommand
{
    private Model receiver;
    private Message message;
    private String text;
    
    public CreateMessageCommand(Model receiver, String text)
    {
        this.text = text;
        this.receiver = receiver;
    }
    
    @Override
    public void execute() 
    {
        try {
            message = receiver.logMessage(text);
        } 
        catch (BllException ex) 
        {
            Logger.getLogger(CreateMessageCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void undo() throws BllException 
    {
       receiver.deleteMessage(message);
    }
    
}
