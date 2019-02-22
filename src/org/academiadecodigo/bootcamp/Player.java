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


    public void moveLeft (){
        if (player.getCol()>0){
            player.setCol(-1);
            player.getCell().translate(-player.CELL_SIZE,0);}
    }

    public void moveRight (){
        if (player.getCol()<Grid.TOTAL_COLS-1){
            player.setCol(1);
            player.getCell().translate(player.CELL_SIZE,0);}
    }

    public void moveUp (){
        if (player.getRow()>0){
            player.setRow(-1);
            player.getCell().translate(0,-player.CELL_SIZE);}
    }

    public void moveDown (){
        if (player.getRow()<Grid.TOTAL_ROWS-1){
            player.setRow(1);
            player.getCell().translate(0,player.CELL_SIZE);}
    }


    public int getCol (){
        return player.getCol();
    }

    public int getRow (){
        return player.getRow();
    }

}
