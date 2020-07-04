package com.example.mstcapp.exclusiveModels;

import java.util.ArrayList;
import java.util.List;

public class attendanceModelClass {
    private List<String> Content=new ArrayList<>();
    private String Date;
    private String Month;
    private String Title;

    public List<String> getContent() {
        return Content;
    }

    public void setContent(List<String> content) {
        Content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public attendanceModelClass(List<String> content, String date, String month, String title) {
        Content = content;
        Date = date;
        Month = month;
        Title = title;
    }
}
