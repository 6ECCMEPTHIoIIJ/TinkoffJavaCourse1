package edu.hw2.task2;

public class Rectangle {
    private final int height;
    private final int wight;

    public Rectangle(int height, int wight) {
        this.height = height;
        this.wight = wight;
    }

    public int getHeight() {
        return height;
    }

    public int getWight() {
        return wight;
    }

    public Rectangle setHeight(int height) {
        return new Rectangle(height, wight);
    }

    public Rectangle setWidth(int width) {
        return new Rectangle(height, width);
    }

    public long getArea() {
        return (long) height * wight;
    }
}
