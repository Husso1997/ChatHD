/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.dal;

/**
 *
 * @author Hussain
 */
public class DalException extends Exception
{
       public DalException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
