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
public class ListGrabber implements Subject
{
    private ArrayList<Observer> observers;
    private List<Message> listMessage;
    
    public ListGrabber()
    {
        observers = new ArrayList();
        listMessage = new ArrayList();
        
    }
    @Override
    public void register(Observer newObserver) 
    {
       observers.add(newObserver);
    }

    @Override
    public void unregister(Observer observer)
    {
        int index = observers.indexOf(observer);
        observers.remove(index);
    }

    @Override
    public void notifyObserver()
    {
        for(Observer observer : observers)
        {
            observer.update(listMessage);
        }
    }
    
    public void addMessage(Message message)
    {
        this.listMessage.add(message);
        notifyObserver();
    }
    
}
