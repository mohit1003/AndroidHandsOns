package com.mavit.listfragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CourseArrayAdapter extends ArrayAdapter<Courses> {
    private Context context;
    private List<Courses> courses;
    public CourseArrayAdapter(@NonNull Context context, int resource, @NonNull List<Courses> objects) {
        super(context, resource, objects);
        this.context = context;
        this.courses = courses;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Courses course = courses.get(position);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.course_listitem, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.CourseImage);
        imageView.setImageResource(course.getImageResource(context));

        TextView textView = view.findViewById(R.id.CouseName);
        textView.setText(course.getCourseName());


        return view;
    }
}
