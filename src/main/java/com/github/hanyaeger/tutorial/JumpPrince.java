package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.tutorial.Levels.BottomFloor.BottomFloor;
import com.github.hanyaeger.tutorial.Levels.Level2.Level2;
import com.github.hanyaeger.tutorial.Levels.TopFloor;
import com.github.hanyaeger.tutorial.Scenes.GameOverScene;
import com.github.hanyaeger.tutorial.Scenes.TitleScene;
import com.github.hanyaeger.tutorial.Scenes.Victory;
import com.github.hanyaeger.tutorial.entities.Enemy.Dragon;
import com.github.hanyaeger.tutorial.entities.King.Prince;
import com.github.hanyaeger.tutorial.entities.text.CoinText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.text.SpeedMeter;

public class JumpPrince extends YaegerGame {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("JumpKing");
        setSize(new Size(800, 1000));
    }


    @Override
    public void setupScenes(){
        HealthText healthText = new HealthText(new Coordinate2D(0,0));
        SpeedMeter speedMeter = new SpeedMeter(new Coordinate2D(0,40));
        CoinText coinText = new CoinText(new Coordinate2D(0,80));
        Prince prince = new Prince(new Coordinate2D( 380, 960), 0.5, 0.05, healthText, this, speedMeter, coinText);


        addScene(0, new TitleScene(this));
        addScene(1, new BottomFloor(this, healthText, speedMeter, coinText, prince));
        addScene(2, new Level2(this, healthText, speedMeter, coinText, prince));
        addScene(3, new TopFloor(this, healthText, speedMeter, coinText, prince));
        addScene(4, new Victory(this, prince));
        addScene(5, new GameOverScene(this, prince));
    }
}
