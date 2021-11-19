package org.cis120.minesweeper;

import java.awt.Color;
import java.awt.Graphics;

public class Number extends Cell {

    public Number() {
        super();

    }

    public void reveal() {
        if (!super.getFlagged()) {
            super.reveal();
        }
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

            // draw numbers
            int num = 0;
            for (Cell cell : super.getNeighbors()) {
                if (cell.isMine()) {
                    num++;
                }
            }

            // write in numbers
            String number = String.format("%d", num);
            g.setColor(Color.WHITE);
            g.drawString(number, x + 23, y + 23);
            g.drawRect(x, y, x + 50, y + 50);

        } else {
            g.setColor(Color.GRAY);
            g.fillRect(x, y, 50, 50);
            g.setColor(Color.WHITE);
            g.drawRect(x, y, x + 50, y + 50);
        }

    }

    @Override
    public boolean isNumber() {
        return true;
    }

}