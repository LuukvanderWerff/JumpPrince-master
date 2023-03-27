package com.github.hanyaeger.tutorial.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.Button.StartButton;
import com.github.hanyaeger.tutorial.JumpPrince;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private JumpPrince jumpPrince;

    public TitleScene(JumpPrince jumpPrince){
        this.jumpPrince = jumpPrince;
    }

    @Override
    public void setupScene(){
        //setBackgroundAudio("audio/ocean.mp3");
        setBackgroundImage("backgrounds/BottomFloor.png");
    }

    @Override
    public void setupEntities(){
        var jumpKingText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "JUMP KING"
        );
        jumpKingText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        jumpKingText.setFill(Color.DARKGREEN);
        jumpKingText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(jumpKingText);

        StartButton startButton = new StartButton(new Coordinate2D(getWidth() / 2 + 40, getHeight() / 2 + 80), jumpPrince);
        addEntity(startButton);
    }
}
