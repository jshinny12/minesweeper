package org.cis120.minesweeper;

import java.awt.Color;
import java.awt.Graphics;

public class Mine extends Cell {

    public Mine() {
        super();
    }

    @Override

    public void reveal() {
        if (super.getFlagged()) {
            super.flag();
        }
        super.reveal();

    }

    @Override

    public boolean isMine() {
        return true;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        if (super.getFlagged() && !super.getRevealed()) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, x + 50, y + 50);
            g.setColor(Color.WHITE);
            g.drawRect(x, y, x + 50, y + 50);
        } else if (super.getRevealed()) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, 50, 50);

            g.setColor(Color.WHITE);
            g.fillOval(x, y, 20, 20);

            g.drawRect(x, y, x + 50, y + 50);

        } else {
            g.setColor(Color.GRAY);
            g.fillRect(x, y, 50, 50);
            g.setColor(Color.WHITE);
            g.drawRect(x, y, x + 50, y + 50);
        }
    }

}