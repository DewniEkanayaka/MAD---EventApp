package com.example.finalevent;

public class Event {

    private String name;
    private String date;
    private String time;
    private String place;
    private Integer numOfGuests;
    private String budget;
    private String theme;
    private Boolean photo;
    private Boolean enter;
    private Boolean food;

    public Event() {
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Boolean getPhoto() { return photo; }

    public void setPhoto(Boolean photo) { this.photo = photo; }

    public Boolean getEnter() { return enter; }

    public void setEnter(Boolean enter) { this.enter = enter; }

    public Boolean getFood() { return food; }

    public void setFood(Boolean food) { this.food = food; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(Integer numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
