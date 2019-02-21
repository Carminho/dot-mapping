package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {

    private Grid grid;
    private Player player;
    private Keyboard keyboard;


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
            case KeyboardEvent.KEY_LEFT:
            case KeyboardEvent.KEY_RIGHT:
            case KeyboardEvent.KEY_UP:
            case KeyboardEvent.KEY_DOWN:
            case KeyboardEvent.KEY_SPACE:
            case KeyboardEvent.KEY_S:
            case KeyboardEvent.KEY_L:
            default: System.out.println("something went wrong!");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
