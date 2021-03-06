package com.commisso.francesco.coursesave;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.Serializable;

// A CLASS TO HOLD TO HOLD COURSE INFORMATION

public class Course implements Serializable{

    private long id;

    private String title;
    private String courseCode;
    private DateTime startDate;
    private DateTime endDate;
    private LocalTime time;

    private String teacher;
    private String textbook;


    public Course(String teacher, String title, String courseCode,DateTime startDate, DateTime endDate,LocalTime time){
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.teacher = teacher;
        this.title = title;
        this.courseCode = courseCode;
    }

    public Course(String title, String courseCode, DateTime startDate, DateTime endDate, LocalTime time){
        this.title = title;
        this.courseCode = courseCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
    }

    public Course(String title, String courseCode, DateTime startDate, DateTime endDate, LocalTime time,long id){
        this.title = title;
        this.courseCode = courseCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.id = id;
    }


    public long getId(){return this.id;}
    public String getTeacher(){
        return teacher;
    }
    public String getTitle(){
        return title;
    }
    public String getCourseCode(){
        return courseCode;
    }
    public String getTextbook(){
        return this.textbook;
    }
    public String getTimeHHMMSS(){
        DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm:ss");
        return time.toString(fmt) ;
    }
    public String getDay(){
        DateTimeFormatter fmt = DateTimeFormat.forPattern("EEE");
        return startDate.toString(fmt);
    }
    public String getTime(){
        DateTimeFormatter fmt = DateTimeFormat.forPattern("h:mm");
        return time.toString(fmt);
    }


    public long getEndDateMillis() {
        return endDate.getMillis();
    }
    public long getStartDateMillis() {
        return startDate.getMillis();
    }



    public int getNumberOfDays(){
        return Days.daysBetween(new DateTime().toLocalDate(),endDate.toLocalDate()).getDays();
    }

    public static LocalTime makeLocalTime(String time){
        DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm:ss");
        return fmt.parseLocalTime(time);
    }




    public static int parseDays(Days days) {
        //RETURNS NUMBER OF DAYS AS INTEGER
        return Integer.parseInt(days.toString().substring(1, days.toString().length() - 1));
    }

    public void setTextbook(String textbook){this.textbook = textbook;}


    public void setTeacher(String teacher){
            this.teacher  = teacher;

    }

    public void setId(long id){
        this.id = id;
    }



    @Override
    public String toString() {
        return (
                "\n"+
                "Teacher: " + teacher +"\n" +
                "Title: " + title +"\n" +
                "Course Code: " + courseCode +"\n" +
                "Start Date: " + startDate +"\n" +
                "End Date: " + endDate +"\n" +
                "Number of Days: " + getNumberOfDays() +"\n" +
                "Time: " + getTimeHHMMSS() +"\n" +
                "Course ID: " + getId());

    }
}
