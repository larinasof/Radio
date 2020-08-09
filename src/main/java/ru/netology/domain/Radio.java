package ru.netology.domain;

public class Radio {
    private String name = "Radio";
    private boolean on;
    private int currentStation;
    private int minStation = 0;
    private int maxStation = 10;
    private int currentVolume = 25;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio(int maxStation) {
        this.maxStation = maxStation;
    }

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
        this.currentStation = currentStation;
    }

    public void nextStation (){
        if (this.currentStation == getMaxStation()){
            setCurrentStation(0);
        }
        setCurrentStation(this.currentStation + 1);
    }

    public void previousStation (){
        if (this.currentStation == getMinStation()){
            setCurrentStation(9);
        }
        setCurrentStation(this.currentStation - 1);
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
