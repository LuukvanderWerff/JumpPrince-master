package com.github.hanyaeger.tutorial.entities.map.Interactable.Items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.map.Interactable.Items.CoinItem;

public class CoinChest extends CoinItem {

    public CoinChest(Coordinate2D coordinate2D, Size size, String file) {
        super(coordinate2D, size, file, 10);
    }

    @Override
    public int getValue() {
        return value;
    }
}
