package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

public class Game implements KeyboardHandler {

    private final String FILE_PATH = "resources/save";

    private Grid grid;
    private Player player;
    private Keyboard keyboard;
    private FileWriter save;
    private FileReader load;



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



    private void paintCell (){
        int playerCol = player.getCol();
        int playerRow = player.getRow();

        for (int i=0; i<grid.getGrid().length; i++){
            if (playerCol == grid.getGrid()[i].getCol() && playerRow == grid.getGrid()[i].getRow()){
                grid.getGrid()[i].markCell();
            }
        }
    }



    private String file (){
        String str = "";
        for (int i=0; i<grid.getGrid().length; i++){
            if (grid.getGrid()[i].isPainted()){
                str += "1";}
            else {str += "0";}
        }
        System.out.println(str);
        return str;
    }



    private void saveFile (){
        try{save = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(save);
            bufferedWriter.write(file());
            bufferedWriter.flush();
            bufferedWriter.close();}
        catch (IOException ex){
            ex.getMessage();}
    }




    private void loadFile (){
        try{load = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(load);
            String line = "";
            String result = "";

            while((line = bufferedReader.readLine()) != null) {
                result += line + "\n";}
            System.out.println(result);

            for (int i=0; i<grid.getGrid().length; i++){ ;
                if (result.charAt(i) == '1'){                       //lógica contrária do jogo. no jogo, quando !isPainted pinta de preto e vice-versa. Quando carregamos, a lógica é contrária.
                    grid.getGrid()[i].setUnpainted();
                    grid.getGrid()[i].markCell();continue;}
                if (result.charAt(i) == '0'){
                    grid.getGrid()[i].setPainted();
                    grid.getGrid()[i].markCell();}
                System.out.println(grid.getGrid()[i]);
            }

        }
        catch (FileNotFoundException ex){
            ex.getMessage();}
        catch (IOException ex2){
            ex2.getMessage();}
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
            case KeyboardEvent.KEY_L: loadFile();break;
            default: System.out.println("this key doesn't apply in this game!");
        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
