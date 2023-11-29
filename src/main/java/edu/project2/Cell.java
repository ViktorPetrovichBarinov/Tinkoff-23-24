package edu.project2;

public class Cell {
    public enum Type { WALL, PASSAGE }

    private Type up = Type.WALL;
    private Type right = Type.WALL;
    private Type left = Type.WALL;
    private Type down = Type.WALL;
    private Boolean visited = false;
    private final Coordinate coordinate;
    private Boolean path = false;

    public Cell(int x, int y) {
        coordinate = new Coordinate(x, y);
    }

    public Type getUp() {
        return up;
    }

    public Type getRight() {
        return right;
    }

    public Type getDown() {
        return down;
    }

    public Type getLeft() {
        return left;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Boolean getVisited() {
        return visited;
    }

    public Boolean getPath() {
        return path;
    }

    public void setUp(Type up) {
        this.up = up;
    }

    public void setRight(Type right) {
        this.right = right;
    }

    public void setDown(Type down) {
        this.down = down;
    }

    public void setLeft(Type left) {
        this.left = left;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public void setPath(Boolean path) {
        this.path = path;
    }
}
