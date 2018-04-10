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
public class ListObserver implements Observer
{
    private Subject listGrabber;
    private static int observerIDTracker = 0;
    private int observerID;
    
    private List<Message> list;
    
    
    public ListObserver(Subject listGrabber)
    {
        this.listGrabber = listGrabber;
        this.observerID = ++observerIDTracker;
        listGrabber.register(this);
        list = new ArrayList();
    }

    @Override
    public void update(List<Message> messageList) 
    {
      this.list = messageList;  
      printMessages();
    }
    
    public void printMessages()
    {
        for(Message message : list)
        {
            System.out.println(message);
        }
    }
    
}
