package org.cis120.minesweeper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;
import java.util.List;

public class MinesweeperTest {

    @Test
    public void testConstructor() {
        Minesweeper ms = new Minesweeper(0);
        int score = ms.getScore();
        boolean gameLost = ms.gameLost();
        Cell x = ms.getCell(0, 0);
        boolean empty = x.isEmpty();

        assertEquals(0, score);
        assertFalse(gameLost);
        assertTrue(empty);
        List<Cell> list = x.getNeighbors();

        x.reveal();

        for (Cell q : list) {

            assertTrue(q.isEmpty());

            if (!q.isMine()) {
                assertTrue(q.getRevealed());
            } else {
                assertFalse(q.getRevealed());
            }

        }
        assertFalse(list.contains(x));

    }

    // can't test error because there is no way to get an error

    @Test
    public void testConstructor1() {
        Minesweeper ms = new Minesweeper(1);
        int score = ms.getScore();
        boolean gameLost = ms.gameLost();
        Cell x = ms.getCell(0, 0);
        boolean empty = x.isEmpty();

        assertEquals(0, score);
        assertFalse(gameLost);
        assertTrue(empty);
        List<Cell> list = x.getNeighbors();

        x.reveal();

        for (Cell q : list) {

            assertTrue(q.isEmpty());

            if (!q.isMine()) {
                assertTrue(q.getRevealed());
            } else {
                assertFalse(q.getRevealed());
            }

        }
        assertFalse(list.contains(x));

        Cell c = ms.getCell(5, 7);
        List<Cell> list2 = c.getNeighbors();
        assertFalse(list2.contains(x));
        for (Cell q : list2) {
            if (!q.isMine()) {
                assertTrue(q.getRevealed());
            } else {
                assertFalse(q.getRevealed());
            }
        }

    }

    @Test
    public void testConstructor2() {
        Minesweeper ms = new Minesweeper(2);
        int score = ms.getScore();
        boolean gameLost = ms.gameLost();
        Cell x = ms.getCell(0, 0);
        boolean empty = x.isEmpty();

        assertEquals(0, score);
        assertFalse(gameLost);
        assertTrue(empty);
        List<Cell> list = x.getNeighbors();

        x.reveal();

        for (Cell q : list) {

            assertTrue(q.isEmpty());

            if (!q.isMine()) {
                assertTrue(q.getRevealed());
            } else {
                assertFalse(q.getRevealed());
            }

        }
        assertFalse(list.contains(x));

        Cell c = ms.getCell(5, 7);
        List<Cell> list2 = c.getNeighbors();
        assertFalse(list2.contains(x));
        for (Cell q : list2) {
            if (!q.isMine()) {
                assertTrue(q.getRevealed());
            } else {
                assertFalse(q.getRevealed());
            }
        }
    }

    @Test
    public void testConstructor3() {
        Minesweeper ms = new Minesweeper(3);
        int score = ms.getScore();
        boolean gameLost = ms.gameLost();
        Cell x = ms.getCell(0, 0);
        boolean empty = x.isEmpty();

        assertEquals(0, score);
        assertFalse(gameLost);
        assertTrue(empty);
        List<Cell> list = x.getNeighbors();

        x.reveal();

        for (Cell q : list) {

            assertTrue(q.isEmpty());

            if (!q.isMine()) {
                assertTrue(q.getRevealed());
            } else {
                assertFalse(q.getRevealed());
            }

        }
        assertFalse(list.contains(x));

        Cell c = ms.getCell(5, 7);
        List<Cell> list2 = c.getNeighbors();
        assertFalse(list2.contains(x));
        for (Cell q : list2) {
            if (!q.isMine()) {
                assertTrue(q.getRevealed());
            } else {
                assertFalse(q.getRevealed());
            }
        }
    }

    @Test
    public void testGetCellNumber() {
        Minesweeper ms = new Minesweeper(1);
        Cell q = ms.getCell(5, 0);
        assertTrue(q.isNumber());
        List<Cell> list = q.getNeighbors();
        q.reveal();
        for (Cell c : list) {
            assertFalse(c.getRevealed());
        }

    }

