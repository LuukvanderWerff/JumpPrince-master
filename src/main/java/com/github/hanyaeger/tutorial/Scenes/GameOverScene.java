package com.github.hanyaeger.tutorial.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.JumpPrince;
import com.github.hanyaeger.tutorial.Button.PlayAgainButton;
import com.github.hanyaeger.tutorial.Button.QuitGameButton;
import com.github.hanyaeger.tutorial.entities.King.Prince;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverScene extends StaticScene{
    JumpPrince jumpPrince;
    Prince prince;

    public GameOverScene(JumpPrince jumpPrince, Prince prince){
        this.jumpPrince = jumpPrince;
        this.prince = prince;
    }

    @Override
    public void setupScene(){
        setBackgroundAudio("audio/Curb_Your_Enthusiasm_Theme.mp3");
        setBackgroundImage("backgrounds/GameOver.png");
    }

    @Override
    public void setupEntities(){

        PlayAgainButton playAgainButton = new PlayAgainButton(new Coordinate2D(getWidth() / 2 + -140, getHeight() / 2 + 80), jumpPrince, prince);
        addEntity(playAgainButton);
        QuitGameButton quitGameButton = new QuitGameButton(new Coordinate2D(getWidth() / 2 + 40, getHeight() / 2 + 80), jumpPrince);
        addEntity(quitGameButton);
    }
}
