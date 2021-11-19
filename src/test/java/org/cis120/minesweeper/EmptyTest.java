package org.cis120.minesweeper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

public class EmptyTest {

    @Test
    public void testConstructor() {
        Cell c = new Empty();
        Boolean q = c.getRevealed();
        Boolean r = c.getFlagged();
        List<Cell> list = c.getNeighbors();
        List<Cell> expected = new LinkedList<Cell>();

        assertEquals(list, expected);
        assertTrue(!q);
        assertTrue(!r);
        assertTrue(c.isEmpty());
        assertFalse(c.isMine());
        assertFalse(c.isNumber());

    }

    @Test
    public void testReveal() {
        Cell c = new Empty();
        c.reveal();
        assertTrue(c.getRevealed());

    }

    @Test
    public void testRevealEdge() {
        Cell c = new Empty();
        c.flag();
        c.reveal();
        assertFalse(c.getRevealed());

    }

    @Test
    public void testFlag() {
        Cell c = new Empty();
        c.flag();
        assertTrue(c.getFlagged());

    }

    @Test
    public void testFlagEdge() {
        Cell c = new Empty();
        c.flag();
        c.flag();
        assertFalse(c.getFlagged());

    }

    @Test
    public void testFlagRevealed() {
        Cell c = new Empty();
        c.reveal();
        c.flag();
        assertFalse(c.getFlagged());

    }

}
