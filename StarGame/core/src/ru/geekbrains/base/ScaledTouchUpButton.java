package ru.geekbrains.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ScaledTouchUpButton extends Sprite {
    private int pointer;
    private boolean isPressed;
    private float pressScale;

    public ScaledTouchUpButton(TextureRegion region) {
        super(region);
        this.pressScale = 0.9f; //уменьшение кнопки при нажатии
    }
}
