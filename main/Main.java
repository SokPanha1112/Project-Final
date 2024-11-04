package main;

import javax.swing.*;



public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close button work properly on window
        window.setResizable(false); //The window can't be resizeable
        window.setTitle("2D Game "); //Game Title

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); //The pack() method causes the window to be sized to fit the preferred size and layouts of its subcomponents.

        window.setLocationRelativeTo(null); //Doesn't set any location so the window will be in the middle of the screen
        window.setVisible(true); //so that we can see the window
        gamePanel.setUpGame();
        gamePanel.startGameThread(); //to start the thread in the main class
    }
}