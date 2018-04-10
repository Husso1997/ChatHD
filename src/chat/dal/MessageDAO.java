/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.dal;

import chat.be.Message;
import chat.be.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author B
 */
public class MessageDAO {
    DataBaseConnector db;

    public MessageDAO() {
        db = new DataBaseConnector();
    }
    

    public Message createMessage(String msg) throws SQLException {
        try (Connection con = db.getConnection())
        {
            String sql = "INSERT INTO Message (Text) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, msg);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Message message = new Message();
            message.setId(rs.getInt(1));
            message.setMessage(msg);
            
            return message;
        }
        catch (SQLException ex)
        {
            throw new SQLException();
        }
        
    }

    public void deleteMessage(int id) throws SQLException {
        try (Connection con = db.getConnection())
        {
            String sql = "DELETE FROM Message WHERE Id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            throw new SQLException();
        }
    }
        
    
    
}
