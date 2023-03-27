package com.github.hanyaeger.tutorial.Button;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.JumpPrince;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class QuitGameButton extends Button {
    JumpPrince jumpPrince;

    public QuitGameButton(Coordinate2D initialLocation, JumpPrince jumpPrince){
        super(initialLocation,jumpPrince,Color.PURPLE,"Quit Game");
        this.jumpPrince = jumpPrince;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        jumpPrince.quit();
    }

    @Override
    public void onMouseEntered(){
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.PURPLE);
        setCursor(Cursor.DEFAULT);
    }
}
