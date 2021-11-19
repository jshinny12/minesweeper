package org.cis120.minesweeper;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

public class RunMinesweeper implements Runnable {

    public void run() {

        // Top-level frame in which game components live
        final JFrame frame = new JFrame("MineSweeper");
        frame.setLocation(1000, 1000);

        // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("Setting up...");
        status_panel.add(status);

        // Game board
        final Board board = new Board(status);
        frame.add(board, BorderLayout.CENTER);

        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        final JPanel control_panel2 = new JPanel();
        frame.add(control_panel2, BorderLayout.EAST);

        final JButton reset = new JButton("Reset");
        final JButton level1 = new JButton("Level 1");
        final JButton level2 = new JButton("Level 2");
        final JButton level3 = new JButton("Level 3");
        final JButton instructions = new JButton("Instructions");
        final JButton save = new JButton("Save");
        final JButton load = new JButton("Load");

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.setMinesweeper(new Minesweeper(0));
                board.reset();
            }
        });

        level1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.setMinesweeper(new Minesweeper(1));
                board.reset();

            }
        });
        level2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.setMinesweeper(new Minesweeper(2));
                board.reset();

            }
        });
        level3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.setMinesweeper(new Minesweeper(3));
                board.reset();

            }
        });

        instructions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File u = new File("files/instructions.txt");

                Desktop d = Desktop.getDesktop();
                try {
                    d.open(u);
                } catch (IOException e1) {
                    throw new IllegalArgumentException("can't open file");
                }

            }
        });

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.save();
            }
        });
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.setMinesweeper(new Minesweeper(4));
                board.reset();

            }
        });

        control_panel2.add(reset);
        control_panel.add(level1);
        control_panel.add(level2);
        control_panel.add(level3);
        control_panel2.add(save);
        control_panel2.add(load);
        control_panel.add(instructions);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start the game
        board.reset();
    }

}