package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CoinText extends Text {
    public CoinText(Coordinate2D initialLocation){
        super(initialLocation, "coins: ");
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.GOLD);
    }

    public void setCoinText(int coins){
        setText(text + coins);
    }
}
