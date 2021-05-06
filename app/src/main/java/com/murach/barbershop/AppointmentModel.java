package com.murach.barbershop;

public class AppointmentModel {

    private boolean haircut;
    private boolean style;
    private boolean color;
    private boolean shave;
    private String date;
    private String time;
    private int id;

    public AppointmentModel(int id, boolean haircut, boolean style, boolean color, boolean shave, String date, String time){

        this.id = id;
        this.haircut = haircut;
        this.style = style;
        this.color = color;
        this.shave = shave;
        this.date = date;
        this.time = time;

    }

    public AppointmentModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHaircut() {
        return haircut;
    }

    public void setHaircut(boolean haircut) {
        this.haircut = haircut;
    }

    public boolean isStyle() {
        return style;
    }

    public void setStyle(boolean style) {
        this.style = style;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public boolean isShave() {
        return shave;
    }

    public void setShave(boolean shave) {
        this.shave = shave;
    }

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

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "haircut=" + haircut +
                ", style=" + style +
                ", color=" + color +
                ", shave=" + shave +
                ", date=" + date +
                ", time=" + time +
                ", id=" + id +
                '}';
    }
}
