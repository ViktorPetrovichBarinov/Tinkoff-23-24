package edu.project2;

import java.util.LinkedList;
import java.util.Queue;
import org.jetbrains.annotations.NotNull;

public class SolverBFS {
    private SolverBFS() {

    }

    public static void solverBfs(@NotNull Maze maze) {
        Cell[][] grid = maze.getGrid();
        //очищаем поле visited для BFS
        for (int i = 0; i < maze.getWidth(); i++) {
            for (int j = 0; j < maze.getHeight(); j++) {
                grid[i][j].setVisited(false);
            }
        }
        int currentX = maze.getStart().x();
        int currentY = maze.getStart().y();
        Cell currentCell = grid[currentX][currentY];
        currentCell.setVisited(true);
        Queue<Cell> queue = new LinkedList<>();

        Coordinate[][] parents = new Coordinate[maze.getWidth()][maze.getHeight()];

        queue.add(currentCell);
        while (!queue.isEmpty()) {
            currentCell = queue.poll();
            LinkedList<Cell> neighbours = new LinkedList<>();
            currentX = currentCell.getCoordinate().x();
            currentY = currentCell.getCoordinate().y();


            if (currentX > 0 && currentCell.getLeft() == Cell.Type.PASSAGE) {
                neighbours.add(grid[currentX - 1][currentY]);
            }
            if (currentY > 0 && currentCell.getUp() == Cell.Type.PASSAGE) {
                neighbours.add(grid[currentX][currentY - 1]);
            }
            if (currentX < maze.getWidth() - 1 && currentCell.getRight() == Cell.Type.PASSAGE) {
                neighbours.add(grid[currentX + 1][currentY]);
            }
            if (currentY < maze.getHeight() - 1 && currentCell.getDown() == Cell.Type.PASSAGE) {
                neighbours.add(grid[currentX][currentY + 1]);
            }

            for (Cell neighbor : neighbours) {
                if (!neighbor.getVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                    parents[neighbor.getCoordinate().x()][neighbor.getCoordinate().y()] = currentCell.getCoordinate();
                }
            }
        }
        restorePathFromParentMatrix(parents, maze);
    }


    private static void restorePathFromParentMatrix(Coordinate[][] parents, Maze maze) {
        Coordinate startCoordinates = maze.getStart();
        Coordinate currentCoordinates = maze.getFinish();
        Cell[][] grid = maze.getGrid();
        while (currentCoordinates.x() != startCoordinates.x()
            || currentCoordinates.y() != startCoordinates.y()) {

            grid[currentCoordinates.x()][currentCoordinates.y()].setPath(true);
            currentCoordinates = parents[currentCoordinates.x()][currentCoordinates.y()];
        }
    }

}
