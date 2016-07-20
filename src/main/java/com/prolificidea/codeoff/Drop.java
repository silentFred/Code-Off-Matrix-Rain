package com.prolificidea.codeoff;

import java.awt.*;
import java.util.Random;

public class Drop {

    public static final int MAX_LEN = 75;
    private Random rng = new Random();
    private int velocity, length, x, y, height;
    private char[][] text;

    Drop(int x, int y) {
        this.x = x;
        this.height = y;
        length = getRandomInteger(3, MAX_LEN);
        text = createContent(length);
        velocity = getRandomInteger(0, 6);
        this.y = (-1) * (length + getRandomInteger(1,10)) * Config.FONT_SIZE;
    }

    protected char[][] createContent(int length) {

        char[][] result = new char[length][1];

        for (int i = 0; i < result.length; i++) {
            result[i][0] = getRandomCharacter();
        }

        return result;
    }

    public void draw(Graphics2D g2) {
        int fontSize = g2.getFont().getSize();

        for (int i = 0; i < length; i++) {
            if (getRandomInteger(0, length) == i)
                text[i][0] = getRandomCharacter();
            if (i == length - 1)
                g2.setColor(new Color(39, 253, 80));
            else
                g2.setColor(new Color(39, 253, 80, (i * 2) ));
            g2.drawChars(text[i], 0, 1, x, y + (i * fontSize));
        }

        y += velocity;
    }

    public char getRandomCharacter() {
        return (char) ('ぁ' + (int) (Math.random() * 50));

    }

    public int getRandomInteger(int min, int max) {
        return rng.nextInt((max - min) + 1) + min;
    }

    public boolean isOffScreen() {
        return (y > this.height);
    }
}