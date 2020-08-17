package com.mavit.listfragment;

import java.util.ArrayList;

public class CourseData {
    private String[] courseNames = {"First Course", "Second Course", "Third Course", "Fourth Course", "Fifth Course", "Sixth Course"};
    private int length = courseNames.length;
    public ArrayList<Courses> getCourseList(){
        ArrayList<Courses> courses = new ArrayList<>();
       for(int i = 0; i< length;i++){
           Courses courses1 = new Courses(courseNames[i], courseNames[i].toLowerCase().replace(" ",""));
           courses.add(courses1);
       }
       return courses;
    }
}
