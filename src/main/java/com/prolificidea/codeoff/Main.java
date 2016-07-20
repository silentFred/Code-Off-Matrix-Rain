package com.prolificidea.codeoff;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class Main {

    private static final KeyStroke escapeStroke =
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
    public static final String dispatchWindowClosingActionMapKey =
            "com.spodding.tackline.dispatch:WINDOW_CLOSING";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Make it Rain");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(true);

        installEscapeCloseOperation(frame);

        Rain comp = new Rain(frame.getSize().getHeight(), frame.getSize().getWidth());

        comp.setBackground(Color.black);
        frame.add(comp);
        frame.setBackground(Color.black);
        frame.setVisible(true);
    }

    public static void installEscapeCloseOperation(final JFrame dialog) {
        Action dispatchClosing = new AbstractAction() {
            public void actionPerformed(ActionEvent event) {
                dialog.dispatchEvent(new WindowEvent(
                        dialog, WindowEvent.WINDOW_CLOSING
                ));
            }
        };

        JRootPane root = dialog.getRootPane();
        root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                escapeStroke, dispatchWindowClosingActionMapKey
        );
        root.getActionMap().put(dispatchWindowClosingActionMapKey, dispatchClosing
        );
    }
}