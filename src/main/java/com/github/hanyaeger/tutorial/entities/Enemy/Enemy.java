package com.github.hanyaeger.tutorial.entities.Enemy;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Enemy extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collider, Collided, HandelInteractieAf{
    public Enemy (String image , Coordinate2D location, double speed, double direction) {
        super(image, location);
        setMotion(speed, direction);
    }

    public Enemy (String image , Coordinate2D location, double speed, double direction, Size size, int rows, int collums) {
        super(image, location, size, rows, collums);
        setMotion(speed, direction);
    }
}
