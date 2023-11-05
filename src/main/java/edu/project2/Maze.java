package edu.project2;

import java.util.Random;

public class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;
    private Coordinate start;
    private Coordinate finish;

    public static void main(String[] args) {
        Maze maze = new Maze(40, 10);
        maze.setStart(new Coordinate(0,0));
        MazeGenerator.mazeGenerator(maze, new Random());
        solverBFS.solverBfs(maze);
        System.out.println(maze);
    }

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < height; i++) {
            if (i == 0) {
                wallAppend(string);
                for (int j = 0; j < width; j++) {
                    if (getCell(j, i).getUp() == Cell.Type.WALL) {
                        wallAppend(string);
                    } else {
                        passageAppend(string);
                    }
                    wallAppend(string);
                }
                string.append("\n");
            }

            if (getCell(0, i).getLeft() == Cell.Type.WALL) {
                wallAppend(string);
            } else {
                passageAppend(string);
            }
            for (int j = 0; j < width; j++) {

                if (start != null && i == start.y() && j == start.x()) {
                    startAppend(string);
                } else if (finish != null && i == finish.y() && j == finish.x()) {
                    finishAppend(string);
                } else if (grid[j][i].getPath()) {
                    pathAppend(string);
                } else {
                    passageAppend(string);
                }

                if (getCell(j, i).getRight() == Cell.Type.WALL) {
                    wallAppend(string);
                } else {
                    passageAppend(string);
                }
            }
            string.append("\n");

            wallAppend(string);
            for (int j = 0; j < width; j++) {
                if (getCell(j, i).getDown() == Cell.Type.WALL) {
                    wallAppend(string);
                } else {
                    passageAppend(string);
                }
                wallAppend(string);
            }
            string.append("\n");
        }
        return string.toString();
    }

    //добавляет стрингбилдеру символ сопоставляющийся стене в лабиринте
    public static void wallAppend(StringBuilder str) {
        str.append("▓");
    }

    //добавляет стрингбилдеру символ сопоставляющийся пустому пространству в лабиринте
    public static void passageAppend(StringBuilder str) {
        str.append(" ");
    }

    //добавляет стрингбилдеру символ сопоставляющийся старту в лабиринте
    public static void startAppend(StringBuilder str) {
            str.append("S");
    }

    //добавляет стрингбилдеру символ сопоставляющийся финишу в лабиринте
    public static void finishAppend(StringBuilder str) {
        str.append("F");
    }

    public static void pathAppend(StringBuilder str) {
        str.append("*");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Coordinate getStart() {
        return start;
    }

    public Coordinate getFinish() {
        return finish;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setStart(Coordinate start) {
        this.start = start;
    }

    public void setFinish(Coordinate finish) {
        this.finish = finish;
    }
}
