package org.academiadecodigo.bootcamp;

public class Grid {

    public final int TOTAL_COLS = 10;
    public final int TOTAL_ROWS = 10;
    public final int PADDING = 10;

    //private int[][] cells;
    private Cell[] grid;


    public Grid (){
        grid = new Cell[TOTAL_COLS*TOTAL_ROWS];
        createGrid();
    }

    public void createGrid (){
        int index = 0;
        for (int i=0; i<TOTAL_COLS; i++){
            for (int j=0; j<TOTAL_ROWS; j++){
                Cell cell = new Cell(i,j);
                grid[index] = cell;
                index++;
                //System.out.println("col: " + cell.getCol() + " row: " + cell.getRow());
            }
        }
    }



}
