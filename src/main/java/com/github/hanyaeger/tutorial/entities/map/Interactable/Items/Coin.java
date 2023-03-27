package com.github.hanyaeger.tutorial.entities.map.Interactable.Items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.tutorial.entities.map.Interactable.Items.CoinItem;

public class Coin extends CoinItem {

    public Coin(Coordinate2D coordinate2D, Size size, String file) {
        super(coordinate2D, size, file, 1);
    }



    @Override
    public int getValue() {
        return value;
    }
}
