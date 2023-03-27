package com.github.hanyaeger.tutorial.Button;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.tutorial.JumpPrince;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class Button extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    JumpPrince jumpPrince;

    public Button(Coordinate2D initialLocation, JumpPrince jumpPrince, Color color, String text){
        super(initialLocation,text);
        this.jumpPrince = jumpPrince;
        setFill(color);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    /*
    @Override
    public abstract void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D);

    @Override
    public abstract void onMouseEntered();

    @Override
    public abstract void onMouseExited();
     */
}
