package com.github.hanyaeger.tutorial.entities.Enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.tutorial.entities.King.Prince;

import java.util.Random;
public class Dragon extends Enemy{

    private double maxSpeed;
    private double startSpeed;
    private double currentSpeed;
    public Dragon(Coordinate2D location){
        super("sprites/Dragon.png", location, 2, 270d);
        maxSpeed = 10;
        startSpeed = 2;
        currentSpeed = 2;
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border){
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight() - 81));
        setSpeed(startSpeed);
    }

    @Override
    public void onCollision(Collider collidingObject) {
        handelInteractieAf();
    }

    public void handelInteractieAf() {
        currentSpeed += 0.2;
        if(currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
        setSpeed(currentSpeed);
    }
}








