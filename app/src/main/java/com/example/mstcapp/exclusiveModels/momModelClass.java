package com.example.mstcapp.exclusiveModels;

public class momModelClass {
    private String Content;
    private String Date;
    private String Month;
    private String Title;

    public momModelClass() {
    }

    public momModelClass(String content, String date, String month, String title) {
        Content = content;
        Date = date;
        Month = month;
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
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
}
