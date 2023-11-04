package edu.project2;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import static edu.project2.solverDFS.solverDfs;

public class MazeGenerator {



    public static void mazeGenerator(Maze maze, Random rand) {
        Cell[][] grid = maze.getGrid();
        int startX = maze.getStart().x();
        int startY = maze.getStart().y();


        Cell currentCell = grid[startX][startY];

        Stack<Cell> stack = new Stack<>();

        int maxLengthOfPath = 0;
        Cell finishCell = currentCell;
        currentCell.setVisited(true);
        do {
            LinkedList<Cell> unvisitedNeighbours = new LinkedList<>();

            int currentX = currentCell.getCoordinate().x();
            int currentY = currentCell.getCoordinate().y();

            if (currentX > 0 && !grid[currentX - 1][currentY].getVisited()) {
                unvisitedNeighbours.add(grid[currentX - 1][currentY]);
            }
            if (currentY > 0 && !grid[currentX][currentY - 1].getVisited()) {
                unvisitedNeighbours.add(grid[currentX][currentY - 1]);
            }
            if (currentX < maze.getWidth() - 1 && !grid[currentX + 1][currentY].getVisited()) {
                unvisitedNeighbours.add(grid[currentX + 1][currentY]);
            }
            if (currentY < maze.getHeight() - 1 && !grid[currentX][currentY + 1].getVisited()) {
                unvisitedNeighbours.add(grid[currentX][currentY + 1]);
            }

            if (!unvisitedNeighbours.isEmpty()) {
                int index = rand.nextInt(unvisitedNeighbours.size());
                Cell chosenCell = unvisitedNeighbours.get(index);

                removeWall(currentCell, chosenCell);

                chosenCell.setVisited(true);
                stack.push(chosenCell);
                currentCell = chosenCell;

                if (stack.size() > maxLengthOfPath) {
                    maxLengthOfPath = stack.size();
                    finishCell = currentCell;
                }
            } else {
                currentCell = stack.pop();
            }

        } while (!stack.isEmpty());

        maze.setFinish(finishCell.getCoordinate());
    }

    public static void removeWall(Cell cell1, Cell cell2) {
        int x1 = cell1.getCoordinate().x();
        int y1 = cell1.getCoordinate().y();
        int x2 = cell2.getCoordinate().x();
        int y2 = cell2.getCoordinate().y();
        Cell.Type passage = Cell.Type.PASSAGE;
        if (x1 == x2) {
            if (y1 > y2) {
                cell1.setUp(passage);
                cell2.setDown(passage);
            } else {
                cell1.setDown(passage);
                cell2.setUp(passage);
            }
        } else {
            if (x1 < x2) {
                cell1.setRight(passage);
                cell2.setLeft(passage);
            } else {
                cell1.setLeft(passage);
                cell2.setRight(passage);
            }
        }
    }

    //стартовая координата будет где-то скраю
    public static void startCoordinatesGenerator(Maze maze, Random rand) {

        int randomNumber = rand.nextInt(4);
        int x = -1;
        int y = -1;
        switch (randomNumber) {
            //сверху
            case 0:
                y = 0;
                x = rand.nextInt(maze.getWidth());
                break;
            //справа
            case 1:
                y = rand.nextInt(maze.getHeight());
                x = maze.getWidth() - 1;
                break;
            //снизу
            case 2:
                y = maze.getHeight() - 1;
                x = rand.nextInt(maze.getWidth());
                break;
            //слева
            case 3:
                y = rand.nextInt(maze.getHeight());
                x = 0;
        }
        Coordinate start = new Coordinate(x, y);
        maze.setStart(start);
    }
}
