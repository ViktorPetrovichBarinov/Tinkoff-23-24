package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;
public class solverDFSTest {

    @Test
    @DisplayName("решение при помощи BFS")
    void test1() {
        Random rand = new Random(1);
        Maze maze = new Maze(5, 5);
        MazeGenerator.startCoordinatesGenerator(maze, rand);
        MazeGenerator.mazeGenerator(maze, rand);
        solverDFS.solverDfs(maze);
        String test = maze.toString();

        assertThat(test).isEqualTo("▓▓▓▓▓▓▓▓▓▓▓\n" +
            "▓  * * *▓ ▓\n" +
            "▓ ▓ ▓▓▓ ▓ ▓\n" +
            "▓ ▓*▓ ▓* *▓\n" +
            "▓ ▓ ▓ ▓▓▓ ▓\n" +
            "▓ ▓*▓    *▓\n" +
            "▓▓▓ ▓▓▓▓▓ ▓\n" +
            "▓* *▓* *▓*▓\n" +
            "▓ ▓▓▓ ▓ ▓ ▓\n" +
            "▓* * *▓S▓F▓\n" +
            "▓▓▓▓▓▓▓▓▓▓▓\n");
    }
}
