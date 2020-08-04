package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From zero station', 9, 0, 0, 1",
                    "'From before last station', 9, 0, 8, 9",
                    "'From last station', 9, 0, 9, 0",
            }
    )
    void shouldChangeToNextStation(String name, int max, int min, int current, int expected) {
        Radio radio = new Radio();
        radio.setName(name);
        radio.setMaxStation(max);
        radio.setMinStation(min);
        radio.setCurrentStation(current);

        radio.nextStation();
        assertEquals(expected, radio.getCurrentStation());
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From zero station', 9, 0, 0, 9",
                    "'From first station', 9, 0, 1, 0",
                    "'From last station', 9, 0, 9, 8",
            }
    )
    void shouldChangeToPreviousStation(String name, int max, int min, int current, int expected) {
        Radio radio = new Radio();
        radio.setName(name);
        radio.setMaxStation(max);
        radio.setMinStation(min);
        radio.setCurrentStation(current);

        radio.previousStation();
        assertEquals(expected, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'From min volume', 10, 0, 0, 1",
                    "'From max volume', 10, 0, 10, 10",
                    "'From middle volume', 10, 0, 5, 6",
            }
    )
    void shouldIncreaseCurrentVolume(String name, int max, int min, int current, int expected) {
        Radio radio = new Radio();
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
                    "'From min volume', 10, 0, 0, 0",
                    "'From max volume', 10, 0, 10, 9",
                    "'From middle volume', 10, 0, 5, 4",
            }
    )
    void shouldDecreaseCurrentVolume(String name, int max, int min, int current, int expected) {
        Radio radio = new Radio();
        radio.setName(name);
        radio.setMaxVolume(max);
        radio.setMinVolume(min);
        radio.setCurrentVolume(current);

        radio.decreaseCurrentVolume();
        assertEquals(expected, radio.getCurrentVolume());
    }
}