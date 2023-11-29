package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;
public class MazeGeneratorTest {

    @Test
    @DisplayName("startCoordinatesGenerator")
    void test1() {
        Maze maze = new Maze(2, 2);
        MazeGenerator.startCoordinatesGenerator(maze, new Random(1));

        assertThat(maze.getStart().x()).isEqualTo(0);
        assertThat(maze.getStart().y()).isEqualTo(1);

        maze = new Maze(2, 2);
        MazeGenerator.startCoordinatesGenerator(maze, new Random(3));

        assertThat(maze.getStart().x()).isEqualTo(1);
        assertThat(maze.getStart().y()).isEqualTo(1);
    }

    @Test
    @DisplayName("Удаление стен у двух соседних клеток по вертикале")
    void test2() {
        Cell cell1 = new Cell(0, 1);
        Cell cell2 = new Cell(0, 2);

        MazeGenerator.removeWall(cell1, cell2);
        assertThat(cell1.getDown()).isEqualTo(Cell.Type.PASSAGE);
        assertThat(cell2.getUp()).isEqualTo(Cell.Type.PASSAGE);
    }

    @Test
    @DisplayName("Удаление стен у двух соседних клеток по горизоонтале")
    void test3() {
        Cell cell1 = new Cell(1, 0);
        Cell cell2 = new Cell(2, 0);

        MazeGenerator.removeWall(cell1, cell2);
        assertThat(cell1.getRight()).isEqualTo(Cell.Type.PASSAGE);
        assertThat(cell2.getLeft()).isEqualTo(Cell.Type.PASSAGE);
    }

    @Test
    @DisplayName("Генерирование по заданному рандому")
    void test4() {
        Maze maze = new Maze(5, 5);

        maze.setStart(new Coordinate(0,0));

        MazeGenerator.mazeGenerator(maze, new Random(1));
        assertThat(maze.toString()).isEqualTo("▓▓▓▓▓▓▓▓▓▓▓\n" +
                                                        "▓S▓       ▓\n" +
                                                        "▓ ▓▓▓ ▓▓▓ ▓\n" +
                                                        "▓     ▓ ▓ ▓\n" +
                                                        "▓▓▓▓▓▓▓ ▓ ▓\n" +
                                                        "▓F  ▓   ▓ ▓\n" +
                                                        "▓▓▓ ▓ ▓ ▓ ▓\n" +
                                                        "▓   ▓ ▓   ▓\n" +
                                                        "▓ ▓▓▓ ▓▓▓▓▓\n" +
                                                        "▓         ▓\n" +
                                                        "▓▓▓▓▓▓▓▓▓▓▓\n");
    }
}
