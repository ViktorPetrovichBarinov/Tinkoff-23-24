package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {

    @Test
    @DisplayName("Тест конструктора")
    void test1() {
        Cell test = new Cell(1, 0);

        assertThat(test.getCoordinate().x()).isEqualTo(1);
        assertThat(test.getCoordinate().y()).isEqualTo(0);
        assertThat(test.getUp()).isEqualTo(Cell.Type.WALL);
        assertThat(test.getRight()).isEqualTo(Cell.Type.WALL);
        assertThat(test.getDown()).isEqualTo(Cell.Type.WALL);
        assertThat(test.getLeft()).isEqualTo(Cell.Type.WALL);
        assertThat(test.getVisited()).isFalse();
        assertThat(test.getPath()).isFalse();
    }

    @Test
    @DisplayName("Тест сеттеров")
    void test2() {
        Cell test = new Cell(1, 0);

        test.setVisited(true);
        test.setPath(true);
        test.setUp(Cell.Type.PASSAGE);
        test.setRight(Cell.Type.PASSAGE);
        test.setDown(Cell.Type.PASSAGE);
        test.setLeft(Cell.Type.PASSAGE);

        assertThat(test.getUp()).isEqualTo(Cell.Type.PASSAGE);
        assertThat(test.getRight()).isEqualTo(Cell.Type.PASSAGE);
        assertThat(test.getDown()).isEqualTo(Cell.Type.PASSAGE);
        assertThat(test.getLeft()).isEqualTo(Cell.Type.PASSAGE);
        assertThat(test.getVisited()).isTrue();
        assertThat(test.getPath()).isTrue();
    }
}
