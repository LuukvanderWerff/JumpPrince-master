package com.github.hanyaeger.tutorial.entities.map.Interactable.Items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class HealthPack extends HealthItem{

    public HealthPack(Coordinate2D coordinate2D, Size size, String file){
        super(coordinate2D, size, file, 1);
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