    @Test
    public void testGetCellMine() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(6, 0);
        assertTrue(r.isMine());
        List<Cell> list = r.getNeighbors();
        ms.clickCell(r);
        for (Cell c : list) {
            assertFalse(c.getRevealed());
        }
        assertTrue(ms.gameLost());

    }

    @Test
    public void testGetCellEmpty() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(0, 0);
        assertTrue(r.isEmpty());
        List<Cell> list = r.getNeighbors();
        ms.clickCell(r);
        for (Cell c : list) {
            assertTrue(c.getRevealed());
        }
        assertFalse(ms.gameLost());

    }

    @Test
    public void testGetCellEdge() {
        Minesweeper ms = new Minesweeper(1);

        assertThrows(
                IllegalArgumentException.class,
            () -> {
                ms.getCell(0, -1);
            }
        );

    }

    @Test
    public void testClickCellEdge() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(6, 0);
        assertTrue(r.isMine());
        ms.clickCell(r);
        assertTrue(ms.gameLost());

    }

    @Test
    public void testClickCellEmpty() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(0, 0);
        assertTrue(r.isEmpty());
        List<Cell> list = r.getNeighbors();
        ms.clickCell(r);
        for (Cell c : list) {
            assertTrue(c.getRevealed());
        }
        assertFalse(ms.gameLost());
        assertEquals(1, ms.getScore());
        assertTrue(r.getRevealed());
    }

    @Test
    public void testClickCellNumber() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(5, 0);
        assertTrue(r.isNumber());
        List<Cell> list = r.getNeighbors();
        ms.clickCell(r);
        for (Cell c : list) {
            assertFalse(c.getRevealed());
        }
        assertFalse(ms.gameLost());
        assertEquals(1, ms.getScore());
        assertTrue(r.getRevealed());

    }

    @Test
    public void testClickCellMultiple() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(5, 0);
        Cell q = ms.getCell(0, 0);
        assertTrue(r.isNumber());
        assertTrue(q.isEmpty());
        List<Cell> list = r.getNeighbors();
        ms.clickCell(r);
        for (Cell c : list) {
            assertFalse(c.getRevealed());
        }
        assertFalse(ms.gameLost());
        assertEquals(1, ms.getScore());
        assertTrue(r.getRevealed());

        ms.clickCell(q);

        for (Cell c : list) {
            if (!c.isMine()) {
                assertTrue(c.getRevealed());
            } else {
                assertFalse(c.getRevealed());
            }

        }
        assertTrue(q.getRevealed());
        assertEquals(2, ms.getScore());
        assertFalse(ms.gameLost());
    }

    @Test
    public void testCheckWinNormal() {
        Minesweeper ms = new Minesweeper(0);
        Cell r = ms.getCell(0, 0);
        ms.clickCell(r);
        boolean win = ms.checkWin();
        assertTrue(win);
    }

    @Test
    public void testCheckWinEdge() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(6, 0);
        ms.clickCell(r);
        boolean win = ms.checkWin();
        assertFalse(win);
    }

    @Test
    public void testCheckWinNotWonYet() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(0, 0);
        ms.clickCell(r);
        boolean win = ms.checkWin();
        assertFalse(win);
    }

    @Test
    public void testCellFromPointZero() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(0, 0);
        Point p = new Point(0, 0);
        Cell q = ms.cellFromPoint(p);
        assertEquals(r, q);
    }

    @Test
    public void testCellFromPointNormal() {
        Minesweeper ms = new Minesweeper(1);
        Cell r = ms.getCell(6, 0);
        Point p = new Point(0, 300);
        Cell q = ms.cellFromPoint(p);
        assertEquals(r, q);
    }

    @Test
    public void testCellFromPointEdge() {
        Minesweeper ms = new Minesweeper(1);
        Point p = new Point(0, 2000);
        Cell q = ms.cellFromPoint(p);
        assertNull(q);
    }

    @Test
    public void testWorkingGameZero() {
        Minesweeper ms = new Minesweeper(0);
        Point p = new Point(0, 0);
        Cell q = ms.cellFromPoint(p);
        assertFalse(q.getRevealed());
        assertFalse(ms.gameLost());
        assertFalse(ms.checkWin());

        ms.clickCell(q);

        assertTrue(q.getRevealed());
        assertFalse(ms.gameLost());
        assertTrue(ms.checkWin());

    }

    @Test
    public void testWorkingGameNormal() {
        Minesweeper ms = new Minesweeper(1);
        Point p = new Point(0, 0);
        Cell q = ms.cellFromPoint(p);
        assertFalse(q.getRevealed());
        assertFalse(ms.gameLost());
        assertFalse(ms.checkWin());

        ms.clickCell(q);

        assertTrue(q.getRevealed());
        assertFalse(ms.gameLost());
        assertFalse(ms.checkWin());

        List<Cell> list = q.getNeighbors();
        for (Cell c : list) {
            if (!c.isMine()) {
                assertTrue(q.getRevealed());
            }
        }

        Point x = new Point(0, 250);
        Cell y = ms.cellFromPoint(x);

        assertTrue(y.getRevealed());
        assertFalse(ms.gameLost());
        assertFalse(ms.checkWin());

        ms.clickCell(y);

        assertFalse(ms.gameLost());
        assertFalse(ms.checkWin());

        Point m = new Point(0, 300);
        Cell n = ms.cellFromPoint(m);

        assertFalse(n.getRevealed());
        assertFalse(ms.gameLost());
        assertFalse(ms.checkWin());

        ms.clickCell(n);

        assertTrue(ms.gameLost());
        assertFalse(ms.checkWin());

    }

}
