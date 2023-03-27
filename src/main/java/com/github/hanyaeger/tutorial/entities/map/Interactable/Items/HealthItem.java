package com.github.hanyaeger.tutorial.entities.map.Interactable.Items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.map.Interactable.Interactable;

public abstract class HealthItem extends Interactable {

    protected int amount;

    public HealthItem(Coordinate2D coordinate2D, Size size, String file, int amount) {
        super(coordinate2D, size, file);
        this.amount = amount;
    }

    public abstract int getAmount();
}
