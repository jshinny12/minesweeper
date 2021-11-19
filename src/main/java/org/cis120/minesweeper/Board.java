package org.cis120.minesweeper;

/**
 * CIS 120 HW09 - TicTacToe Demo
 * (c) University of Pennsylvania
 * Created by Bayley Tuch, Sabrina Green, and Nicolas Corona in Fall 2020.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class instantiates a TicTacToe object, which is the model for the game.
 * As the user clicks the game board, the model is updated. Whenever the model
 * is updated, the game board repaints itself and updates its status JLabel to
 * reflect the current state of the model.
 * 
 * This game adheres to a Model-View-Controller design framework. This
 * framework is very effective for turn-based games. We STRONGLY
 * recommend you review these lecture slides, starting at slide 8,
 * for more details on Model-View-Controller:
 * https://www.seas.upenn.edu/~cis120/current/files/slides/lec37.pdf
 * 
 * In a Model-View-Controller framework, GameBoard stores the model as a field
 * and acts as both the controller (with a MouseListener) and the view (with
 * its paintComponent method and the status JLabel).
 */
@SuppressWarnings("serial")
public class Board extends JPanel {

    private Minesweeper ms;
    private JLabel status;
    private int level = 0;

    // Game constants
    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 500;

    /**
     * Initializes the game board.
     */
    public Board(JLabel statusInit) {

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setFocusable(true);

        ms = new Minesweeper(level);
        status = statusInit;
        if (!ms.gameLost()) {

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Point p = e.getPoint();
                    Cell x = ms.cellFromPoint(p);
                    if (x != null) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            ms.clickCell(x);
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            x.flag();
                        }

                    }

                    updateStatus();
                    repaint();

                }
            });
        } else {
            updateStatus();
            repaint();
        }

    }

    public void reset() {

        // change filename implementation in minesweeper

        ms.reset();
        status.setText("Start play");
        repaint();

        requestFocusInWindow();

    }

    public void save() {
        ms.save();
    }

    private void updateStatus() {
        String x = String.format("%d", ms.getScore());
        if (ms.gameLost()) {
            status.setText("GAME LOST:" + x);

        } else if (!ms.checkWin()) {
            status.setText(x);
        } else {

            status.setText("GAME WON!" + x);
        }

    }

    public void setLevel(int x) {
        this.level = x;
    }

    public void setMinesweeper(Minesweeper q) {
        this.ms = q;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draws board grid
        g.drawLine(0, 1000, 0, 1000);
        g.drawLine(1000, 0, 0, 1000);
        g.drawLine(1000, 0, 1000, 0);

        // draw the board
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cell state = ms.getCell(j, i);
                int x = (j * 50);
                int y = (i * 50);
                if (state != null) {
                    state.draw(g, y, x);
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
    }
}
