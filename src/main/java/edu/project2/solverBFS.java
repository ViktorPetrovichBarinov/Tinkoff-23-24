package edu.project2;



import java.util.LinkedList;
import java.util.Queue;
import static edu.project2.MazeGenerator.mazeGenerator;
import static edu.project2.MazeGenerator.startCoordinatesGenerator;

public class solverBFS {

    public static void solverBfs (Maze maze) {
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
        while(!queue.isEmpty()) {
            currentCell = queue.poll();
            LinkedList<Cell> Neighbours = new LinkedList<>();
            currentX = currentCell.getCoordinate().x();
            currentY = currentCell.getCoordinate().y();


            if (currentX > 0 && currentCell.getLeft() == Cell.Type.PASSAGE) {
                Neighbours.add(grid[currentX - 1][currentY]);
            }
            if (currentY > 0 && currentCell.getUp() == Cell.Type.PASSAGE) {
                Neighbours.add(grid[currentX][currentY - 1]);
            }
            if (currentX < maze.getWidth() - 1 && currentCell.getRight() == Cell.Type.PASSAGE) {
                Neighbours.add(grid[currentX + 1][currentY]);
            }
            if (currentY < maze.getHeight() - 1 && currentCell.getDown() == Cell.Type.PASSAGE) {
                Neighbours.add(grid[currentX][currentY + 1]);
            }

            for (Cell neighbor : Neighbours) {
                if(!neighbor.getVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                    parents[neighbor.getCoordinate().x()][neighbor.getCoordinate().y()] = currentCell.getCoordinate();
                }
            }
        }
        restorePathFromParentMatrix(parents, maze);
    }


    public static void restorePathFromParentMatrix(Coordinate[][] parents, Maze maze) {
        Coordinate startCoordinates = maze.getStart();
        Coordinate currentCoordinates = maze.getFinish();
        Cell[][] grid = maze.getGrid();
        while(currentCoordinates.x() != startCoordinates.x()
            || currentCoordinates.y() != startCoordinates.y()) {

            grid[currentCoordinates.x()][currentCoordinates.y()].setPath(true);
            currentCoordinates = parents[currentCoordinates.x()][currentCoordinates.y()];
        }
    }

}
