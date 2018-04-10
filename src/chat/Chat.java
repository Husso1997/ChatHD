/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import chat.be.Message;
import chat.bll.ListGrabber;
import chat.bll.ListObserver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author B
 */
public class Chat extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gui/view/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        ListGrabber lg = new ListGrabber();
        ListObserver lo = new ListObserver(lg);
        Message m = new Message();
        m.setMessage("pft");
        lg.addMessage(m);
        lg.addMessage(m);
        lg.addMessage(m);
        lg.addMessage(m);
        launch(args);
    }
    
}
