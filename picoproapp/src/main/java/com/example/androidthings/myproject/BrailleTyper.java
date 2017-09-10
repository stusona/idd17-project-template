package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * IDD Fall 2017 HW2 - Text Entry Device
 * Created by Stuart Sonatina 2017-09-05.
 */

public class BrailleTyper extends SimplePicoPro {
    Gpio button1 = GPIO_128;
    Gpio button2 = GPIO_39;
    Gpio button3 = GPIO_37;
    Gpio button4 = GPIO_35;
    Gpio button5 = GPIO_34;
    Gpio button6 = GPIO_33;

    long buttonTimer;

    boolean buttonPressed = LOW;
    boolean b1;
    boolean b2;
    boolean b3;
    boolean b4;
    boolean b5;
    boolean b6;

    public void setup() {

        //set GPIOs to input
        pinMode(button1, Gpio.DIRECTION_IN);
        pinMode(button2, Gpio.DIRECTION_IN);
        pinMode(button3, Gpio.DIRECTION_IN);
        pinMode(button4, Gpio.DIRECTION_IN);
        pinMode(button5, Gpio.DIRECTION_IN);
        pinMode(button6, Gpio.DIRECTION_IN);

        // set interrupts
        setEdgeTrigger(button1, Gpio.EDGE_FALLING);
        setEdgeTrigger(button2, Gpio.EDGE_FALLING);
        setEdgeTrigger(button3, Gpio.EDGE_FALLING);
        setEdgeTrigger(button4, Gpio.EDGE_FALLING);
        setEdgeTrigger(button5, Gpio.EDGE_FALLING);
        setEdgeTrigger(button6, Gpio.EDGE_FALLING);
    }

    @Override
    public void loop() {
        //nothing to do here
        if (((millis() - buttonTimer) >= 300) && buttonPressed==HIGH) {
            b1 = !digitalRead(button1);
            b2 = !digitalRead(button2);
            b3 = !digitalRead(button3);
            b4 = !digitalRead(button4);
            if      (b1==HIGH && b2== LOW && b3== LOW && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('a');
            else if (b1==HIGH && b2== LOW && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('b');
            else if (b1==HIGH && b2==HIGH && b3== LOW && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('c');
            else if (b1==HIGH && b2==HIGH && b3== LOW && b4==HIGH && b5== LOW && b6== LOW) printCharacterToScreen('d');
            else if (b1==HIGH && b2== LOW && b3== LOW && b4==HIGH && b5== LOW && b6== LOW) printCharacterToScreen('e');

            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');

            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4==HIGH && b5== LOW && b6== LOW) printCharacterToScreen('g');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');
            else if (b1==HIGH && b2==HIGH && b3==HIGH && b4== LOW && b5== LOW && b6== LOW) printCharacterToScreen('f');

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

        /*if (pin==button1) button1State = value;
        if (pin==button2) button2State = value;
        if (pin==button3) button3State = value;
        if (pin==button4) button4State = value;
        if (pin==button5) button5State = value;
        if (pin==button6) button6State = value;
        //*/

    }
}
