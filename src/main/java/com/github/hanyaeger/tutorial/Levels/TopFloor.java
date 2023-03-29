package com.github.hanyaeger.tutorial.Levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.tutorial.JumpPrince;
import com.github.hanyaeger.tutorial.entities.Enemy.Dragon;
import com.github.hanyaeger.tutorial.entities.Enemy.Steve;
import com.github.hanyaeger.tutorial.entities.King.Prince;
import com.github.hanyaeger.tutorial.entities.map.Level2TileMap;
import com.github.hanyaeger.tutorial.entities.map.TopFloorTileMap;
import com.github.hanyaeger.tutorial.entities.text.CoinText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.text.SpeedMeter;

public class TopFloor extends DynamicScene implements TileMapContainer {
    private JumpPrince jumpPrince;

    private HealthText healthText;
    private SpeedMeter speedMeter;
    private CoinText coinText;
    private Prince prince;


    public TopFloor(JumpPrince jumpPrince, HealthText healthText, SpeedMeter speedMeter, CoinText coinText, Prince prince){
        this.jumpPrince = jumpPrince;
        this.healthText = healthText;
        this.speedMeter = speedMeter;
        this.coinText = coinText;
        this.prince = prince;



        healthText.setHealthText(prince.health);
        coinText.setCoinText(prince.coins);
    }

    @Override
    public void setupScene(){
        setBackgroundAudio("audio/Mick_Gordon_-_11._BFG_Division.mp3");
        setBackgroundImage("backgrounds/TopFloor.png");
        prince.resetNewtonian();
    }

    public void setupTileMaps() {
        addTileMap(new TopFloorTileMap());
    }

    public void setupEntities() {

        addEntity(healthText);

        addEntity(speedMeter);

        addEntity(coinText);

        addEntity(prince);
        Dragon dragon = new Dragon(new Coordinate2D(800, 500));
        addEntity(dragon);
    }


}
