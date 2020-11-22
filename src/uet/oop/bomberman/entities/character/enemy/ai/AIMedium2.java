package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;

public class AIMedium2 extends AI {
    Enemy _e;
    AILow aiLow;
    Bomb _bomb;

    public AIMedium2(Bomb bomb, Enemy e) {
        _e = e;
        _bomb = bomb;
        aiLow = new AILow();
    }

    @Override
    public int calculateDirection() {
        // TODO: cài đặt thuật toán tìm đường đi
        int random = (int) (Math.random() * 3);
        return calculateDirection(random);
    }

    public int calculateDirection(int random) {
        if (random == 0) return calculateColDirection();
        if (random == 1) return calculateRowDirection();

        return aiLow.calculateDirection();
    }

    protected int calculateColDirection() {
        if (_bomb.getXTile() < _e.getXTile()) return 1;
        if (_bomb.getXTile() > _e.getXTile()) return 3;

        return -1;
    }

    protected int calculateRowDirection() {
        if (_bomb.getYTile() < _e.getYTile()) return 2;
        if (_bomb.getYTile() > _e.getYTile()) return 0;

        return -1;
    }

}
