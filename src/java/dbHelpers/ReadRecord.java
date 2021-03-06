/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Courses;

/**
 *
 * @author Jiawen
 */
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Courses course = new Courses ();
    private int courseid;
    
    public ReadRecord (int courseid) {
    
    Properties props = new Properties();    
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
    
    this.courseid = courseid;
    
    
    
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    
    public void doRead(){
    
        try {
            String query = "SELECT * from courses where courseid = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, courseid);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            course.setCourseid(this.results.getInt("courseid"));
            course.setCoursename(this.results.getString("coursename"));
            course.setSemester(this.results.getString("semester"));
            course.setCredit(this.results.getInt("credit"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    
}
 
    public Courses getCourse(){
        
        return this.course;
    }
    
}
    
    
    

