package edu.project2;

import java.util.Stack;
import org.jetbrains.annotations.NotNull;

public class SolverDFS {

    private SolverDFS() {

    }

    @SuppressWarnings("CyclomaticComplexity")
    public static void solverDfs(@NotNull Maze maze) {
        Cell[][] grid = maze.getGrid();
        //очищаем поле visited для BFS
        for (int i = 0; i < maze.getWidth(); i++) {
            for (int j = 0; j < maze.getHeight(); j++) {
                grid[i][j].setVisited(false);
            }
        }
        Coordinate start = maze.getStart();
        Coordinate finish = maze.getFinish();
        int currentX = start.x();
        int currentY = start.y();
        int finishX = finish.x();
        int finishY = finish.y();
        Cell currentCell = grid[currentX][currentY];

        Stack<Cell> path = new Stack<>();
        path.push(currentCell);

        while (!path.isEmpty()) {
            currentCell = path.peek();
            currentCell.setVisited(true);
            currentX = currentCell.getCoordinate().x();
            currentY = currentCell.getCoordinate().y();
            if (currentX == finishX && currentY == finishY) {
                while (!path.isEmpty()) {
                    path.pop().setPath(true);
                }
                break;
            }
            if (currentX > 0 && currentCell.getLeft() == Cell.Type.PASSAGE
            && !grid[currentX - 1][currentY].getVisited()) {
                path.add(grid[currentX - 1][currentY]);
                continue;
            }
            if (currentY > 0 && currentCell.getUp() == Cell.Type.PASSAGE
            && !grid[currentX][currentY - 1].getVisited()) {
                path.add(grid[currentX][currentY - 1]);
                continue;
            }
            if (currentX < maze.getWidth() - 1 && currentCell.getRight() == Cell.Type.PASSAGE
            && !grid[currentX + 1][currentY].getVisited()) {
                path.add(grid[currentX + 1][currentY]);
                continue;
            }
            if (currentY < maze.getHeight() - 1 && currentCell.getDown() == Cell.Type.PASSAGE
            && !grid[currentX][currentY + 1].getVisited()) {
                path.add(grid[currentX][currentY + 1]);
                continue;
            }
            path.pop();
        }
    }
}
