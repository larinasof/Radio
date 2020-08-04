package ru.netology.domain;

public class Radio {
    private String name;
    private boolean on;
    private int currentStation;
    private int minStation;
    private int maxStation;
    private int currentVolume;
    private int minVolume;
    private int maxVolume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation >= maxStation){
            this.currentStation = 0;
        }
        if (currentStation <= minStation){
            this.currentStation = 9;
        }
        this.currentStation = currentStation;
    }

    public void nextStation (){
        if (this.currentStation == 9){
            setCurrentStation(0);
        }
        else {
        setCurrentStation(this.currentStation + 1);}
    }

    public void previousStation (){
        if (this.currentStation == 0){
            setCurrentStation(9);
        }
        else {
        setCurrentStation(this.currentStation - 1);}
    }

    public int getMinStation() {
        return minStation;
    }

    public void setMinStation(int minStation) {
        this.minStation = minStation;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public void setMaxStation(int maxStation) {
        this.maxStation = maxStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume > maxVolume) {
            return;
        }
        if (currentVolume < minVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void increaseCurrentVolume(){
        setCurrentVolume (this.currentVolume+1);
    }

    public void decreaseCurrentVolume(){
        setCurrentVolume(this.currentVolume-1);
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }



}
