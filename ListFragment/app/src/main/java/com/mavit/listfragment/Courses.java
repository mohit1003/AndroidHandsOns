package com.mavit.listfragment;

import android.content.Context;


public class Courses {
    private  String courseName;
    private String courseImage;

    public Courses(String courseName, String courseImage) {
        this.courseName = courseName;
        this.courseImage = courseImage;
    }

    public int getImageResource(Context context){
        return context.getResources().getIdentifier(this.courseName, "drawable", context.getPackageName());
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }
}
