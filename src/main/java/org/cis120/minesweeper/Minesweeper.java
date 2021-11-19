package org.cis120.minesweeper;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Minesweeper {
    private Cell[][] board;
    private boolean gameLost;
    private int score;
    private String filename;

    public Minesweeper(int level) {

        if (level == 1) {
            filename = "files/level1.txt";
        } else if (level == 2) {
            filename = "files/level2.txt";
        } else if (level == 3) {
            filename = "files/level3.txt";
        } else if (level == 4) {
            filename = "files/save.txt";
        } else {
            filename = "files/empty.txt";
        }
        reset();

    }

    public void reset() {

        board = new Cell[10][10];
        gameLost = false;
        score = 0;

        // create the board according to levels

        try {
            Reader r = new FileReader(filename);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {

                    int x = r.read();

                    if (x == 48) {
                        board[i][j] = new Empty();
                    } else if (x == 49) {
                        board[i][j] = new Number();
                    } else if (x == 50) {
                        board[i][j] = new Mine();
                    } else if (x == 51) {
                        board[i][j] = new Empty();
                        board[i][j].flag();
                    } else if (x == 52) {
                        board[i][j] = new Number();
                        board[i][j].flag();
                    } else if (x == 53) {
                        board[i][j] = new Mine();
                        board[i][j].flag();
                    } else if (x == 54) {
                        board[i][j] = new Empty();
                        board[i][j].reveal();
                    } else if (x == 55) {
                        board[i][j] = new Number();
                        board[i][j].reveal();
                    } else {
                        throw new IllegalArgumentException("level file corrupt");
                    }
                }
            }
            
            r.close();
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            throw new IllegalArgumentException("level file corrupt");
        }

        // get neighboring for each pixel

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cell c = board[i][j];

                if (c != null) {
                    List<Cell> list = new LinkedList<Cell>();
                    for (int col = i - 1; col <= i + 1; col++) {
                        for (int row = j - 1; row <= j + 1; row++) {
                            if (col >= 0 && row >= 0 && col < 10 && row < 10) {
                                Cell x = board[col][row];
                                list.add(x);

                            }
                        }
                    }
                    list.remove(board[i][j]);
                    c.setNeighbors(list);
                }

            }
        }

    }

    public Cell getCell(int c, int r) {
        if (c < 0 || r < 0) {
            throw new IllegalArgumentException("out of bounds");
        }
        return board[r][c];
    }

    public void clickCell(Cell x) {
        if (!gameLost) {
            if (x.isMine()) {
                gameLost = true;
            } else {
                x.reveal();
                score++;
            }
        }

    }

    public void save() {
        try {
            Writer r = new FileWriter("files/save.txt", false);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    Cell x = board[i][j];
                    if (x.isEmpty() && !x.getFlagged() && !x.getRevealed()) {
                        r.write(48);
                    } else if (x.isNumber() && !x.getFlagged() && !x.getRevealed()) {
                        r.write(49);
                    } else if (x.isMine() && !x.getFlagged() && !x.getRevealed()) {
                        r.write(50);
                    } else if (x.isEmpty() && x.getFlagged() && !x.getRevealed()) {
                        r.write(51);
                    } else if (x.isNumber() && x.getFlagged() && !x.getRevealed()) {
                        r.write(52);
                    } else if (x.isMine() && x.getFlagged() && !x.getRevealed()) {
                        r.write(53);
                    } else if (x.isEmpty() && !x.getFlagged() && x.getRevealed()) {
                        r.write(54);
                    } else if (x.isNumber() && !x.getFlagged() && x.getRevealed()) {
                        r.write(55);
                    } else {
                        throw new IllegalArgumentException("bomb is deployed");
                    }
                }
            }
            r.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("level file corrupt");
        }

    }

    public boolean checkWin() {
        boolean gameWon = true;
        if (gameLost) {
            gameWon = false;
        } else {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (board[i][j] != null) {
                        Cell x = this.board[i][j];
                        if (!gameWon) {
                            break;
                        }

                        if (!x.isMine()) {
                            gameWon = gameWon && x.getRevealed();
                        }
                    }

                }
            }

        }

        return gameWon;
    }

    public int getScore() {
        return this.score;
    }

    public boolean gameLost() {
        return this.gameLost;
    }

    public void setLost(boolean x) {
        this.gameLost = x;
    }

    public Cell cellFromPoint(Point p) {
        double x = p.getX();
        double y = p.getY();
        Cell c = null;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int boti = (i * 50);
                int topi = (i * 50) + 50;
                int botj = (j * 50);
                int topj = (j * 50) + 50;
                if (x <= topi && x >= boti && y <= topj && y >= botj) {
                    c = board[i][j];
                }

            }
        }

        return c;
    }

}