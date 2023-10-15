package edu.hw1;

public class Task8 {
    private Task8() {
    }

    private static final int lengthOfChessBoard = 8;
    private static final int[] OFFSET_X = {-2, -1, 1, 2};
    private static final int[] OFFSET_Y = {-1, -2, -2, -1};

    /**
     * Метод проходиться по координатам Y и X пока не встретит 1,
     * потом начинает проверять все места куда может сходить данный конь
     *
     * @param chessBoard    - двумерный массив, заполненный 0 и 1.
     *                      0 - коня нет в клетке
     *                      1 - конь есть в клетке
     * @return              - true - если кони расставлены так, что никто никого не бьёт
     *                      - false в ином случае
     */
    @SuppressWarnings("MagicNumber")
    public static boolean knightBoardCapture(int[][] chessBoard) {
        for (int i = 1; i < lengthOfChessBoard; i++) {
            for (int j = 0; j < lengthOfChessBoard; j++) {
                if (chessBoard[i][j] == 1) {
                    if (checkCoordinates(chessBoard, j, i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }




    //если кони бьют друг друга, то true
    @SuppressWarnings("MagicNumber")
    private static boolean checkCoordinates(int[][] chessBoard, int coordX, int coordY) {
        int newX;
        int newY;
        for (int i = 0; i < 4; i++) {
            newX = coordX + OFFSET_X[i];
            newY = coordY + OFFSET_Y[i];
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8 && chessBoard[newY][newX] == 1) {
                return true;
            }
        }

        return false;
    }

}
