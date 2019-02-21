package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Player {

    private final int INIT_COL = 0;
    private final int INIT_ROW = 0;

    private Cell player;

    public Player (Color color){
        player = new Cell(INIT_COL,INIT_ROW);
        player.getCell().fill();
        player.getCell().setColor(color);
    }




}
