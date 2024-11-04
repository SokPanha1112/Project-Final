package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener { //when we implemetn this method the three override key will be needed
    @Override
    public void keyTyped(KeyEvent e) {

    }
    public boolean rightPressed, moveLeft, upPressed, downPressed;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //This method is used to determine which key was pressed or released during a keyboard event.
        if (code == KeyEvent.VK_W) {
            upPressed = true;

        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;

        }
        if (code == KeyEvent.VK_A) {
            moveLeft = true;

        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;

        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;

        }
        if (code == KeyEvent.VK_A) {
            moveLeft = false;

        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;

        }

    }
}
