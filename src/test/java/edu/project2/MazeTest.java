package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MazeTest {
    @Test
    @DisplayName("Maze конструктор")
    void test1() {
        Maze maze = new Maze(2, 2);

        Cell[][] grid = maze.getGrid();

        assertThat(maze.getHeight()).isEqualTo(2);
        assertThat(maze.getWidth()).isEqualTo(2);
        assertThat(maze.getCell(0, 0)).isEqualTo(grid[0][0]);

        maze.setStart(new Coordinate(0,0));
        assertThat(maze.getStart().x()).isEqualTo(0);
        assertThat(maze.getStart().y()).isEqualTo(0);

        maze.setFinish(new Coordinate(0,1));
        assertThat(maze.getFinish().x()).isEqualTo(0);
        assertThat(maze.getFinish().y()).isEqualTo(1);

        String output = maze.toString();

        assertThat(output).isEqualTo("▓▓▓▓▓\n" +
            "▓S▓ ▓\n" +
            "▓▓▓▓▓\n" +
            "▓F▓ ▓\n" +
            "▓▓▓▓▓\n");
    }


    @Test
    @DisplayName("Тест методов для StringBuildera")
    void test2() {
        StringBuilder test = new StringBuilder();

        Maze.wallAppend(test);
        assertThat(test.toString()).isEqualTo("▓");

        Maze.passageAppend(test);
        assertThat(test.toString()).isEqualTo("▓ ");

        Maze.startAppend(test);
        assertThat(test.toString()).isEqualTo("▓ S");

        Maze.finishAppend(test);
        assertThat(test.toString()).isEqualTo("▓ SF");

        Maze.pathAppend(test);
        assertThat(test.toString()).isEqualTo("▓ SF*");
    }


}
