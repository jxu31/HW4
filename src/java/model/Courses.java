
package model;


public class Courses {
    
    private int courseid;
    private String coursename;
    private String semester;
    private int credit;
   
    public Courses() {
        this.courseid = 0;
        this.coursename = "";
        this.semester = "";
        this.credit = 0;
    }
    
    public Courses(int courseid, String coursename, String semester, int credit) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.semester = semester;
        this.credit = credit;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Courses{" + "courseid=" + courseid + ", coursename=" + coursename + ", semester=" + semester + ", credit=" + credit + '}';
    }

    
}
