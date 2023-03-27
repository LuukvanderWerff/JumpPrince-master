package com.github.hanyaeger.tutorial.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;

public class Text extends TextEntity {

    protected String text;

    public Text(Coordinate2D initialLocation, String text){
        super(initialLocation);
        this.text = text;
    }
}
