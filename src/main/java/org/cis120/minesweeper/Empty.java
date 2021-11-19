package org.cis120.minesweeper;

import java.awt.Color;
import java.awt.Graphics;

public class Empty extends Cell {

    public Empty() {
        super();
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
            // g.fillRect(this.getPx(), this.getPy(), width, this.getHeight());
            g.fillRect(x, y, 50, 50);
            g.setColor(Color.WHITE);
            g.drawRect(x, y, x + 50, y + 50);

        } else {
            g.setColor(Color.GRAY);
            g.fillRect(x, y, 50, 50);
            g.setColor(Color.WHITE);
            g.drawRect(x, y, x + 50, y + 50);
        }
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void reveal() {

        if (!getFlagged()) {
            super.reveal();
            for (Cell cell : super.getNeighbors()) {
                if (!cell.isMine() && !cell.getRevealed()) {
                    cell.reveal();

                }
            }

        }
    }

}