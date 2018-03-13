/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.gui.model;

import chat.be.Message;

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
        message = receiver.logMessage(text);
    }

    @Override
    public void undo() 
    {
       
    }
    
}
