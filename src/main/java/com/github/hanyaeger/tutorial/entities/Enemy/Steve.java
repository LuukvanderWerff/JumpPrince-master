package com.github.hanyaeger.tutorial.entities.Enemy;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.King.Prince;
import com.github.hanyaeger.tutorial.entities.map.Interactable.PlatfromBlock;

import java.util.Random;

public class Steve extends Enemy {
    double direction;

    public Steve(Coordinate2D location){
        super("sprites/Steve.png", location, 2, 270d, new Size(80,40), 1,2);
        direction = 270d;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        invertSpeedInDirection(getDirection());
        if(getCurrentFrameIndex() == 0) {
            setCurrentFrameIndex(1);
        } else {
            setCurrentFrameIndex(0);
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        handelInteractieAf();
    }
    @Override
    public void handelInteractieAf() {
        if(getDirection() > 45d && getDirection() <= 135d) { // right
            direction = 270;
            invertSpeedInDirection(90d);
            setCurrentFrameIndex(0);
            System.out.println("steve right");
        } else if(getDirection() > 225d && getDirection() <= 315d) { // left
            direction = 90;
            invertSpeedInDirection(270d);
            setCurrentFrameIndex(1);
            System.out.println("steve left");
        }
    }
}
