package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;
import java.util.Random;

public class Bomb extends MoveEntity {
    private int timeCounter = 0;

    public Bomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
        setLayer(2);
    }

    @Override
    public void update() {
        if (timeCounter++ == 120) { // 120 = 2s
            explode();
            System.out.println("yeb");
        }
        img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, timeCounter, 30).getFxImage();
    }

    public void explode() {
        explosion e = new explosion(x, y);
        e.render_explosion();
        alive = false;
    }

    public boolean isAllowedToPassThrough(MoveEntity e) {
        Rectangle r1 = getBounds();
        Rectangle r2;
        if (e instanceof Bomber) {
            Bomber bomber = (Bomber) e;
            r2 = new Rectangle(bomber.getX() + 4, bomber.getY() + 4, Sprite.SCALED_SIZE * 3 / 4, Sprite.SCALED_SIZE * 3 / 4);
        } else {
            r2 = new Rectangle(e.getX(), e.getY(), Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
        }
        return r1.intersects(r2);
    }
}
