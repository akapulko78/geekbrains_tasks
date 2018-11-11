package ru.geekbrains.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;
import ru.geekbrains.sprite.Bullet;

public class Ship extends Sprite {
    protected Vector2 v = new Vector2();
    protected Rect worldBounds;
    protected BulletPool bulletPool;
    protected TextureAtlas atlas;
    protected Vector2 bulletV = new Vector2();
    protected float bulletHeight;
    protected int bulletDamage;
    protected float reloadInterval;
    protected float reloadTimer;
    private Sound shootSound;


    public Ship(TextureRegion region, int rows, int cols, int frames, Sound shootSound) {
        super(region, rows, cols, frames);
        this.shootSound = shootSound;
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    protected void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, atlas.findRegion("bulletMainShip"), pos,
                bulletV, bulletHeight, worldBounds, bulletDamage);
        shootSound.play();
    }
}
