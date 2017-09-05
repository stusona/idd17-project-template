package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * IDD Fall 2017 HW2 - Text Entry Device
 * Created by Stuart Sonatina 2017-09-05.
 */

public class Hw2TemplateApp extends SimplePicoPro {
    Gpio button1 = GPIO_128;
    Gpio button2 = GPIO_39;
    Gpio button3 = GPIO_37;
    Gpio button4 = GPIO_35;
    Gpio button5 = GPIO_34;
    Gpio button6 = GPIO_33;

    long buttonTimer;

    boolean buttonPressed = LOW;
    boolean button1State;
    boolean button2State;
    boolean button3State;
    boolean button4State;
    boolean button5State;
    boolean button6State;

    public void setup() {

        //set GPIOs to input
        pinMode(button1, Gpio.DIRECTION_IN);
        pinMode(button2, Gpio.DIRECTION_IN);
        pinMode(button3, Gpio.DIRECTION_IN);
        pinMode(button4, Gpio.DIRECTION_IN);
        pinMode(button5, Gpio.DIRECTION_IN);
        pinMode(button6, Gpio.DIRECTION_IN);

        // set interrupts
        setEdgeTrigger(button1, Gpio.EDGE_BOTH);
        setEdgeTrigger(button2, Gpio.EDGE_BOTH);
        setEdgeTrigger(button3, Gpio.EDGE_BOTH);
        setEdgeTrigger(button4, Gpio.EDGE_BOTH);
        setEdgeTrigger(button5, Gpio.EDGE_BOTH);
        setEdgeTrigger(button6, Gpio.EDGE_BOTH);

    }

    @Override
    public void loop() {
        //nothing to do here
        if (((millis() - buttonTimer) >= 300) && buttonPressed==HIGH) {
            if (button1State==HIGH && button2State==LOW) printCharacterToScreen('a');
            if (button1State==LOW && button2State==HIGH) printCharacterToScreen('b');
            if (button1State==HIGH && button2State==HIGH) printCharacterToScreen('c');

            // finished with character, set buttonPressed flag back to low
            buttonPressed = LOW;
        }
    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {

        if (buttonPressed == LOW) {
            // reset timer
            buttonTimer = millis();
            buttonPressed = HIGH;
        }

        println("digitalEdgeEvent"+pin+", "+value);

        if (pin==button1) button1State = value;
        if (pin==button2) button2State = value;
        if (pin==button3) button3State = value;
        if (pin==button4) button4State = value;
        if (pin==button5) button5State = value;
        if (pin==button6) button6State = value;

    }
}
