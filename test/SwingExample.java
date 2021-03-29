package test;

import javax.swing.*;

public class SwingExample implements Runnable {
	public static void createAndShowGUI() {
        JFrame f = new JFrame("Hello, world!");
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void run() {
        createAndShowGUI();
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
