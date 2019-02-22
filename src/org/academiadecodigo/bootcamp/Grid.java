package org.academiadecodigo.bootcamp;

import java.util.Arrays;

public class Grid {

    public static final int TOTAL_COLS = 10;
    public static final int TOTAL_ROWS = 10;

    private Cell[] grid;


    public Grid (){
        grid = new Cell[TOTAL_COLS*TOTAL_ROWS];
        createGrid();
    }


    private void createGrid (){
        int index = 0;
        for (int i=0; i<TOTAL_COLS; i++){
            for (int j=0; j<TOTAL_ROWS; j++){
                Cell cell = new Cell(i,j);
                grid[index] = cell;
                index++;
            }
        }
    }


    public Cell[] getGrid (){
        return grid;
    }


    @Override
    public String toString() {
        return "Grid{" +
                "grid=" + Arrays.toString(grid) +
                '}';
    }
}
