package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SpeedMeter extends Text {

    public SpeedMeter(Coordinate2D initialLocation){
        super(initialLocation, "Speed: ");
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.WHITE);
    }

    public void setSpeedMeter(int speed){
        setText(text + speed);
    }
}
