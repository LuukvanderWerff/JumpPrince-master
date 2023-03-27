package com.github.hanyaeger.tutorial.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import java.util.Random;
public class Dragon extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider{
    public Dragon(Coordinate2D location){
        super("sprites/Dragon.png", location);
        setMotion(2, 270d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }
}








