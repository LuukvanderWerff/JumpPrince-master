package com.github.hanyaeger.tutorial.Levels.BottomFloor;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.JumpPrince;
import com.github.hanyaeger.tutorial.entities.Enemy.Steve;
import com.github.hanyaeger.tutorial.entities.King.Prince;
import com.github.hanyaeger.tutorial.entities.map.BottomFloorTileMap;
import com.github.hanyaeger.tutorial.entities.text.CoinText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.text.SpeedMeter;

public class BottomFloor extends DynamicScene implements TileMapContainer {
    private JumpPrince jumpPrince;

    private HealthText healthText;
    private SpeedMeter speedMeter;
    private CoinText coinText;
    private Prince prince;

    public BottomFloor(JumpPrince jumpPrince, HealthText healthText, SpeedMeter speedMeter, CoinText coinText, Prince prince){
        this.jumpPrince = jumpPrince;
        this.healthText = healthText;
        this.speedMeter = speedMeter;
        this.coinText = coinText;
        this.prince = prince;


    }

    @Override
    public void setupScene(){
        setBackgroundImage("backgrounds/BottomFloor.png");
        setBackgroundAudio("audio/Mick_Gordon_-_11._BFG_Division.mp3");
    }

    public void setupTileMaps() {
        addTileMap(new BottomFloorTileMap());
    }

    public void setupEntities() {
        Steve steve = new Steve(new Coordinate2D(280, 315));
        addEntity(steve);

        addEntity(healthText);

        addEntity(speedMeter);

        addEntity(coinText);

        addEntity(prince);
    }

}
