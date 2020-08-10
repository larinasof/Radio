package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();
    Radio radio2 = new Radio(10);

    @Test
    void shouldChangeToNextStation() {
        int current = radio.getCurrentStation();
        radio.nextStation();
        assertEquals(current + 1, radio.getCurrentStation());
    }

    @Test
    void shouldChangeToNextStationFromMax (){
        radio.setCurrentStation(radio.getMaxStation());
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void shouldChangeToPreviousStation() {
        int current = radio.getCurrentStation();
        radio.previousStation();
        assertEquals(current - 1, radio.getCurrentStation());
    }

    @Test
    void shouldChangeToPreviousStationFromMin() {
        radio.setCurrentStation(radio.getMinStation());
        radio.previousStation();
        assertEquals(10, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From min volume', 100, 0, 0, 1",
                    "'From max volume', 100, 0, 100, 100",
                    "'From middle volume', 100, 0, 50, 51",
            }
    )
    void shouldIncreaseCurrentVolume(String name, int max, int min, int current, int expected) {
        radio.setName(name);
        radio.setMaxVolume(max);
        radio.setMinVolume(min);
        radio.setCurrentVolume(current);

        radio.increaseCurrentVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From min volume', 100, 0, 0, 0",
                    "'From max volume', 100, 0, 100, 99",
                    "'From middle volume', 100, 0, 50, 49",
            }
    )
    void shouldDecreaseCurrentVolume(String name, int max, int min, int current, int expected) {
        radio.setName(name);
        radio.setMaxVolume(max);
        radio.setMinVolume(min);
        radio.setCurrentVolume(current);

        radio.decreaseCurrentVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
}