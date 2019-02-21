package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    public final int CELL_SIZE = 40;

    private int col;
    private int row;
    private Rectangle cell;


    public Cell (int col, int row){
        this.col = col;
        this.row = row;
        cell = new Rectangle(col*CELL_SIZE,row*CELL_SIZE,CELL_SIZE,CELL_SIZE);
        cell.draw();
    }

    public void setCol (int num){
        col = num;
    }

    public void setRow (int num){
        row = num;
    }

    public int getCol (){
        return col;
    }

    public int getRow (){
        return row;
    }

    public Rectangle getCell (){
        return cell;
    }

}
