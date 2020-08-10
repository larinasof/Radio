package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private String name = "Radio";
    private boolean on;
    private int currentStation = 5;
    private int minStation = 0;
    private int maxStation = 10;
    private int currentVolume = 25;
    private int minVolume = 0;
    private int maxVolume = 100;


    public void setCurrentStation(int currentStation) {
        if (currentStation > maxStation){
            this.currentStation = 0;
            return;
        }
        if (currentStation < minStation){
            this.currentStation = 10;
            return;
        }
        this.currentStation = currentStation;
    }

    public void nextStation (){
        if (this.currentStation == maxStation){
            this.currentStation = 0;
        }
        else {
            this.currentStation ++;}
    }

    public void previousStation (){
        if (this.currentStation == minStation){
            this.currentStation = maxStation;
        }
        else {
            this.currentStation --;}
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

}
