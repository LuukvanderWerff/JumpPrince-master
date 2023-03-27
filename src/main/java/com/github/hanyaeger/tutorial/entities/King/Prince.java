package com.github.hanyaeger.tutorial.entities.King;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.tutorial.JumpPrince;
import com.github.hanyaeger.tutorial.entities.Dragon;
import com.github.hanyaeger.tutorial.entities.map.Interactable.Items.CoinItem;
import com.github.hanyaeger.tutorial.entities.map.Interactable.Flag;
import com.github.hanyaeger.tutorial.entities.map.Interactable.Items.HealthItem;
import com.github.hanyaeger.tutorial.entities.map.Interactable.PlatfromBlock;
import com.github.hanyaeger.tutorial.entities.map.Interactable.Spike;
import com.github.hanyaeger.tutorial.entities.text.CoinText;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import com.github.hanyaeger.tutorial.entities.text.SpeedMeter;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Prince extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided, Collider {
    private JumpPrince jumpPrince;
    private HealthText healthText;
    private CoinText coinText;
    public int health = 3;
    public int coins = 0;
    private Coordinate2D mousePosition;
    private SpeedMeter speedMeter;
    private int speed = 0;
    public int current_active_scene = 1;


    public Prince(Coordinate2D location, HealthText healthText, JumpPrince jumpPrince, SpeedMeter speedMeter, CoinText coinText){
        super("sprites/King.png", location, new Size(40,80));
        this.healthText = healthText;
        this.jumpPrince = jumpPrince;
        this.speedMeter = speedMeter;
        this.coinText = coinText;

        healthText.setHealthText(health);
        coinText.setCoinText(coins);
        setGravityConstant(0.5);
        setFrictionConstant(0.05);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys){
        speedMeter.setSpeedMeter(speed);

        if (pressedKeys.contains(KeyCode.SPACE)){
            speed++;
        } else if (pressedKeys.contains(KeyCode.C)){
            speed--;
        }

        if (speed > 20) {
            speed--;
        } else if (speed < 0) {
            speed++;
        }

        if (pressedKeys.contains(KeyCode.LEFT)){
            setMotion(speed, 210d);
        } else if (pressedKeys.contains(KeyCode.RIGHT)){
            setMotion(speed, 150d);
        } else if (pressedKeys.contains(KeyCode.UP)){
            setMotion(speed, 180d);
        }
    }


    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(Collider collidingObject){
        System.out.println("collision");
        if(collidingObject instanceof PlatfromBlock) {
            System.out.println("Platformblock");
            if(getDirection() > 315d && getDirection() <= 45d) { //down
                setSpeed(0);
                System.out.println("down");
            } else if(getDirection() > 45d && getDirection() <= 135d) { // right
                setSpeed(10);
                invertSpeedInDirection(getDirection());
                System.out.println("right");
            } else if(getDirection() > 135d && getDirection() <= 225d) { // up
                setSpeed(10);
                invertSpeedInDirection(getDirection());
                System.out.println("up");
            } else if(getDirection() > 225d && getDirection() <= 315d) { // left
                setSpeed(10);
                invertSpeedInDirection(getDirection());
                System.out.println("left");
            } else {
                System.out.println("none");
                setSpeed(0);
            }


        } else if (collidingObject instanceof Spike) {
            System.out.println("Spike");
            setSpeed(0);
            setAnchorLocation(new Coordinate2D( (getSceneWidth()/2) - (getWidth()/2) , (getSceneHeight()-getHeight())));
            health--;
            healthText.setHealthText(health);
            if(health <= 0) {
                jumpPrince.setActiveScene(101);
            }
        } else if(collidingObject instanceof CoinItem) {
            coins += ((CoinItem) collidingObject).getValue();
            coinText.setCoinText(coins);
            ((CoinItem) collidingObject).remove();
        } else if(collidingObject instanceof Flag) {
            this.current_active_scene += 1;
            setAnchorLocation(new Coordinate2D(380, 960));
            jumpPrince.setActiveScene(current_active_scene);
        } else if(collidingObject instanceof HealthItem && health < 3) {
            health += ((HealthItem) collidingObject).getAmount();
            healthText.setHealthText(health);
            ((HealthItem) collidingObject).remove();
        } else if(collidingObject instanceof Dragon && coins > 0){
            coins -= 5;
            coinText.setCoinText(coins);
            setAnchorLocation(new Coordinate2D( (getSceneWidth()/2) - (getWidth()/2) , (getSceneHeight()-getHeight())));
            } else {
                health -= 1;
                healthText.setHealthText(health);
                setAnchorLocation(new Coordinate2D( (getSceneWidth()/2) - (getWidth()/2) , (getSceneHeight()-getHeight())));
            if(health <= 0) {
                jumpPrince.setActiveScene(101);
            }
        }
    }
}
