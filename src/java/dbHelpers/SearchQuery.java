
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

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        
        Properties props = new Properties();    
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void doSearch(String coursename){
        try {
            String query = "Select * from courses Where Upper(coursename) like ? order by courseid asc";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,"%" + coursename.toUpperCase() + "%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
     public String getHTMLtable(){
        
        String table = "";
        
   
table +="<table>";        
       
        
        try {
            table +="<tr>";
                
                table +="<th> ";
                table +="CourseID";
                table += "</th>";
                
                 table +="<th>";
                 table +="CourseName";
                table += "</th>";
                
                 table +="<th>";
                 table +="Semester";
                table +="</th>";
                
                 table +="<th>";    
                 table +="Credit";
                table +="</th>";
                
                table +="<th>";
                table +="";
                table +="</th>";
                
                
                table +="</tr>";
                
            while(this.results.next()){
                
                Courses course = new Courses();
                course.setCourseid(this.results.getInt("courseid"));
                course.setCoursename(this.results.getString("coursename"));
                course.setSemester(this.results.getString("semester"));
                course.setCredit(this.results.getInt("credit"));
          
                
                table +="<tr>";
                table +="<td>";
                table+= course.getCourseid();
                table += "</td>";
                
                table +="<td>";
                table+= course.getCoursename();
                table += "</td>";
                
                table +="<td>";
                table+= course.getSemester();
                table += "</td>";
                
                table +="<td>";
                table+= course.getCredit();
                table += "</td>";
                
                 table +="<td>";
                table += "<a href=update?courseid=" + course.getCourseid()+ "> Update </a>" + "<a href = delete?courseid="+course.getCourseid() + "> Delete </a>";
                table +="</td>";       
                
                table +="</tr>";
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        table += "</table>";
        return table;
        
        
    }
    
    
    
}
