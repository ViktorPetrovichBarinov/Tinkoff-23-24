package edu.project2;

import static edu.project2.MazeGenerator.mazeGenerator;
import static edu.project2.MazeGenerator.startCoordinatesGenerator;
import static edu.project2.solverBFS.solverBfs;
import static edu.project2.solverDFS.solverDfs;

public class Maze {
    private final int height;
    private final int width;
    private final Cell[][] grid;
    private Coordinate start;
    private Coordinate finish;


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

    public static void main(String[] args) {
        Maze maze = new Maze(30, 5);
        startCoordinatesGenerator(maze);
        mazeGenerator(maze);
        maze.mazePrinter();
        solverDfs(maze);
        maze.mazePrinter();
    }
    public void mazePrinter() {
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
        System.out.println(string);
    }


    //добавляет стрингбилдеру символ сопоставляющийся стене в лабиринте
    public static void wallAppend(StringBuilder str) {
        str.append("\033[31m▓\033[0m");
    }

    //добавляет стрингбилдеру символ сопоставляющийся пустому пространству в лабиринте
    public static void passageAppend(StringBuilder str) {
        str.append(" ");
    }

    //добавляет стрингбилдеру символ сопоставляющийся старту в лабиринте
    public static void startAppend(StringBuilder str) {
        str.append("\033[94mS\033[0m");
    }

    //добавляет стрингбилдеру символ сопоставляющийся финишу в лабиринте
    public static void finishAppend(StringBuilder str) {
        str.append("\033[92mF\033[0m");
    }

    public static void pathAppend(StringBuilder str) {
        str.append("\033[97m*\033[0m");
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
