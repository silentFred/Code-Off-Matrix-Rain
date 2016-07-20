package com.prolificidea.codeoff;

import javax.swing.*;
import java.awt.*;

public class Rain extends JPanel {

    private Drop[] drops;
    private double drawSizeHeight;
    private double drawSizeWidth;

    public Rain(double height, double width) {


        setDrawSizeHeight(height);
        setDrawSizeWidth(width);

        drops = new Drop[(int) (drawSizeWidth / Config.FONT_SIZE)];
        for (int i = 0; i < drops.length; i++) {
            drops[i] = new Drop(i * Config.FONT_SIZE, (int) drawSizeHeight);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.black);

        ((Graphics2D) g).setBackground(Color.black);

        g.fillRect(0, 0, (int) drawSizeHeight, (int) drawSizeWidth);

        g.setColor(Color.black);

        Font font = new Font("Monospaced", Font.PLAIN, Config.FONT_SIZE);

        g2.setFont(font);

        g2.setBackground(Color.black);

        for (int i = 0; i < drops.length; i++) {
            if (drops[i].isOffScreen()) {
                drops[i] = new Drop(i * Config.FONT_SIZE, (int) drawSizeHeight);
            }
            drops[i].draw(g2);
        }

        try {
            Thread.sleep(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        repaint();
    }

    public void setDrawSizeHeight(double drawSize) {
        this.drawSizeHeight = drawSize;
    }

    public void setDrawSizeWidth(double drawSizeWidth) {
        this.drawSizeWidth = drawSizeWidth;
    }
}
