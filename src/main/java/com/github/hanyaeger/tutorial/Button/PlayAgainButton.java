package com.github.hanyaeger.tutorial.Button;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.tutorial.JumpPrince;
import com.github.hanyaeger.tutorial.entities.King.Prince;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class PlayAgainButton extends Button {
    JumpPrince jumpPrince;
    Prince prince;

    public PlayAgainButton(Coordinate2D initialLocation, JumpPrince jumpPrince, Prince prince){
        super(initialLocation,jumpPrince,Color.PURPLE,"Play Again");
        this.jumpPrince = jumpPrince;
        this.prince = prince;
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D){
        prince.current_active_scene = 1;
        prince.health = 3;
        prince.coins = 0;
        jumpPrince.setActiveScene(prince.current_active_scene);
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
