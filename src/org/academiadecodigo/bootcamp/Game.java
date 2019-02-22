package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Game implements KeyboardHandler {

    private final String FILE_PATH = "resources/save";

    private Grid grid;
    private Player player;
    private Keyboard keyboard;
    private FileWriter save;



    public Game (){
        grid = new Grid();
        player = new Player(Color.GRAY);
        createControlKeys();
    }


    private void addEvent (int key, KeyboardEventType type){
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }


    public void createControlKeys (){
        keyboard = new Keyboard(this);
        addEvent(KeyboardEvent.KEY_LEFT,KeyboardEventType.KEY_PRESSED);
        addEvent(KeyboardEvent.KEY_RIGHT,KeyboardEventType.KEY_PRESSED);
        addEvent(KeyboardEvent.KEY_UP,KeyboardEventType.KEY_PRESSED);
        addEvent(KeyboardEvent.KEY_DOWN,KeyboardEventType.KEY_PRESSED);
        addEvent(KeyboardEvent.KEY_SPACE,KeyboardEventType.KEY_PRESSED);
        addEvent(KeyboardEvent.KEY_L,KeyboardEventType.KEY_PRESSED);
        addEvent(KeyboardEvent.KEY_S,KeyboardEventType.KEY_PRESSED);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_LEFT: player.moveLeft();break;
            case KeyboardEvent.KEY_RIGHT: player.moveRight();break;
            case KeyboardEvent.KEY_UP: player.moveUp();break;
            case KeyboardEvent.KEY_DOWN: player.moveDown();break;
            case KeyboardEvent.KEY_SPACE: paintCell();break;
            case KeyboardEvent.KEY_S: saveFile(); System.out.println("The game was saved!");break;
            case KeyboardEvent.KEY_L:
            default: System.out.println("this key doesn't apply in this game!");
        }
    }

    private void paintCell (){
        int playerCol = player.getCol();
        int playerRow = player.getRow();

        for (int i=0; i<grid.getGrid().length; i++){
            if (playerCol == grid.getGrid()[i].getCol() && playerRow == grid.getGrid()[i].getRow()){
                grid.getGrid()[i].markCell();
            }
        }
    }


    public void saveFile (){
        try{save = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(save);
            bufferedWriter.write(String.valueOf(grid.getGrid()));
            
            bufferedWriter.flush();
            bufferedWriter.close();}
        catch (IOException ex){
            ex.getMessage();}
    }


    private void arrayToString (){
        for (Cell c: grid.getGrid()){
            c.toString();
            System.out.println(c.toString());
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
