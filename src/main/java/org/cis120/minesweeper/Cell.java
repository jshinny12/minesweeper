package org.cis120.minesweeper;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

public class Cell {

    private List<Cell> neighboringCells;
    private boolean revealed;
    private boolean flagged;

    public Cell() {
        neighboringCells = new LinkedList<Cell>();
        revealed = false;
        flagged = false;
    }

    public void setNeighbors(List<Cell> list) {
        this.neighboringCells = list;
    }

    public List<Cell> getNeighbors() {
        return this.neighboringCells;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isMine() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean getRevealed() {
        return this.revealed;
    }

    public void setRevealed(boolean x) {
        this.revealed = x;
    }

    public boolean getFlagged() {
        return this.flagged;
    }

    public void reveal() {
        if (!this.flagged) {
            this.revealed = true;
        }

    }

    public void flag() {
        if (this.flagged && !this.revealed) {
            this.flagged = false;
        } else if (!this.flagged && !this.revealed) {
            this.flagged = true;
        }
    }

    public void draw(Graphics g, int x, int y) {

    }

}