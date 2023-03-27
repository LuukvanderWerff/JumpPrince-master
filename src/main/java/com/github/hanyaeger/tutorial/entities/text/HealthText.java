package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HealthText extends Text {
    public HealthText(Coordinate2D initialLocation){
        super(initialLocation, "Health: ");
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.DARKBLUE);
    }

    public void setHealthText(int health){
        setText(text + health);
    }
}
